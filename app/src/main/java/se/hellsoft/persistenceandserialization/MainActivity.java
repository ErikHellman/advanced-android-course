package se.hellsoft.persistenceandserialization;

import android.graphics.BitmapFactory;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.support.annotation.WorkerThread;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.AsyncTaskLoader;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<List<Item>> {

    private ItemAdapter itemAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView itemList = (RecyclerView) findViewById(R.id.item_list);
        itemList.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        itemAdapter = new ItemAdapter();
        itemList.setAdapter(itemAdapter);

        getSupportLoaderManager().initLoader(1, null, this).forceLoad();
    }

    @WorkerThread
    private List<Item> loadItems() {
        SystemClock.sleep(2000); // Artificial delay...
        List<Item> items = new ArrayList<>(20);
        for (int i = 0; i < 20; i++) {
            Item item = new Item();
            item.title = "Photo " + (i + 1);
            item.owner = "Erik";
            item.timestamp = new Date();
            item.photo = BitmapFactory.decodeResource(getResources(), getPhoto(i % 4));
            items.add(item);
        }
        return items;
    }

    private int getPhoto(int i) {
        switch (i) {
            default:
            case 0:
                return R.drawable.photo1;
            case 1:
                return R.drawable.photo2;
            case 2:
                return R.drawable.photo3;
            case 3:
                return R.drawable.photo4;
        }
    }

    @Override
    public Loader<List<Item>> onCreateLoader(int id, Bundle args) {
        return new AsyncTaskLoader<List<Item>>(this) {
            @Override
            public List<Item> loadInBackground() {
                return loadItems();
            }
        };
    }

    @Override
    public void onLoadFinished(Loader<List<Item>> loader, List<Item> items) {
        if (items != null) {
            itemAdapter.setItems(items);
            itemAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void onLoaderReset(Loader<List<Item>> loader) {
        itemAdapter.setItems(Collections.<Item>emptyList());
        itemAdapter.notifyDataSetChanged();
    }

    private class ItemAdapter extends RecyclerView.Adapter<ItemViewHolder> {
        private List<Item> items = Collections.emptyList();
        private DateFormat dateFormat = SimpleDateFormat.getDateInstance();

        @Override
        public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
            return new ItemViewHolder(view);
        }

        @Override
        public void onBindViewHolder(ItemViewHolder holder, int position) {
            Item item = items.get(position);
            holder.title.setText(item.title);
            holder.timestamp.setText(dateFormat.format(item.timestamp));
            holder.photo.setImageBitmap(item.photo);
        }

        @Override
        public int getItemCount() {
            return items.size();
        }

        public void setItems(@NonNull List<Item> items) {
            this.items = items;
        }
    }

    private class ItemViewHolder extends RecyclerView.ViewHolder {
        public TextView title;
        public TextView timestamp;
        public ImageView photo;

        public ItemViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.title);
            timestamp = (TextView) itemView.findViewById(R.id.timestamp);
            photo = (ImageView) itemView.findViewById(R.id.photo);
        }
    }
}

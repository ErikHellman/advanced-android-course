package se.hellsoft.multithreadingandconcurrency;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import se.hellsoft.multithreadingandconcurrency.model.FakeRepository;
import se.hellsoft.multithreadingandconcurrency.model.Task;

public class MainActivity extends AppCompatActivity {
    private TaskListAdapter taskListAdapter;
    private List<Task> taskList = new ArrayList<>(); // Default empty

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        if (fab != null) {
            fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(new Intent(MainActivity.this, TaskActivity.class));
                }
            });
        }

        RecyclerView taskList = (RecyclerView) findViewById(R.id.list_of_tasks);
        //noinspection ConstantConditions
        taskList.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        taskList.setHasFixedSize(true);
        taskListAdapter = new TaskListAdapter();
        taskList.setAdapter(taskListAdapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        setTaskList(FakeRepository.getInstance().getTasks());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    public void setTaskList(List<Task> taskList) {
        this.taskList = taskList;
        taskListAdapter.notifyDataSetChanged();
    }

    private class TaskListAdapter extends RecyclerView.Adapter<TaskViewHolder> {
        @Override
        public TaskViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new TaskViewHolder(View.inflate(MainActivity.this, R.layout.task_item, null));
        }

        @Override
        public void onBindViewHolder(TaskViewHolder holder, int position) {
            Task task = taskList.get(position);
            holder.title.setText(task.title);
            holder.description.setText(task.description);
        }

        @Override
        public int getItemCount() {
            return taskList.size();
        }
    }

    private class TaskViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public final TextView title;
        public final TextView description;

        public TaskViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.title);
            description = (TextView) itemView.findViewById(R.id.description);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Intent taskDetail = new Intent(MainActivity.this, TaskActivity.class);
            taskDetail.putExtra(TaskActivity.EXTRA_TASK_ID, taskList.get(getAdapterPosition()).id);
            startActivity(taskDetail);
        }
    }
}

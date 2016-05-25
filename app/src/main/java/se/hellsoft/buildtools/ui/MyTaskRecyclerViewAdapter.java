package se.hellsoft.buildtools.ui;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.util.List;

import se.hellsoft.buildtools.R;
import se.hellsoft.buildtools.backend.Backend;
import se.hellsoft.buildtools.model.Task;

class MyTaskRecyclerViewAdapter extends RecyclerView.Adapter<MyTaskRecyclerViewAdapter.ViewHolder> {

  private List<Task> tasks;

  MyTaskRecyclerViewAdapter() {
    try {
      tasks = Backend.getInstance().fetchTasks();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @Override
  public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(parent.getContext())
        .inflate(R.layout.task_item, parent, false);
    return new ViewHolder(view);
  }

  @Override
  public void onBindViewHolder(final ViewHolder holder, int position) {
    final Task task = tasks.get(position);
    holder.task = task;
    holder.titleView.setText(task.title);
    holder.contentView.setText(task.description);
    holder.completedView.setVisibility(task.completed ? View.VISIBLE : View.INVISIBLE);
    holder.view.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        try {
          task.completed = !task.completed;
          Backend.getInstance().updateTask(task);
          notifyItemChanged(holder.getAdapterPosition());
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    });
  }

  @Override
  public int getItemCount() {
    return tasks.size();
  }

  class ViewHolder extends RecyclerView.ViewHolder {
    final View view;
    final TextView titleView;
    final TextView contentView;
    final ImageView completedView;

    Task task;

    ViewHolder(View view) {
      super(view);
      this.view = view;
      this.titleView = (TextView) view.findViewById(R.id.title);
      this.contentView = (TextView) view.findViewById(R.id.description);
      this.completedView = (ImageView) view.findViewById(R.id.completed);
    }

    @Override
    public String toString() {
      return super.toString() + " '" + contentView.getText() + "'";
    }
  }
}

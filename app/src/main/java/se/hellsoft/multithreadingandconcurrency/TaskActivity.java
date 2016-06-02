package se.hellsoft.multithreadingandconcurrency;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import se.hellsoft.multithreadingandconcurrency.model.FakeRepository;
import se.hellsoft.multithreadingandconcurrency.model.Task;

public class TaskActivity extends BaseActivity {
    public static final String EXTRA_TASK_ID = "taskId";
    private Task task;
    private TextView titleView;
    private TextView descriptionView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task);
        titleView = (TextView) findViewById(R.id.title);
        descriptionView = (TextView) findViewById(R.id.description);
        long taskId;
        if (savedInstanceState == null) {
            taskId = getIntent().getLongExtra(EXTRA_TASK_ID, -1);
        } else {
            taskId = savedInstanceState.getLong(EXTRA_TASK_ID, -1);
        }
        loadTask(taskId);
    }

    private void loadTask(long taskId) {
        if (taskId != -1) {
            task = repository.getTask(taskId);
            if (task == null) {
                finish();
            } else {
                titleView.setText(task.title);
                descriptionView.setText(task.description);
            }
        } else {
            task = new Task();
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putLong(EXTRA_TASK_ID, task.id);
    }

    public void doSaveTask(View view) {
        task.title = titleView.getText().toString();
        task.description = descriptionView.getText().toString();
        repository.saveTask(task);
        finish();
    }


    public void doDelete(View view) {
        repository.deleteTask(task);
        finish();
    }
}

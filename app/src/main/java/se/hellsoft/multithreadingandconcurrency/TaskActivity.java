package se.hellsoft.multithreadingandconcurrency;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import javax.inject.Inject;

import se.hellsoft.multithreadingandconcurrency.model.Task;

public class TaskActivity extends BaseActivity implements TaskContract.View {
    public static final String EXTRA_TASK_ID = "taskId";
    @Inject
    TaskContract.Presenter presenter;
    private Task task;
    private TextView titleView;
    private TextView descriptionView;
    private long taskId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((MyApp) getApplication()).getPresenterComponent().inject(this);
        setContentView(R.layout.activity_task);
        titleView = (TextView) findViewById(R.id.title);
        descriptionView = (TextView) findViewById(R.id.description);
        if (savedInstanceState == null) {
            taskId = getIntent().getLongExtra(EXTRA_TASK_ID, -1);
        } else {
            taskId = savedInstanceState.getLong(EXTRA_TASK_ID, -1);
        }

//        loadTask(taskId);
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.start(this);
        presenter.loadTask(taskId);
    }

    @Override
    protected void onPause() {
        super.onPause();
        presenter.stop();
    }

    /*
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
*/

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putLong(EXTRA_TASK_ID, task.id);
    }

    public void doSaveTask(View view) {
        task.title = titleView.getText().toString();
        task.description = descriptionView.getText().toString();
        presenter.saveTask(task);
    }


    public void doDelete(View view) {
//        repository.deleteTask(task);
//        finish();
        presenter.deleteTask(task);
    }

    @Override
    public void showTask(Task task) {
        this.task = task;
        titleView.setText(task.title);
        descriptionView.setText(task.description);
    }

    @Override
    public void complete() {
        finish();
    }
}

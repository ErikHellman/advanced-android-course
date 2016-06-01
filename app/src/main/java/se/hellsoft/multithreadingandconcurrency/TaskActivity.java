package se.hellsoft.multithreadingandconcurrency;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.MainThread;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.AsyncTaskLoader;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import se.hellsoft.multithreadingandconcurrency.model.FakeRepository;
import se.hellsoft.multithreadingandconcurrency.model.Task;

public class TaskActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<Task> {
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

        Bundle args = new Bundle();
        args.putLong("taskId", taskId);
        getSupportLoaderManager().initLoader(2, args, this).forceLoad();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putLong(EXTRA_TASK_ID, task.id);
    }

    public void doSaveTask(View view) {
        task.title = titleView.getText().toString();
        task.description = descriptionView.getText().toString();
        Intent saveTaskIntent = new Intent(this, MyService.class);
        saveTaskIntent.setAction(MyService.ACTION_SAVE);
        saveTaskIntent.putExtra("task", task);
        startService(saveTaskIntent);
        finish();
    }


    public void doDelete(View view) {
        Intent deleteTaskIntent = new Intent(this, MyService.class);
        deleteTaskIntent.setAction(MyService.ACTION_DELETE);
        deleteTaskIntent.putExtra("task", task);
        startService(deleteTaskIntent);
        finish();
    }

    @Override
    public Loader<Task> onCreateLoader(int id, final Bundle args) {
        return new AsyncTaskLoader<Task>(this) {
            @Override
            public Task loadInBackground() {
                long taskId = args.getLong("taskId", -1);
                if (taskId != -1) {
                    return FakeRepository.getInstance().getTask(taskId);
                }
                return null;
            }
        };
    }

    @Override
    public void onLoadFinished(Loader<Task> loader, Task data) {
        if (data != null) {
            this.task = data;
            titleView.setText(task.title);
            descriptionView.setText(task.description);
        } else {
            finish();
        }
    }

    @Override
    public void onLoaderReset(Loader<Task> loader) {
        finish();
    }
}

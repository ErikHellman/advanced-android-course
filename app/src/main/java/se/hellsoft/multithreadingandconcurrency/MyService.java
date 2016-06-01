package se.hellsoft.multithreadingandconcurrency;

import android.app.IntentService;
import android.content.Intent;

import se.hellsoft.multithreadingandconcurrency.model.FakeRepository;
import se.hellsoft.multithreadingandconcurrency.model.Task;


public class MyService extends IntentService {
    public static final String ACTION_SAVE = "se.hellsoft.action.SAVE_TASK";
    public static final String ACTION_DELETE = "se.hellsoft.action.DELETE_TASK";

    public MyService() {
        super("MyService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        String action = intent.getAction();
        Task task = intent.getParcelableExtra("task");
        if(ACTION_SAVE.equals(action)) {
            FakeRepository.getInstance().saveTask(task);
        } else if (ACTION_DELETE.equals(action)) {
            FakeRepository.getInstance().deleteTask(task);
        }
    }
}

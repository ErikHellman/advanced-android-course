package se.hellsoft.buildtools.backend;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import se.hellsoft.buildtools.model.Task;

public class Backend {
    private static final String[] TITLES = new String[]{"Laundry", "Shopping food", "Bills", "Garden", "Kids"};
    private static final String[] DESCRIPTIONS = new String[]{
            "Clean all the white clothes",
            "Buy milk, cheese and ham",
            "Electric bill, rent and car insurance",
            "Trim hedges",
            "Pick up from kindergarten!"};
    private static final String BASE_URL = "http://my.backend.com";
    private static Backend sInstance;

    // Not used for now, as this implementation is fake
    @SuppressWarnings({"FieldCanBeLocal", "unused"})
    private String baseUrl;
    private List<Task> tasks;

    private Backend(String baseUrl) {
        this.baseUrl = baseUrl;
        tasks = new ArrayList<>();
        for (int i = 0; i < TITLES.length; i++) {
            Task task = new Task();
            task.id = i * 1000;
            task.title = TITLES[i];
            task.description = DESCRIPTIONS[i];
            task.completed = false;
            tasks.add(task);
        }
    }

    public synchronized static Backend getInstance() {
        if (sInstance == null) {
            sInstance = new Backend(BASE_URL);
        }
        return sInstance;
    }

    public Task updateTask(Task task) throws IOException {
        for (Task existingTask : tasks) {
            if (existingTask.id == task.id) {
                existingTask.title = task.title;
                existingTask.description = task.description;
                existingTask.completed = task.completed;
                return existingTask;
            }
        }
        return null;
    }

    public List<Task> fetchTasks() throws IOException {
        return tasks;
    }
}

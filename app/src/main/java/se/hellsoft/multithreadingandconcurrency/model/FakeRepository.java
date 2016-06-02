package se.hellsoft.multithreadingandconcurrency.model;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class FakeRepository implements Repository {
    public static final int SIX_SECONDS = 6000;
    private static FakeRepository INSTANCE;
    private final HashMap<Long, Task> tasks;

    private FakeRepository() {
        tasks = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            Task task = new Task();
            task.id = (long) (i * 1000);
            task.title = "Title " + (i + 1);
            task.description = "Description of a task.";
            task.completed = false;
            tasks.put(task.id, task);
        }
    }

    public synchronized static FakeRepository getInstance(String httpUrl, String apiPath) {
        if (INSTANCE == null) {
            INSTANCE = new FakeRepository();
        }
        return INSTANCE;
    }

    @Override
    @Nullable
    public Task getTask(@NonNull Long id) {
        return tasks.get(id);
    }

    @NonNull
    @Override
    public List<Task> getTasks() {
        ArrayList<Task> tasks = new ArrayList<>(this.tasks.values());
        Collections.sort(tasks, new Comparator<Task>() {
            @Override
            public int compare(Task lhs, Task rhs) {
                return lhs.title.compareTo(rhs.title);
            }
        });
        return tasks;
    }

    @Override
    public void saveTask(@NonNull Task task) {
        if (task.id == null) {
            Long newId = 0L;
            for (Long id : tasks.keySet()) {
                newId = id > newId ? id : newId;
            }
            newId++;
            task.id = newId;
        }
        tasks.put(task.id, task);

    }

    @Override
    public void deleteTask(@NonNull Task task) {
        tasks.remove(task.id);
    }

}

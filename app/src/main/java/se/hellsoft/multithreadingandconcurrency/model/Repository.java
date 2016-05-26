package se.hellsoft.multithreadingandconcurrency.model;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.util.List;

public interface Repository {

    @Nullable
    Task getTask(@NonNull Long id);

    @NonNull
    List<Task> getTasks();

    void saveTask(@NonNull Task task);

    void deleteTask(@NonNull Task task);
}

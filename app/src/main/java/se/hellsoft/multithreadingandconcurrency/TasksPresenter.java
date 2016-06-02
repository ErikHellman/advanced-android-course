package se.hellsoft.multithreadingandconcurrency;

import java.util.List;

import se.hellsoft.multithreadingandconcurrency.model.Repository;
import se.hellsoft.multithreadingandconcurrency.model.Task;

public class TasksPresenter implements TasksContract.Presenter {
    private TasksContract.View view;
    private Repository repository;

    public TasksPresenter(Repository repository) {
        this.repository = repository;
    }

    @Override
    public void start(TasksContract.View view) {
        this.view = view;
    }

    @Override
    public void loadTasks() {
        List<Task> tasks = repository.getTasks();
        if (view != null) {
            view.showTasks(tasks);
        }
    }

    @Override
    public void stop() {
        view = null;
    }
}

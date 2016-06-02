package se.hellsoft.multithreadingandconcurrency;

import se.hellsoft.multithreadingandconcurrency.model.Repository;
import se.hellsoft.multithreadingandconcurrency.model.Task;

public class TaskPresenter implements TaskContract.Presenter {
    private Repository repository;
    private TaskContract.View view;

    public TaskPresenter(Repository repository) {
        this.repository = repository;
    }

    @Override
    public void start(TaskContract.View view) {
        this.view = view;
    }

    @Override
    public void loadTask(Long taskId) {
        Task task = repository.getTask(taskId);
        view.showTask(task);
    }

    @Override
    public void saveTask(Task task) {
        repository.saveTask(task);
        view.complete();
    }

    @Override
    public void deleteTask(Task task) {
        repository.deleteTask(task);
        view.complete();
    }

    @Override
    public void stop() {
        view = null;
    }
}

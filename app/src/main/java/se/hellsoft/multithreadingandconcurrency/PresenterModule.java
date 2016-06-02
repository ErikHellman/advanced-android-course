package se.hellsoft.multithreadingandconcurrency;

import dagger.Module;
import dagger.Provides;
import se.hellsoft.multithreadingandconcurrency.model.Repository;

@Module
public class PresenterModule {
    private Repository repository;

    public PresenterModule(Repository repository) {
        this.repository = repository;
    }

    @Provides
    public TasksContract.Presenter provideTasksPresenter() {
        return new TasksPresenter(repository);
    }

    @Provides
    public TaskContract.Presenter provideTaskPresenter() {
        return new TaskPresenter(repository);
    }
}

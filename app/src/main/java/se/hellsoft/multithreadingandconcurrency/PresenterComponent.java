package se.hellsoft.multithreadingandconcurrency;

import dagger.Component;

@Component(modules = PresenterModule.class)
public interface PresenterComponent {
    void inject(MainActivity mainActivity);
    void inject(TaskActivity taskActivity);
}

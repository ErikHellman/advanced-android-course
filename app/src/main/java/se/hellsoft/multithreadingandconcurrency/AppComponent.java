package se.hellsoft.multithreadingandconcurrency;

import dagger.Component;

@Component(modules = AppModule.class)
public interface AppComponent {
    void inject(BaseActivity baseActivity);

}

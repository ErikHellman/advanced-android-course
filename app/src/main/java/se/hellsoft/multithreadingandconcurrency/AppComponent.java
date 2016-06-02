package se.hellsoft.multithreadingandconcurrency;

import javax.inject.Singleton;

import dagger.Component;
import se.hellsoft.multithreadingandconcurrency.model.Repository;

@Singleton
@Component(modules = AppModule.class)
public interface AppComponent {
    Repository repository();
}

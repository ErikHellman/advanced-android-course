package se.hellsoft.multithreadingandconcurrency;

import dagger.Module;
import dagger.Provides;
import se.hellsoft.multithreadingandconcurrency.model.FakeRepository;
import se.hellsoft.multithreadingandconcurrency.model.Repository;

@Module
public class AppModule {

    @Provides
    public Repository provideRepository() {
        return FakeRepository.getInstance();
    }
}

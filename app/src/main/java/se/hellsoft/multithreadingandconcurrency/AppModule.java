package se.hellsoft.multithreadingandconcurrency;

import android.app.AlarmManager;
import android.content.Context;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import se.hellsoft.multithreadingandconcurrency.model.FakeRepository;
import se.hellsoft.multithreadingandconcurrency.model.Repository;

@Module
public class AppModule {

    @Singleton
    @Provides
    public Repository provideRepository(@Named("httpUrl") String httpUrl,
                                        @Named("apiPath") String apiPath) {
        return FakeRepository.getInstance(httpUrl, apiPath);
    }

    @Singleton
    @Provides
    @Named("httpUrl")
    public String provideHttpUrl() {
        return "http://api.rovio.com";
    }

    @Singleton
    @Provides
    @Named("apiPath")
    public String provideApiPath() {
        return "prod";
    }

}

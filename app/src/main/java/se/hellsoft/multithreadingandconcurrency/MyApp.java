package se.hellsoft.multithreadingandconcurrency;

import android.app.Application;

public class MyApp extends Application {
    private AppComponent appComponent;
    private PresenterComponent presenterComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        appComponent = DaggerAppComponent
                .builder()
                .appModule(new AppModule())
                .build();

        presenterComponent = DaggerPresenterComponent
                .builder()
                .presenterModule(new PresenterModule(appComponent.repository()))
                .build();

    }

    public AppComponent getAppComponent() {
        return appComponent;
    }

    public PresenterComponent getPresenterComponent() {
        return presenterComponent;
    }
}

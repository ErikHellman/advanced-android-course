package se.hellsoft.multithreadingandconcurrency;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import javax.inject.Inject;

import se.hellsoft.multithreadingandconcurrency.model.Repository;


public abstract class BaseActivity extends AppCompatActivity {
    @Inject
    Repository repository;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((MyApp) getApplication()).getAppComponent().inject(this);
    }
}

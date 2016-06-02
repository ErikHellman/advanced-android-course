package se.hellsoft.multithreadingandconcurrency;

import android.app.AlarmManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import javax.inject.Inject;
import javax.inject.Named;

import se.hellsoft.multithreadingandconcurrency.model.Repository;


public abstract class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}

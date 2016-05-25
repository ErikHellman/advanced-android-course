package se.hellsoft.buildtools.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import se.hellsoft.buildtools.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            TasksFragment tasksFragment = TasksFragment.newInstance();
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.container, tasksFragment)
                    .commit();
        }
    }

}

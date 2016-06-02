package se.hellsoft.multithreadingandconcurrency;

import java.util.List;

import se.hellsoft.multithreadingandconcurrency.model.Task;

public interface TasksContract {

    interface View {
        void showTasks(List<Task> tasks);
    }

    interface Presenter {
        void start(View view);

        void loadTasks();

        void stop();
    }
}

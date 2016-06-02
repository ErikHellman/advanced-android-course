package se.hellsoft.multithreadingandconcurrency;

import se.hellsoft.multithreadingandconcurrency.model.Task;

public interface TaskContract {

    interface View {
        void showTask(Task task);

        void complete();
    }

    interface Presenter {
        void start(View view);

        void loadTask(Long taskId);

        void saveTask(Task task);

        void deleteTask(Task task);

        void stop();
    }
}

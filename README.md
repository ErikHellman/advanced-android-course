# Multithreading, concurrency and async operations

This lab will go through three different options for performing concurrency and async operations on Android. The tasks in this lab is based on a simple TODO application. Tasks are stored in a `Repository` and the goal is to make reading and writing to this repository asynchronous so it doesn't happen on the main thread.

## StrictMode

The Android APIs provide a useful utility called `StrictMode` for detecting method calls that are slow or perform IO operations on the main thread. The first task in this lab is to enable `StrictMode` for the application and the appropriate "penalty" when strict mode violation occurs. Use `StrictMode.notSlowCall()` in the appropriate methods of the application.

# Thread annotations

To assist the developers and avoid mistakes, Android provides two annotations, `@MainThread` and `@WorkerThread`. These will help you detect when you're calling a method from the wrong thread. For every method in the application, apply the appropriate annotation and see the results in Android Studio. 

## Handler, Looper and HandlerThread

The main thread in Android is a message queue where all UI operations and a number of system events come in. This is implemented using a `Looper` that "loops" the main thread, reads the next "message" and execute the operation related to it. Android provides a few classes to make use of this message queue for applications as well. The core classes are `Handler`, `Looper` and `HandlerThread`.

In the first part of this lab, implement an async wrapper for the `FakeRepository` using `Handler` and `HandlerThread`. Try to implement the solution using `Message` and avoid using `Runnable`. Also try to keep the thread annotations so that it is clear what thread a certain method is running on. Remember to cancel any queued operations when necessary as well as stopping any background threads.

## Loaders

Another approach is to use `Loaders` for loading data. Implement the same async behavior as with `Handler` and `HandlerThread` using a custom `Loader` instead. As in the previous section, use the thread annotations where it is possible.

## RxJava

Another option for performing async operations is by using RxJava, the Java implementation of Reactive Extensions pattern. This frameworks uses the pattern of Observer/Observable together with streams of events to create a very competent solution for asynchronous programming. There are several extensions on top of RxJava that leverages the advantages of Reactive Extensions and integrates it nicely into Android. Although RxJava has a higher threshold than the other two options in this lab, it is also the most competent and will be used in later code labs as well.

The task in this part of the lab is to use RxJava to solve the async problem with this application. You will need to add both RxJava and RxAndroid in order to complete this task.
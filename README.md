# Application Lifecycle

This lab will focus on the lifecycle of the Android components, mainly the Activity, Fragment and Service.

The logging utility Hugo is used for logging method calls in the application. This is useful to track how methods are called in the lifecycle of the app.

## Activities

Create a second Activity (copy of the first) and implement click callbacks for the buttons.

Toggle the developer settings for "Don't keep activities" between on and off and see what it means for the Activity lifecycle. Experiment with different ways of leaving the Activity (back, home, task-switch, swipe away the task etc.).

Discuss what the most likely scenario is for most users. How will they interact with your application?

### Launch modes

Launch the first Activity as usual from the home-screen and then use ADB to launch the same activity again. Notice how the back button behaves and what lifecycle methods are called.

Modify the intent-filter for the first Activity to take three different Intents (using different action strings). Use ADB to launch the different Intents and notice how the Activity behaves. Is it a new instance every time? What methods are called?

Next, add the `android:launchMode` attribute to the manifest for this Activity and experiment with the different values. What effect does it have? Read the documentation on these and discuss when this can be useful.

## Fragments

Create one Fragment for each Activity and move the UI to those. Add `@DebugLog` to all the lifecycle methods and see how they relate to the lifecycle of the Activity.

Create a second Fragment that will display a single button and add a button to the first fragment that will display this. When pressing the button in the new Fragment you should display a dialog (using a DialogFragment). Remember to use `@DebugLog` for the lifecycle callbacks on all Fragments and notice how they are called.

Create an `AsyncTask` that sleeps for 10 seconds and then completes. This task will start by displaying the dialog fragment and dispose it once it is completed. Discuss and test what happens if the Fragment and Activity will be destroyed before the task is completed. How would you fix this?

## Services

Add `MyService` as a Android service in the manifest without any intent filter. Add four buttons to the two Activities that starts, binds, unbinds and stops the service. Implement a `ServiceConnection` class and add the `@DebugLog` statements to the methods. Perform the different actions (start/stop, bind/unbind) from both Activities and notice how the different lifecycle methods are called. What methods are called and which ones are not?

Fix the bug in the service binding and implement a process-local `Binder`. Test the lifecycle of the service again and see what methods are called and which ones are not.

### Async service

Add a method to the binder that provides an interface to the service (e.g., `LocalBinder::getService()`). This interface should contain an async method that takes a single callback interface as a parameter (e.g., `void doBackgroundWork(MyCallback callback);`). Implement this method in the service and add buttons in the activities to invoke. Each Activity should implement the callback interface. Add log statements that prints which thread the methods are being called on.

Discuss the impact on this and how you would make a better design for async calls to a service. Implement a basic solution and test it.

### Intent Service

Create a new services that extends `IntentService`. Find a way to perform async service calls on a background thread (add a call to `SystemClock.sleep()` to introduce a delay) and how to pass the result back to the caller (i.e., Activity). Discuss the pros and cons. Don't forget to add `@DebugLog` statements to relevant methods.

See what the difference will be if you make three immediate calls to the service and if you wait until each previous call was completed. Discuss the impact of this and what this means when it comes to using `IntentService` vs a custom `Service`.

## Application

Create a custom `Application` and register it in the manifest. Implement the lifecycle callbacks and add the `@DebugLog` annotation to all the methods. When are the methods called and which ones are never called?

Discuss when you should use a custom `Application` and what are the drawbacks of such a solution. For the use-cases you find, think of alternative solutions that would benefit your users.

### ContentProvider alternative

Instead of using an `Application` to do global app initialisation, think of how you could do this using a `ContentProvider` and discuss why this would be better.

## ActivityLifecycleCallbacks

Create a class implementing the `ActivityLifecycleCallbacks` interface. Register an instance of this class in the `onCreate()` method of your custom `Application`. Add `@DebugLog` to the methods and note how they are called when move between activities and in and out of the application.

Discuss when this callback interface can be useful.



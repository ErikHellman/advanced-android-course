# Android Build Tools and Gradle

In this code lab you will learn how to take the most out of Androids built-tools and use Gradle to simplify your build scripts.

The build tools for Android changes rapidly, and it is a good practice to keep up to date with the new at [tools.andorid.com](http://tools.andorid.com) as well as on [gradle.org](http://gradle.org).

## Gradle optimisations

Gradle can be very slow if configured incorrectly. The first task in this lab is to identify the performance bottlenecks and fix them. To do so, build the application using `./gradlew assemble --profile`. This will output a HTML reports under `build/reports/profile`.

Make sure you apply the performance optimisations you can find and that the build scripts are configured to use the latest versions of the available tools.

## Enabling Jack build tools and Java 8

The latest version beta (v24.0.0-rc3) of the Android build tools has support for the new Jack toolchain. This will allow developer to use some of the Java 8 features in their Android projects, even on earlier versions. Enable this for the project and set the language level to Java. See [the instructions for Java 8 language features](https://developer.android.com/preview/j8-jack.html) on how to enable this for your project.

Next, change all anonymous inner classes to be lambda expressions instead. 

## Multi-module projects

The second task is to split project into three separate modules. Create a new library module for the code in the `model` and `backend` packages and move the code there.

## Gradle build variables

Move all common build parameters to the root `build.gradle` and refer to them in each modules build script. This includes versions (minimum SDK, build tools etc.) as well as dependencies.

## Product flavors

Add three product flavors to the project and name them `dev`, `nightly` and `production`. Configure the `backend` module to use different HTTP endpoints for each flavor.

## Dependency configuration

Add the logging wrapper Timber by Jake Wharton (find it on GitHub!) to the project. Configure it in your application code so that all builds except `productionRelease` will print to logcat.

Add logging calls at appropriate places in all classes and replace any existing `e.printStackTrace()` with a call to Timber instead.

Next, use logcat to filter out everything but the log calls from the `Backend` class.

## Annotations and Lint

Add all suitable annotations you can find from the Android support library (Note, you'll also need to add this as a dependency) to as many methods as are relevant in the project. Note what Android Studio complains about. Next run the lint task and analyse the result. Make appropriate fixes to the code.

## Method Count

Android has a limit to the amount method references that a single DEX file can contain. When this limit is reached, you need to configure your application to use multi-dex. Configure the DEX method count tool from [https://github.com/mihaip/dex-method-counts](https://github.com/mihaip/dex-method-counts) and find out how many methods the application contains.

Next, add some additional dependencies (e.g., Google Play Services, Guava, Jackson etc.) to the application and notice the difference.

Next, make a release build with ProGuard enabled and notice the difference in the method count for the APK.


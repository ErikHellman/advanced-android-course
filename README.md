# Application Architecture

In this lab we will explore the design pattern Model-View-Presenter (MVP) and how to implement it on Android. This pattern has become very popular for Android development and has proven to create an architecture for applications that are much easier to test, maintain and extend. We will also learn how to use Dependency Injection using Dagger 2 to decouple software components. 

## Dependency Injection with Dagger 2

The first task with this code lab is to refactor the application so that it uses Dagger 2 for Dependency Injection. At first, this will only affect the `Repository` and `FakeRepository` classes, but as we continue with implementing MVP we will see more use of this.

[Dagger 2](http://google.github.io/dagger/) is a Dependency Injection framework from Google that generates code, as opposed to many other DI frameworks for Java that uses reflection instead. This gives it much better performance, although with some added complexity. 

Start by reading up on the Dagger 2 documentation and adding it as a dependency in the Gradle scripts. 

## Model-View-Presenter

The MVP pattern has become a very popular choice for Android application and there exists many examples, tutorials, books and blog posts explaining how to apply it. One good example is the [Android MVP Sample from Google](https://github.com/googlesamples/android-architecture). In this part of the lab we will use the same approach on our more simpler application. 

Start by going through the `todo-mvp` branch on the Google sample to learn how it is structured. Next, start by refactoring our simplified TODO application so that it uses the MVP pattern instead. 

Consider how Dependency Injection can be used with the presenters in the MVP refactoring.

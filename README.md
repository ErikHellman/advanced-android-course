# Networking and Web APIs

Most Android applications require data to be fetched from an online Web Service in some way. In this lab we will use a "fake" Web Service and implement the client side calls for it. This service can be found at [http://jsonplaceholder.typicode.com/](http://jsonplaceholder.typicode.com/). For this lab, we will focus on the `/photos` endpoint. The UI will display a list of these photos together with the title. 

Before writing the code for fetching the data, create the `RecyclerView` that will display the content as well as an SQLite database for storing the data. Consider the lessons about architecture and other useful techniques from earlier labs when deciding on how to implement the code. 

## HTTP Clients

Android comes with two built in HTTP clients; `URLConnection` and Apache `HttpClient`. The later is now deprecated and all use of that API should be transitioned to a different API. While the `URLConnection` API provides most of the functions needed for doing HTTP calls, it is not very flexible in its use and requires lots of code to handle and configure. 

A better alternative for HTTP calls is [OkHttp](](https://github.com/square/okhttp) from Square. It provides an easy-to-use and flexible API. Another advantage is that it supports interceptors, which lets us add common behavior to all the network calls we do in our application (such as auth headers and such). 

The task is to integrate and configure an HTTP client that can be reused through the entire application.

## Retrofit and Moshi

The next task is to integrate the web service with the library [Retrofit](http://square.github.io/retrofit/) and the JSON serialization with [Moshi](https://github.com/square/moshi). 

## Background synchronization

Fetching data only when the user opens the application is generally a bad idea. A better strategy is to do regular background synchronization, preferably when other apps are also doing them. This will save battery and improve the user experience as data will be available already when the app is launched.

Depending on Android version and the availability of Play Services on the device, we have three options for scheduling background synchronization; `JobScheduler`, `GcmNetworkManager` and `AlarmManager`. To assist developers with integrating these solutions there are several wrapper libraries available. In this lab you will integrate [Android-Job from Evernote](https://github.com/evernote/android-job).

Integrate the Android-Job library and schedule data sync to occur every X minutes (where X is defined by a build variant variable).
# Persistence and Serialization

Most applications need to store data between sessions. The most common way to do so in Android is to use an SQLite database, either through a `ContentProvider` or directly using `SQLiteDatabase`. However, when working with data in Java, we prefer to use Plain Old Java Objects (POJOs), also called Data Transfer Objects (DTOs). One of the main challenges in Android is how do convert data from our persistence solution to regular Java objects. 

In this lab we will experiment with different methods for serializing and deserializing data. 
 
## Parcelable

Android has an internal serialization API that is used when passing data between components (activites, services, receivers etc.) and retaining data between configuration changes. A developer can use this API to avoid reloading data from disk or network, thus reducing the overhead happening when creating and recreating activities.

In this part, you will implement `Parcelable` for the POJOs used in this application. Once done, remember to add marshal and unmarshal (serialize/deserialize) these objects in the correct life-cycle methods. Measure the time it takes for a recreate of the activity before and after this is implemented.

## SQLite

SQLite is the default database for Android applications. While there are plenty of ORM (Object-Relation Mapping) frameworks available that hides the complexity that comes with SQL, it is still important to learn how to use these APIs efficiently. 
 
In this part, you will implement an `SQLiteOpenHelper` than creates an SQLite database and provide an interface for storing and retrieving our POJOs. Consider the design for this component so that it can easily be maintained, extended and tested. 

## Googe Auto Value

An alternative to using an ORM framework is to generate the code for mapping between SQL and POJOs at compile time. The same appraoch could then also be used for `Parcelable` implementations. The code we have for mapping between different formats in this way is also called "boilerplate code", a type of code you want to avoid. 

To do so in this case, there is a handy library called [Auto Value from Google](https://github.com/google/auto/tree/master/value) that generates the necessary boilerplate code for us. It comes with a number of extensions that us useful for Android developers, such as auto-value-parcel and auto-value-cursor. A good introduction to Google Auto Value is the [blog post by Ryan Harter](http://ryanharter.com/blog/2016/05/16/autovalue-extensions).

In this final part, you will integrate Auto Value for the `Parcelable` implementation as well as mapping to/from `Cursor` and `ContentValues`. Discuss the pros and cons of this solution.
# Advanced Graphics

In this lab, we will learn how to load images efficiently, how to use the `Canvas`, bitmaps and shaders, and also how to use RenderScript for high-performance image manipulation.

## Loading Images 1

Images can take a lot of memory, causing all sorts of performance and memory problems for your application and in the worst case result in an `OutOfMemoryError` crash. 

The first task in this lab is to improve loading speed of the bitmap in the application. Use `SystemClock.elapseRealtime()` to measure how long the loading and displaying of the image took.

## Loading Images 2

Loading images is often an IO intensive process, so it needs to be done on a background thread to avoid stuttering in the UI. To do so, we often use a third-party library like Picasso or Glide. 
 
Integrate these library (try both!) and load the image using them instead. Discuss the impact this has on your application and what you need to consider when doing async loading of images in your UI.

## RenderScript

Another way to manipulate bitmaps in Android is by using the RenderScript API. Instructions on how to enable RenderScript can be found at [https://developer.android.com/topic/libraries/support-library/features.html#v8](https://developer.android.com/topic/libraries/support-library/features.html#v8).

Using RenderScript, implement two graphical effects on `BitmapActivity`; blur and invert. The first can be done using `ScriptIntrinsicBlur`. The second will require a custom RenderScript.

Bonus task is to animate the blur effect from 0 to 

## Canvas 

Android uses the `Canvas` class to draw graphics. This class can also be used to perform custom drawing, either on a custom `View` or on top of an existing `Bitmap`. 

`Canvas` contains methods for drawing primitives, text and `Bitmap`s. In order to control how these are drawn, the class `Paint` is used. This class lets us define the color, stroke and many other parameters that affects the result of the drawing operation.

In this part of the lab you shall draw a simple smiley on an existing `Bitmap` that is displayed in an `ImageView`. Experiment with different ways of using `Paint` and `Canvas` to understand how they can be used.

## Text Paint

The `Paint` class can also be used on an `TextView`. Modify the `TextPaint` object on the `CustomPaintActivity` and see what kind of graphical effects you can add.
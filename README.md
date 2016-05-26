# User Interface

In the code lab we will focus on various aspects of the user interface APIs for Android.

## Styles and Themes

Styles and Themes are some of the most powerful features of the Android user interface. The task in this part is to reduce the complexity of `activity_styles_and_themes.xml` so that as much as possible is defined in a styles XML.

Start by extracting the styles to individual views and referring them in the layout XML. Once that is completed, create a theme for the `StylesAndThemesActivity` and refer to the styles there instead of the layout XML.

## RecyclerView

One of the most important widgets in Android today is the `RecyclerView`. In this part you wil implement a simple `RecyclerView` for the `Item` class and add an expand animation when the user clicks on an list entry.

* Configure the `RecyclerView` with the correct `LayoutManager` and an adapter.
* Create a layout XML for each item. Display Title with large text and Description in smaller, with maximum two lines displayed and an ellipsized setting at the end. Use a `CardView` to wrap everything and experiement with elevation and rounded corners.
* Create the `ViewHolder` and the adapter and configure them for the `RecyclerView`.
* Add a click listener to each item that expands them so that the entire Description is displayed. Only one item should be possible to have expanded (collapse any other expanded item when needed).
* Use the `RecyclerView` API to animate the expand/collapse.

## Custom Views

If the built in widgets in Android framework or the support libraries are not sufficient, we can create a custom view. This is easily done by subclassing the `View` class and implement the necessary methods. 

Create a custom view that implements a simple analog clock with hours, minutes and seconds. Apart form the constructors, you need to implement `onSizeChanged()` and `onDraw()`. You must also add custom attributes to customize the colors of the hands and the clock face as well as a boolean indicating if the seconds hand should be shown or not. 

## TextView, Typeface and Spannable

Many times we want to modify the look and feel of how text is displayed. It might be as simple as changing the default font or add certain styling to the text. Sometimes it might be more complex things, such as adding icons to the text or replacing certain section with something else. 

### Fonts and Typefaces

While the default font for Android is usually good enough for most pplications, there are occasions when we want to change it. It could be a font that is part of the design language for the whole company or organisation, or it might be a font containing special glyphs that we want to render (e.g., font icons). The first task is to replace the integrate the library [Calligraphy](https://github.com/chrisjenx/Calligraphy) by Christopher Jenkins and use that to modify the fonts used for all the `TextView`s in `TextActivity`. Decide which font you want to use on the different texts.

Finally, add a new `TextView` on `TextActivity` and use `FontAwesome.otf` to display a number of font icons. See the [chestsheet](http://fontawesome.io/cheatsheet/) for Font Awesome to see which unicode character represents which icon.

### Spannable

If we want to modify parts of a text inside a `TextView`, we need to use the `Spannable` class and its friends. Using the different span classes found in the [`android.text.style`](https://developer.android.com/reference/android/text/style/package-summary.html) package, start by adding italic and bold style to sections of the texts. Finally, use the `ReplacementSpan` to replace a part of a text with emoji icons (found in `drawable-nodpi`).


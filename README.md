# Gappein Sticker SDK
![Banner](https://raw.githubusercontent.com/Gappein/Gappein-Sticker-SDK/master/art/banner-sticker.png)

[ ![Download](https://api.bintray.com/packages/gappein/Gappein/Gappein-Sticker-SDK/images/download.svg?version=1.0.0-alpha2) ](https://bintray.com/gappein/Gappein/Gappein-Sticker-SDK/1.0.0-alpha2/link)

Gappein Sticker SDK is just android SDK where you can convert your text as Sticker.

### Feature it supports

  - You can use it with your XML View
  - And yes, it can be used in your view file.
### To install it in your project,

```groovy
implementation 'com.gappein:sticker:1.0.0-alpha1'
```

### To use it in View (Activity/Fragment)

Add it in the onCreate() of your view file like,
 ```kotlin
  val stickerView = StickerView(this)
 ```

 And to generate the Sticker for the entered text view,
 ```Kotlin
  stickerView.generateSticker("TEXT TO GENERATE STICKER")
 ```

 This will return the Bitmap and just perform your actions :)

### To use it in XML

Add in your XML like,

```XML

 <com.gappein.ui.StickerView
   android:id="@+id/stickerView"
   android:layout_width="wrap_content"
   android:layout_height="0dp"
   app:layout_constraintLeft_toLeftOf="parent"
   app:layout_constraintRight_toRightOf="parent"
   app:layout_constraintTop_toTopOf="parent" />
```

and similar to above, to generate sticker use,

 ```Kotlin
  stickerView.generateSticker("TEXT TO GENERATE STICKER")
 ```

 This will also return the Bitmap you are done :)

 # Recommendation
 * Prefer the length of characters upto 20 for better display of Stickers.




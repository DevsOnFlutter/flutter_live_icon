# Live Icon

<!-- <img src="https://i.imgur.com/462Y6wf.gif" title="Flutter_Shortcuts" /> -->

![GitHub](https://img.shields.io/github/license/DevsOnFlutter/flutter_live_icon?style=plastic) ![GitHub code size in bytes](https://img.shields.io/github/languages/code-size/DevsOnFlutter/flutter_live_icon?style=plastic) ![GitHub top language](https://img.shields.io/github/languages/top/DevsOnFlutter/flutter_live_icon?style=plastic) ![GitHub language count](https://img.shields.io/github/languages/count/DevsOnFlutter/flutter_live_icon?style=plastic) ![GitHub tag (latest by date)](https://img.shields.io/github/v/tag/DevsOnFlutter/flutter_live_icon?style=plastic) ![GitHub issues](https://img.shields.io/github/issues/DevsOnFlutter/flutter_live_icon?style=plastic) 

![GitHub Repo stars](https://img.shields.io/github/stars/DevsOnFlutter/flutter_live_icon?style=social) ![GitHub forks](https://img.shields.io/github/forks/DevsOnFlutter/flutter_live_icon?style=social)


## Features

All the features listed below can be performed at the runtime.

✅ &nbsp; Change App Icons </br>
✅ &nbsp; Change App Label </br>

<!-- ## Demo -->

<!-- |<img height=500 src="https://i.imgur.com/UPcyPEl.gif"/>|
|---| -->

## Quick Start

### Step 1: Include plugin to your project

```yml
dependencies:
  live_icon: <latest version>
```

### Step 2: Add activity-alias in AndroidManifest.xml

```xml
...
...
<application
    android:label="live_icon_example"
    android:icon="@mipmap/ic_launcher">
    <activity
        android:name=".MainActivity"
        android:launchMode="singleTop"
        android:theme="@style/LaunchTheme"
        android:configChanges="orientation|keyboardHidden|keyboard|screenSize|smallestScreenSize|locale|layoutDirection|fontScale|screenLayout|density|uiMode"
        android:hardwareAccelerated="true"
        android:windowSoftInputMode="adjustResize">
        <meta-data
            android:name="io.flutter.embedding.android.NormalTheme"
            android:resource="@style/NormalTheme"
            />
        <meta-data
            android:name="io.flutter.embedding.android.SplashScreenDrawable"
            android:resource="@drawable/launch_background"
            />
        <intent-filter>
            <action android:name="android.intent.action.MAIN"/>
            <category android:name="android.intent.category.LAUNCHER"/>
        </intent-filter>
    </activity>

    <!-- Live Icon Addition -->
    <activity-alias
        android:name=".DarkTheme"
        android:enabled="false"
        android:icon="@mipmap/dark_theme"
        android:label="DarkThemeLabel"
        android:targetActivity=".MainActivity">
        <intent-filter>
            <action android:name="android.intent.action.MAIN"/>
            <category android:name="android.intent.category.LAUNCHER"/>
        </intent-filter>
    </activity-alias>

    <activity-alias
        android:name=".LightTheme"
        android:enabled="false"
        android:icon="@mipmap/light_theme"
        android:label="LightThemeLabel"
        android:targetActivity=".MainActivity">
        <intent-filter>
            <action android:name="android.intent.action.MAIN"/>
            <category android:name="android.intent.category.LAUNCHER"/>
        </intent-filter>
    </activity-alias>
    <!-- Live Icon Addition -->

    <meta-data
        android:name="flutterEmbedding"
        android:value="2" />

</application>
...
...
```

### Step 3: Create classes

Create java/kotlin files with the same name as provided in activity-alias.

In the above AndroidManifest.xml example, 2 activity-alias are provided, so the number of java/kotlin files will be 2.
Example:

#### 1. `DarkTheme.java`

```java
package com.hackthedeveloper.live_icon_example;

public class DarkTheme {
}
```

#### 2. `LightTheme.java`

```java
package com.hackthedeveloper.live_icon_example;

public class LightTheme {
}
```

One thing to note here is that, we have added two extra activity as activity-alias, and we now have 3 activity in total.

### Step 4: Initialise plugin

List all the activity-alias class names. 
**NOTE:** `MainActivity` will also be added here as it containes the launch intent.

```dart
LiveIcon.initialize(
    classNames: ['MainActivity', 'DarkTheme', 'LightTheme'],
);
```

### Step 5: Switch App icon

Use `switchIconTo` to switch app icons. It takes in the className that must match the desired activity-alias `android:name`.

```dart
await liveIcon.switchIconTo(
    className: 'DarkTheme',
);
```



## Project Created & Maintained By

### Subham Praharaj

<a href="https://twitter.com/SubhamPraharaj6"><img src="https://github.com/aritraroy/social-icons/blob/master/twitter-icon.png?raw=true" width="60"></a> <a href="https://www.linkedin.com/in/subham-praharaj-66b172179/"><img src="https://github.com/aritraroy/social-icons/blob/master/linkedin-icon.png?raw=true" width="60"></a> <a href="https://instagram.com/the_champ_subham_865"><img src="https://github.com/aritraroy/social-icons/blob/master/instagram-icon.png?raw=true" width="60"></a>

[![GitHub followers](https://img.shields.io/github/followers/skpraharaj.svg?style=social&label=Follow)](https://github.com/skpraharaj/)

### Divyanshu Shekhar

<a href="https://twitter.com/dshekhar17"><img src="https://github.com/aritraroy/social-icons/blob/master/twitter-icon.png?raw=true" width="60"></a> <a href="https://in.linkedin.com/in/divyanshu-shekhar-a8a04a162"><img src="https://github.com/aritraroy/social-icons/blob/master/linkedin-icon.png?raw=true" width="60"></a> <a href="https://instagram.com/dshekhar17"><img src="https://github.com/aritraroy/social-icons/blob/master/instagram-icon.png?raw=true" width="60"></a>

[![GitHub followers](https://img.shields.io/github/followers/divshekhar.svg?style=social&label=Follow)](https://github.com/divshekhar/)



## Contributions

Contributions are welcomed!

If you feel that a hook is missing, feel free to open a pull-request.

For a custom-hook to be merged, you will need to do the following:

Describe the use-case.

* Open an issue explaining why we need this hook, how to use it, ...
  This is important as a hook will not get merged if the hook doens't appeal to
  a large number of people.

* If your hook is rejected, don't worry! A rejection doesn't mean that it won't
  be merged later in the future if more people shows an interest in it.
  In the mean-time, feel free to publish your hook as a package on https://pub.dev.

* A hook will not be merged unles fully tested, to avoid breaking it inadvertendly
  in the future.

## Copyright & License

Code and documentation Copyright (c) 2021 [Devs On Flutter](https://github.com/DevsOnFlutter). Code released under the [BSD 3-Clause License](./LICENSE).

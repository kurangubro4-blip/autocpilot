# Hello APK

A minimal Android app (`com.example.hello`, "Hello APK") — a single-screen tap counter, no external dependencies.

## Download

The built, signed APK is committed at [`apk/HelloApk.apk`](apk/HelloApk.apk).
Download it from the file view ("Download raw file") and install it on an Android 7.0+ device (allow "Install unknown apps" for your browser).

- Package: `com.example.hello`
- minSdk 24 / targetSdk 34 / compileSdk 34, versionCode 1, versionName 1.0
- Signed with a throwaway debug keystore (fine for testing; Play Store would need a real release key)

## Build from source

Built without Gradle using Android build-tools 34:

```bash
aapt2 compile --dir app/res -o res.zip
aapt2 link -o base.apk -I android.jar --manifest app/AndroidManifest.xml -R res.zip --java gen --auto-add-overlay --min-sdk-version 24 --target-sdk-version 34 --version-code 1 --version-name 1.0
javac -source 17 -target 17 -classpath android.jar -d classes gen/com/example/hello/R.java app/java/com/example/hello/MainActivity.java
d8 --release --min-api 24 --lib android.jar --output . classes/com/example/hello/*.class
zip -j base.apk classes.dex
zipalign -f 4 base.apk aligned.apk
apksigner sign --ks debug.keystore --out HelloApk.apk aligned.apk
```

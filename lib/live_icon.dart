import 'dart:async';

import 'package:flutter/services.dart';

class LiveIcon {
  static const MethodChannel _channel =
      const MethodChannel('com.hackthedeveloper.live_icon');

  /// [initialize] takes list of class names listed in AndroidManifest.xml's
  /// activity-alias tag.
  static Future<void> initialize({required List<String> classNames}) async {
    await _channel.invokeMethod("initialize", classNames);
  }

  /// [switchIconTo] takes a class name (activity-alias android:name)
  /// and switches the app icon to that activity-alias.
  Future<void> switchIconTo({required String className}) async {
    await _channel.invokeMethod("switchIconTo", [className]);
  }
}

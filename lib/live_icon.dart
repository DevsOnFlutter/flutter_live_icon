
import 'dart:async';

import 'package:flutter/services.dart';

class LiveIcon {
  static const MethodChannel _channel =
      const MethodChannel('live_icon');

  static Future<String> get platformVersion async {
    final String version = await _channel.invokeMethod('getPlatformVersion');
    return version;
  }
}

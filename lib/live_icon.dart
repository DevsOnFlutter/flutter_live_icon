import 'dart:async';

import 'package:flutter/services.dart';
import 'package:live_icon/src/helper/helper.dart';

export 'package:live_icon/src/helper/helper.dart';

class LiveIcon {
  static const MethodChannel _channel =
      const MethodChannel('com.hackthedeveloper.live_icon');

  Future<void> switchTo({required LiveIconData icon}) async {
    Map<String, String> iconData = {
      'iconName': icon.iconName,
      'className': icon.className,
    };
    await _channel.invokeMethod("initialize", [iconData]);
  }
}

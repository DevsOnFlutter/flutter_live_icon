import 'dart:async';

import 'package:flutter/services.dart';
import './src/helper/helper.dart';

export './src/helper/helper.dart';

class LiveIcon {
  static const MethodChannel _channel =
      const MethodChannel('com.hackthedeveloper.live_icon');

  Future<void> initialize({List<LiveIconData> icons}) async {
    List<Map<String, String>> iconData = _serializeLiveIconData(icons);
    await _channel.invokeMethod("initialize", iconData);
  }

  List<Map<String, String>> _serializeLiveIconData(List<LiveIconData> icons) {
    return icons
        .map((icon) => <String, String>{
              'iconName': icon.iconName,
              'className': icon.className,
            })
        .toList();
  }
}

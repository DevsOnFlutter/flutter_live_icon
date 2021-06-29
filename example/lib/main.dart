import 'package:flutter/material.dart';

import 'package:live_icon/live_icon.dart';

void main() {
  runApp(MyApp());
}

class MyApp extends StatefulWidget {
  @override
  _MyAppState createState() => _MyAppState();
}

class _MyAppState extends State<MyApp> {
  LiveIcon liveIcon = LiveIcon();

  @override
  void initState() {
    LiveIcon.initialize(
      classNames: ['MainActivity', 'DarkTheme', 'LightTheme'],
    );
    super.initState();
  }

  void switchAppIcon() async {
    await liveIcon.switchIconTo(
      className: 'LightTheme',
    );
  }

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: Scaffold(
        appBar: AppBar(
          title: const Text('Plugin example app'),
        ),
        body: Center(
          child: ElevatedButton(
            child: Text('switch To DarkThemeIcon'),
            onPressed: () {
              switchAppIcon();
            },
          ),
        ),
      ),
    );
  }
}

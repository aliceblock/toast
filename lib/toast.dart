import 'dart:async';

import 'package:flutter/services.dart';

class Toast {
  static const MethodChannel _channel = const MethodChannel('toast');

  static Future<void> toast(String text) async {
    _channel.invokeMethod('callAwesomeToast', text);
  }
}

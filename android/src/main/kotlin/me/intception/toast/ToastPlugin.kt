package me.intception.toast

import android.widget.Toast
import io.flutter.plugin.common.MethodCall
import io.flutter.plugin.common.MethodChannel
import io.flutter.plugin.common.MethodChannel.MethodCallHandler
import io.flutter.plugin.common.MethodChannel.Result
import io.flutter.plugin.common.PluginRegistry.Registrar

class ToastPlugin(var registrar: Registrar): MethodCallHandler {
  companion object {
    @JvmStatic
    fun registerWith(registrar: Registrar) {
      val channel = MethodChannel(registrar.messenger(), "toast")
      channel.setMethodCallHandler(ToastPlugin(registrar))
    }
  }

  override fun onMethodCall(call: MethodCall, result: Result) {
    if (call.method == "callAwesomeToast") {
      var customText = call.arguments<String>()
      Toast.makeText(this.registrar.context(), customText, Toast.LENGTH_LONG).show()
      result.success(null)
    } else {
      result.notImplemented()
    }
  }
}

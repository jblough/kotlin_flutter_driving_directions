package com.josephblough.flutterdrivingdirections

import android.content.Intent
import android.net.Uri
import io.flutter.plugin.common.MethodCall
import io.flutter.plugin.common.MethodChannel
import io.flutter.plugin.common.MethodChannel.MethodCallHandler
import io.flutter.plugin.common.MethodChannel.Result
import io.flutter.plugin.common.PluginRegistry.Registrar

class FlutterDrivingDirectionsPlugin(private val registrar: Registrar): MethodCallHandler {
  companion object {
    @JvmStatic
    fun registerWith(registrar: Registrar) {
      val channel = MethodChannel(registrar.messenger(), "flutter_driving_directions")
      channel.setMethodCallHandler(FlutterDrivingDirectionsPlugin(registrar))
    }
  }

  override fun onMethodCall(call: MethodCall, result: Result) {
    if (call.method != "getDirections") {
      result.notImplemented()
    }

    val latitude = call.argument<Double>("latitude")
    val longitude = call.argument<Double>("longitude")
    val address = call.argument<String>("address")

    val uri = "http://maps.google.com/maps?daddr=$latitude,$longitude ($address)"
    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(uri))
    intent.setPackage("com.google.android.apps.maps")
    registrar.activity()?.startActivity(intent)
  }
}

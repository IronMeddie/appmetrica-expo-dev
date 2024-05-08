package io.appmetrica.analytics.expo

import android.util.Log
import expo.modules.kotlin.modules.Module
import expo.modules.kotlin.modules.ModuleDefinition
import io.appmetrica.analytics.AppMetricaConfig
import io.appmetrica.analytics.AppMetrica

class AppMetricaModule : Module() {
  // Each module class must implement the definition function. The definition consists of components
  // that describes the module's functionality and behavior.
  // See https://docs.expo.dev/modules/module-api for more details about available components.
  override fun definition() = ModuleDefinition {
    // Sets the name of the module that JavaScript code will use to refer to the module. Takes a string as an argument.
    // Can be inferred from module's class name, but it's recommended to set it explicitly for clarity.
    // The module will be accessible from `requireNativeModule('AppMetrica')` in JavaScript.
    Name("AppMetrica")
    Function("activate") { config: io.appmetrica.analytics.expo.AppMetricaConfig ->
      Log.d("checkCode", "Function activate")
      val builder = AppMetricaConfig.newConfigBuilder(config.apiKey)
        .apply {
          config.anrMonitoringTimeout?.let { withAnrMonitoringTimeout(it) }
          config.appBuildNumber?.let { withAppBuildNumber(it) }
          config.crashReporting?.let { withCrashReporting(it) }
          config.handleFirstActivationAsUpdate?.let { handleFirstActivationAsUpdate(it) }
          config.anrMonitoring?.let { withAnrMonitoring(it) }
          config.appOpenTrackingEnabled?.let { withAppOpenTrackingEnabled(it) }
          config.appVersion?.let { withAppVersion(it) }
          config.customHosts?.let { withCustomHosts(it) }
          config.dataSendingEnabled?.let { withDataSendingEnabled(it) }
          config.deviceType?.let { withDeviceType(it.value) }
          config.dispatchPeriodSeconds?.let { withDispatchPeriodSeconds(it) }
          config.locationTracking?.let { withLocationTracking(it) }
          config.maxReportsCount?.let { withMaxReportsCount(it) }
          config.maxReportsInDatabaseCount?.let { withMaxReportsInDatabaseCount(it) }
          config.nativeCrashReporting?.let { withNativeCrashReporting(it) }
          config.preloadInfo?.let { withPreloadInfo(it.toPreloadInfo()) }
          config.revenueAutoTrackingEnabled?.let { withRevenueAutoTrackingEnabled(it) }
          config.withSessionTimeout?.let { withSessionTimeout(it) }
          config.errorEnvironmentValue?.forEach {
            withErrorEnvironmentValue(it.key,it.value)
          }
          if (config.withLogs != null && config.withLogs != false) {
            withLogs()
          }
          config.additionalConfig?.forEach {
            withAdditionalConfig(it.key, it.value)
          }
          config.appEnvironmentValue?.forEach {
            withAppEnvironmentValue(it.key,it.value)
          }
          withLocation(config.location?.toLocation())
          withUserProfileID(config.withUserProfileID)
        }.build()
      AppMetrica.activate(appContext.reactContext?.applicationContext ?: throw ApplicationNotAttached(), builder)
    }

    Function("reportEvent") { name: String, params: String? ->
      AppMetrica.reportEvent(name,params)
    }

    Function("sendEventsBuffer") {
      AppMetrica.sendEventsBuffer()
    }

    // Sets constant properties on the module. Can take a dictionary or a closure that returns a dictionary.
//    Constants(
//      "PI" to Math.PI
//    )

    // Defines event names that the module can send to JavaScript.
//    Events("onChange")

    // Defines a JavaScript synchronous function that runs the native code on the JavaScript thread.
//    Function("hello") {
//      "Hello world! 👋"
//    }

    // Defines a JavaScript function that always returns a Promise and whose native code
    // is by default dispatched on the different thread than the JavaScript runtime runs on.
//    AsyncFunction("setValueAsync") { value: String ->
//      // Send an event to JavaScript.
//      sendEvent("onChange", mapOf(
//        "value" to value
//      ))
//    }

//    // Enables the module to be used as a native view. Definition components that are accepted as part of
//    // the view definition: Prop, Events.
//    View(AppMetricaView::class) {
//      // Defines a setter for the `name` prop.
//      Prop("name") { view: AppMetricaView, prop: String ->
//        println(prop)
//      }
//    }
  }
}

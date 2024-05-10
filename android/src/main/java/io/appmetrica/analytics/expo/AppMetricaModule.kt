package io.appmetrica.analytics.expo

import expo.modules.kotlin.modules.Module
import expo.modules.kotlin.modules.ModuleDefinition
import io.appmetrica.analytics.AppMetrica
import io.appmetrica.analytics.expo.models.AppMetricaConfig

class AppMetricaModule : Module() {
  // Each module class must implement the definition function. The definition consists of components
  // that describes the module's functionality and behavior.
  // See https://docs.expo.dev/modules/module-api for more details about available components.
  override fun definition() = ModuleDefinition {
    // Sets the name of the module that JavaScript code will use to refer to the module. Takes a string as an argument.
    // Can be inferred from module's class name, but it's recommended to set it explicitly for clarity.
    // The module will be accessible from `requireNativeModule('AppMetrica')` in JavaScript.
    Name("AppMetrica")
    Function("activate") { config: AppMetricaConfig ->
      AppMetrica.activate(appContext.reactContext?.applicationContext ?: throw ApplicationNotAttached(), config.toConfig())
    }

    Function("reportEvent") { name: String, params: String? ->
      AppMetrica.reportEvent(name,params)
    }

    Function("sendEventsBuffer") {
      AppMetrica.sendEventsBuffer()
    }

    Function("clearAppEnvironment") {
      AppMetrica.clearAppEnvironment()
    }

    Function("putAppEnvironmentValue") { key: String, value: String? ->
      AppMetrica.putAppEnvironmentValue(key, value)
    }

    Function("getDeviceId") { key: String, value: String? ->
      AppMetrica.getDeviceId(appContext.reactContext?.applicationContext ?: throw ApplicationNotAttached())
    }

    Function("resumeSession") {
      AppMetrica.resumeSession(appContext.currentActivity)
    }

    Function("pauseSession") {
      AppMetrica.pauseSession(appContext.currentActivity)
    }

    Function("reportAppOpen") { link: String ->
      AppMetrica.reportAppOpen(link)
    }

    Function("reportError") { identifier: String, message: String? ->
      AppMetrica.reportError(identifier,message)
    }

    Function("setDataSendingEnabled") { enabled: Boolean ->
      AppMetrica.setDataSendingEnabled(enabled)
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

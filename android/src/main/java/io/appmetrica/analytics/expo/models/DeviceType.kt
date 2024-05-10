package io.appmetrica.analytics.expo.models

import expo.modules.kotlin.types.Enumerable
import io.appmetrica.analytics.PredefinedDeviceTypes

enum class DeviceType(val value: String) : Enumerable {
    CAR(PredefinedDeviceTypes.CAR),
    TV(PredefinedDeviceTypes.TV),
    PHONE(PredefinedDeviceTypes.PHONE),
    TABLET(PredefinedDeviceTypes.TABLET)
}
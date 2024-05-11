package io.appmetrica.analytics.expo.models

import expo.modules.kotlin.types.Enumerable

enum class StartupParams(name: String) : Enumerable {
  APPMETRICA_DEVICE_ID_HASH("appmetrica_device_id_hash"),
  APPMETRICA_UUID("appmetrica_uuid"),
  APPMETRICA_DEVICE_ID("appmetrica_device_id")
}
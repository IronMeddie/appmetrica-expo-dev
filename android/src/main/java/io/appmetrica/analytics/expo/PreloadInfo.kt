package io.appmetrica.analytics.expo

import expo.modules.kotlin.records.Field
import expo.modules.kotlin.records.Record
import io.appmetrica.analytics.PreloadInfo

class PreloadInfo: Record {
    @Field
    val trackingID: String = ""

    @Field
    val additionalParams: Map<String,String> = emptyMap()

    fun toPreloadInfo(): PreloadInfo {
        val preloadInfo = PreloadInfo.newBuilder(trackingID)
        additionalParams.forEach {
            preloadInfo.setAdditionalParams(it.key,it.value)
        }
        return preloadInfo.build()
    }
}
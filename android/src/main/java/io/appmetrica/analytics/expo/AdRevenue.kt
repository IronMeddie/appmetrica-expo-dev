package io.appmetrica.analytics.expo

import expo.modules.kotlin.records.Field
import expo.modules.kotlin.records.Record
import io.appmetrica.analytics.AdType
import java.util.Currency


class AdRevenue: Record {
    @Field
    val price: Double = 0.0

    @Field
    val currency: String = ""

    @Field
    val payload: Map<String, String>? = null

    @Field
    val adType: String? = null

    @Field
    val adNetwork: String? = null

    @Field
    val adPlacementID: String? = null

    @Field
    val adPlacementName: String? = null

    @Field
    val adUnitID: String? = null

    @Field
    val adUnitName: String? = null

    @Field
    val precision: String? = null

    fun toAdRevenuee(): io.appmetrica.analytics.AdRevenue {
        val price: Double = price
        val currency: String = currency
        return io.appmetrica.analytics.AdRevenue.newBuilder(price, Currency.getInstance(currency))
            .withAdNetwork(adNetwork)
            .withAdType(toAdType(adType))
            .withAdUnitId(adUnitID)
            .withAdPlacementId(adPlacementID)
            .withAdNetwork(adNetwork)
            .withPrecision(precision)
            .withAdPlacementName(adPlacementName)
            .withAdUnitName(adUnitName)
            .withPayload(payload)
            .build()
    }

    fun toAdType(type: String?): AdType? {
        return when (type) {
            null -> null
            "native" -> AdType.NATIVE
            "banner" -> AdType.BANNER
            "mrec" -> AdType.MREC
            "interstitial" -> AdType.INTERSTITIAL
            "rewarded" -> AdType.REWARDED
            else -> AdType.OTHER
        }
    }
}
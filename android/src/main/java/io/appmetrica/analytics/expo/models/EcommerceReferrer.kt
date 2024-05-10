package io.appmetrica.analytics.expo.models

import expo.modules.kotlin.records.Field
import expo.modules.kotlin.records.Record
import io.appmetrica.analytics.ecommerce.ECommerceReferrer

class EcommerceReferrer: Record {
    @Field
    val identifier: String? = null

    @Field
    val screen: EcommerceScreen? = null

    @Field
    val type: String? = null

    fun toReferrer(): ECommerceReferrer {
        return ECommerceReferrer()
            .setIdentifier(identifier)
            .setScreen(screen?.toScreen())
            .setType(type)
    }
}
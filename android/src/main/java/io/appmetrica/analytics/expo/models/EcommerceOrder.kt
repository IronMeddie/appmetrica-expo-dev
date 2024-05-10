package io.appmetrica.analytics.expo.models

import expo.modules.kotlin.records.Field
import expo.modules.kotlin.records.Record
import io.appmetrica.analytics.ecommerce.ECommerceOrder

class EcommerceOrder : Record {
    @Field
    val identifier: String = ""

    @Field
    val cartItems: List<EcommerceCartItem> = emptyList()

    @Field
    val payload: Map<String, String> = emptyMap()
    fun toOrder(): ECommerceOrder {
        return ECommerceOrder(identifier, cartItems.map { it.toCartItem() })
            .setPayload(payload)
    }
}
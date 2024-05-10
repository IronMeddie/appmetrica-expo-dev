package io.appmetrica.analytics.expo.models

import expo.modules.kotlin.records.Field
import expo.modules.kotlin.records.Record
import io.appmetrica.analytics.ecommerce.ECommercePrice
class EcommercePrice: Record {
    @Field
    val amount: EcommerceAmount = EcommerceAmount()

    @Field
    val internalComponents: List<EcommerceAmount> = emptyList()

    fun toEcommercPrice(): ECommercePrice {
        return ECommercePrice(amount.toEcommerceAmount())
            .setInternalComponents(internalComponents.map { it.toEcommerceAmount() })
    }
}
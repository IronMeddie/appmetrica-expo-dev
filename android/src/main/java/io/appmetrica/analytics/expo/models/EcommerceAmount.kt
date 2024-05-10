package io.appmetrica.analytics.expo.models

import expo.modules.kotlin.records.Field
import expo.modules.kotlin.records.Record
import io.appmetrica.analytics.ecommerce.ECommerceAmount

class EcommerceAmount: Record {

    @Field
    val amount: Double = 0.0

    @Field
    val unit: String = ""

    fun toEcommerceAmount(): ECommerceAmount {
        return ECommerceAmount(amount, unit)
    }
}
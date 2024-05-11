package io.appmetrica.analytics.expo.models

import expo.modules.kotlin.records.Field
import expo.modules.kotlin.records.Record
import io.appmetrica.analytics.ecommerce.ECommerceCartItem


class EcommerceCartItem : Record {
    @Field
    val product: EcommerceProduct = EcommerceProduct()

    @Field
    val quantity: Double = 1.0

    @Field
    val price: EcommercePrice = EcommercePrice()

    @Field
    val referrer: EcommerceReferrer? = null

    fun toCartItem(): ECommerceCartItem {
        return ECommerceCartItem(product.toProduct(), price.toEcommercPrice(), quantity)
            .setReferrer(referrer?.toReferrer())
    }
}
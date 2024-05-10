package io.appmetrica.analytics.expo.models

import expo.modules.kotlin.records.Field
import expo.modules.kotlin.records.Record
import io.appmetrica.analytics.ecommerce.ECommerceProduct

class EcommerceProduct: Record {
    @Field
    val name: String = ""

    @Field
    val sku: String = ""

    @Field
    val actualPrice: EcommercePrice = EcommercePrice()

    @Field
    val originalPrice: EcommercePrice = EcommercePrice()

    @Field
    val categoriesPath: List<String> = emptyList()

    @Field
    val promocodes: List<String> = emptyList()

    @Field
    val payload: Map<String,String> = emptyMap()

    fun toProduct(): ECommerceProduct {
        return ECommerceProduct(sku)
            .setName(name)
            .setPayload(payload)
            .setCategoriesPath(categoriesPath)
            .setActualPrice(actualPrice.toEcommercPrice())
            .setOriginalPrice(originalPrice.toEcommercPrice())
            .setPromocodes(promocodes)
    }
}

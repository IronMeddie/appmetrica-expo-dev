package io.appmetrica.analytics.expo.models

import expo.modules.kotlin.records.Field
import expo.modules.kotlin.records.Record
import io.appmetrica.analytics.ecommerce.ECommerceProduct

class EcommerceProduct: Record {
    @Field
    val sku: String = ""

    @Field
    val name: String? = null

    @Field
    val actualPrice: EcommercePrice? = null

    @Field
    val originalPrice: EcommercePrice? = null

    @Field
    val categoriesPath: List<String>? = null

    @Field
    val promocodes: List<String>? = null

    @Field
    val payload: Map<String,String>? = null

    fun toProduct(): ECommerceProduct {
        return ECommerceProduct(sku)
            .setName(name)
            .setPayload(payload)
            .setCategoriesPath(categoriesPath)
            .setActualPrice(actualPrice?.toEcommercPrice())
            .setOriginalPrice(originalPrice?.toEcommercPrice())
            .setPromocodes(promocodes)
    }
}

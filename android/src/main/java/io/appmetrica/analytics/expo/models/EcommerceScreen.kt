package io.appmetrica.analytics.expo.models

import expo.modules.kotlin.records.Field
import expo.modules.kotlin.records.Record
import io.appmetrica.analytics.ecommerce.ECommerceScreen

class EcommerceScreen: Record {
    @Field
    val name: String? = null

    @Field
    val searchQuery: String? = null

    @Field
    val payload: Map<String,String>? = null

    @Field
    val categoriesPath: List<String>? = null

    fun toScreen() : ECommerceScreen {
       return ECommerceScreen()
           .setName(name)
           .setPayload(payload)
           .setCategoriesPath(categoriesPath)
           .setSearchQuery(searchQuery)
    }
}
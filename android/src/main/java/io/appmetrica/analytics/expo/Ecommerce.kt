package io.appmetrica.analytics.expo

import expo.modules.kotlin.records.Field
import expo.modules.kotlin.records.Record
import io.appmetrica.analytics.ecommerce.ECommerceAmount
import io.appmetrica.analytics.ecommerce.ECommercePrice
import io.appmetrica.analytics.ecommerce.ECommerceProduct
import io.appmetrica.analytics.ecommerce.ECommerceReferrer
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

    fun toECommerceScreen() : ECommerceScreen {
       return ECommerceScreen()
           .setName(name)
           .setPayload(payload)
           .setCategoriesPath(categoriesPath)
           .setSearchQuery(searchQuery)
    }
}

class EcommerceAmount: Record {

    @Field
    val amount: Double = 0.0

    @Field
    val unit: String = ""

    fun toEcommerceAmount(): ECommerceAmount {
        return ECommerceAmount(amount, unit)
    }
}

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
            .setScreen(screen?.toECommerceScreen())
            .setType(type)
    }
}
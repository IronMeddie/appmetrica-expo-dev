package io.appmetrica.analytics.expo.models

import expo.modules.kotlin.records.Field
import expo.modules.kotlin.records.Record
import io.appmetrica.analytics.ecommerce.ECommerceEvent

class EcommerceEvent : Record {

    @Field
    val type: String = ""

    @Field
    val screen: EcommerceScreen? = null

    @Field
    val product: EcommerceProduct? = null


//    fun toEcommerce(): ECommerceEvent {
//        when (type) {
//            "showScreenEvent" -> ECommerceEvent.showScreenEvent(
//                screen?.toScreen() ?: throw ShowScreenEventException()
//            )
//
//            "showProductCardEvent" -> ECommerceEvent.showProductCardEvent(
//                product?.toProduct(),
//                screen?.toScreen()
//            )
//        }
//    }
}

//class ShowScreenEventException(message: String = "show screen event with null screen") :
//    Exception(message)
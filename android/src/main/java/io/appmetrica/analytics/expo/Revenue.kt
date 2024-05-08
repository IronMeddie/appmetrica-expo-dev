package io.appmetrica.analytics.expo

import expo.modules.kotlin.records.Field
import expo.modules.kotlin.records.Record
import java.util.Currency


class Revenue: Record {

    @Field
    val price: Long = 0

    @Field
    val currency: String = ""

    @Field
    val payload: String? = null

    @Field
    val productID: String? = null

    @Field
    val quantity: Int? = null

    @Field
    val receiptData: String? = null

    @Field
    val signature: String? = null


    fun toRevenue(): io.appmetrica.analytics.Revenue {
        return io.appmetrica.analytics.Revenue.newBuilder(
            (price * 1000000),
            Currency.getInstance(currency)).withProductID(productID)
            .withPayload(payload)
            .withQuantity(quantity)
            .withReceipt(toReceipt())
            .build()
    }

    fun toReceipt(): io.appmetrica.analytics.Revenue.Receipt {
        return io.appmetrica.analytics.Revenue.Receipt.newBuilder()
            .withData(receiptData)
            .withSignature(signature)
            .build()
    }

}
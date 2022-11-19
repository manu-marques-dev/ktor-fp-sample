package com.example.order.application

import Amount
import Item
import Order
import OrderItem
import OrderNumber
import Price
import arrow.optics.Iso
import arrow.optics.PIso
import kotlinx.serialization.Serializable

@Serializable
data class OrderItemDTO(
    val item: String,
    val amount: Int,
    val price: Double
) {
    companion object {
        val iso: Iso<OrderItemDTO, OrderItem> = PIso(
            get = {
                OrderItem(
                    item = Item(it.item),
                    amount = Amount(it.amount),
                    price = Price(it.price)
                )
            },
            reverseGet = {
                OrderItemDTO(
                    item = it.item.value,
                    amount = it.amount.value,
                    price = it.price.value
                )
            }
        )
    }
}

@Serializable
data class OrderDTO(
    val number: String,
    val contents: List<OrderItemDTO>
){
    companion object {
        val iso: Iso<OrderDTO, Order> = Iso(
            get = {
                Order(
                    number = OrderNumber(it.number),
                    contents = it.contents.map { orderItemDTO ->  OrderItemDTO.iso.get(orderItemDTO) }
                )
            },
            reverseGet = {
                OrderDTO(
                    number = it.number.value,
                    contents = it.contents.map { order -> OrderItemDTO.iso.reverseGet(order) }
                )
            }
        )
    }
}

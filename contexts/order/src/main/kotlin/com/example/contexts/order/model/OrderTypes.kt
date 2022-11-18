@JvmInline
value class OrderNumber(val value: String)

@JvmInline
value class Item(val value: String)

@JvmInline
value class Amount(val value: Int)

@JvmInline
value class Price(val value: Double)

data class Order(
    val number: OrderNumber,
    val contents: List<OrderItem>
) {
    fun getTotal(): Double = contents.sumOf { it.price.value * it.amount.value }
}

data class OrderItem(
    val item: Item,
    val amount: Amount,
    val price: Price
)

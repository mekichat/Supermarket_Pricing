
fun buyTwoGetOneFree(totalPrice : Int) : Double{
    //buy two, get one free (so does the third item have a price?)
    // let price for three item is = total price
    // then each item price could be 1/3 of total price.
    // price for third item could be total price minus 2/3 of total price

    return if(totalPrice < 1){
        0.0
    } else{
        (totalPrice).toDouble() - ((2/3.toDouble()))*totalPrice
    }
}

fun costInOunce(ounce:Int) : String{
    //$1.99/pound (so what does 4 ounces cost?)
    //1 pound (lb) = 16 ounces (oz) => $1.99
    return if (ounce <1) {
        ": \"The value for ounce should be at least 1\""
    } else{
        ": $" +  ounce * (1.99 / 16)
    }
}

fun aboveThreePrice(item: Int): Double{
    val priceTwo = 0.3
    val priceThree = 0.4
    val itemPrice :Double
    val intermediatePrice :Double
    val price: Double

    when {
        (item % 3) == 0 -> {
            itemPrice = ((item/3) * 1).toDouble()
        }
        (item % 3) == 1 -> {
            intermediatePrice = ( ( (item -1)/3 ) * 1).toDouble()
            //price = String.format("%.1f", intermediatePrice)
            //price = Math.round(intermediatePrice * 100.0) / 100.0
            //println("The amount is ${"%.2f".format(intermediatePrice)}")
            price = "%.2f".format(intermediatePrice).toDouble()
            //itemPrice = intermediatePrice + priceThree
            itemPrice = price + priceThree
        }
        else -> {
            intermediatePrice = ( ( (item -2)/3 ) * 1).toDouble()
            price = String.format("%.1f", intermediatePrice).toDouble()
            //price = Math.round(intermediatePrice * 10.0) / 10.0
            //itemPrice = intermediatePrice + priceTwo + priceThree
            itemPrice = price + priceTwo + priceThree
        }
    }
    return itemPrice
}

fun threeForOne(item: Int): Double {
    //three for a dollar (so what’s the price if I buy 4, or 5?)
    val priceOne = 0.3
    val priceTwo = 0.3
    val priceThree = 0.4

    return when {
        item < 1 -> 0.0
        item == 1 -> priceOne
        item == 2 -> priceTwo + priceThree
        item == 3 -> priceOne + priceTwo + priceThree
        else -> aboveThreePrice(item)   //for item > 3
    }
}

fun main() {

    //val persons = listOf(Person("Alice"),Person("Bob", age = 29))
    //val oldest = persons.maxBy { it.age ?: 0 }
    //println("The oldest is: $oldest")
    for (i in 0 .. 9) println("The price for $i items is: ${threeForOne(i)}")
    for (i in 0 .. 9) println("The price for $i ounce is ${costInOunce(i)}")
    for (i in 0 .. 9) println("Third item price for total price of $i is: ${buyTwoGetOneFree(i)}")

}
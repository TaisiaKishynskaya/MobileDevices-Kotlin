class Product(val name: String, val Price?: Double)
{
    fun displayProductInfo() {
        println("Name: $name")
        price?.let { println("Price: $it") }
    }
}

fun main() {
    val product = Product("Laptop", 40.44")
    product.displayProductInfo()
}

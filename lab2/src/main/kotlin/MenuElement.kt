open class MenuElement (val name: String) {
    // Метод для виведення інформації про елемент меню
    open fun display() {
        println("Елемент меню: $name")
    }
}
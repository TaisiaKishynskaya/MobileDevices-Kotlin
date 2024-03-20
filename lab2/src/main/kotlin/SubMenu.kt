// Підклас для підменю
class SubMenu(name: String) : MenuElement(name) {
    private val subMenuItems = mutableListOf<MenuElement>()

    // Метод для додавання елементів до підменю
    fun addMenuElement(menuElement: MenuElement) {
        subMenuItems.add(menuElement)
    }

    // Перевизначений метод для виведення інформації про підменю та всі елементи, що входять до нього
    override fun display() {
        println("Підменю: $name")
        println("Елементи підменю:")
        for (element in subMenuItems) {
            element.display()
        }
    }
}
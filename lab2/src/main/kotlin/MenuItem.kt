// Підклас для пункту меню
class MenuItem(name: String) : MenuElement(name) {
    override fun display() {
        println("Пункт меню: $name")
    }
}
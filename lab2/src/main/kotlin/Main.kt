fun main() {
    // Створення об'єктів різних типів елементів меню
    val menuItem = MenuItem("Налаштування")
    val separator = MenuSeparator()
    val subMenu = SubMenu("Файл")

    // Додавання елементів до підменю
    subMenu.addMenuElement(MenuItem("Відкрити"))
    subMenu.addMenuElement(MenuItem("Зберегти"))
    subMenu.addMenuElement(separator)
    subMenu.addMenuElement(MenuItem("Вийти"))

    // Виведення інформації про елементи меню
    menuItem.display()
    separator.display()
    subMenu.display()
}

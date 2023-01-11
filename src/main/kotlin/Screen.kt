import java.util.*

abstract class Screen<T> {
    abstract val list: MutableList<T>
    fun navigate() {
        printMenu(list)
        var input = Scanner(System.`in`).nextLine()
        while (input != Input.EXIT.code) {
            when (input) {
                Input.CREATE.code -> {
                    create()
                }
                else -> {
                    val param = input.toIntOrNull()
                    when {
                        param == null -> println("Вы ввели не число. Повторим")
                        (param - 2) >= 0 && (param - 2) < list.size -> {
                            val element = list[(param - 2)]
                            show(element)
                            exit()
                        }
                        else -> println("Такого пункта в меню нет. Повторим")
                    }
                }
            }
            printMenu(list)
            input = Scanner(System.`in`).nextLine()
        }
    }

    abstract fun create()
    abstract fun show(param: T)
    abstract fun printMenu(list: MutableList<T>)

    private fun exit() {
        do {
            println("Нажмите 0 для выхода.")
            val pressExit = Scanner(System.`in`).nextLine()
        } while (pressExit != "0")
    }
}
import java.util.*

class MainScreen : Screen<Archive>() {
    override val list: MutableList<Archive> = mutableListOf()
    private val archives = mutableMapOf<String, Archive>()
    override fun create() {
        println("Введите название архива")
        val archiveName = Scanner(System.`in`).nextLine()
        if (archives[archiveName] == null) {
            val arch = Archive(archiveName, mutableListOf())
            archives[archiveName] = arch
            list.add(arch)
        } else {
            println("Архив с таким названием уже есть. Придумайте другое название")
        }
    }

    override fun show(param: Archive) {
        val archiveScreen = ArchiveScreen(param)
        archiveScreen.navigate()
    }

    override fun printMenu(list: MutableList<Archive>) {
        println("${Input.CREATE.code}. Создать архив")
        for (i in list.indices) {
            println("${i + 2}. ${list[i].name}")
        }
        println("${Input.EXIT.code}. Выход")
        println("Введите число:")
    }
}

import java.util.Scanner

class ArchiveScreen(archive: Archive) : Screen<Note>() {
    override val list: MutableList<Note> = archive.notes

    private val notesMap = mutableMapOf<String, Note>()
    override fun create() {
        println("Придумайте название для заметки:")
        val noteName = Scanner(System.`in`).nextLine()
        if (notesMap[noteName] == null) {
            println("О чем заметка?")
            val noteContent = Scanner(System.`in`).nextLine()
            val not = Note(noteName, noteContent)
            notesMap[noteName] = not
            list.add(not)
        } else {
            println("Заметка с таким названием уже есть. Придумайте другое название")
        }
    }

    override fun show(param: Note) {
        println("Содержание заметки:\n${param.content}\n")
    }

    override fun printMenu(list: MutableList<Note>) {
        println("${Input.CREATE.code}. Создать заметку")
        for (i in list.indices) {
            println("${i + 2}. ${list[i].name}")
        }
        println("${Input.EXIT.code}. Выход")
        println("Введите число:")
    }
}
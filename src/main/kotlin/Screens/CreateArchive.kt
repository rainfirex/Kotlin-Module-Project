import Models.Archive
import Utils.ANSIColor
import Utils.InputConsole

class CreateArchive(private val archives: MutableList<Archive>) : IScreenCreate {
    init {
        println("- Добавление архива:")
    }

    override fun create() {
        val name = InputConsole.readText("Введите название архива или 0 чтобы вернуться назад:")
        when{
            name == "0" -> return
        }
        archives.add(Archive(name))
        println("${ANSIColor.GREEN}Архив \"$name\" создан.${ANSIColor.RESET}\n")
    }
}
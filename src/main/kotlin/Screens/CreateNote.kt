import Models.Archive
import Models.Note
import Utils.ANSIColor
import Utils.InputConsole

class CreateNote(private val archive: Archive?) : IScreenCreate {

    private val tmpManual = """${ANSIColor.YELLOW}
        ///////////////////////////////////
        /// Выполните следующие действия:
        /// 1. ${Menu.CREATE_ARCHIVE.title}, (меню ${Menu.CREATE_ARCHIVE.num})
        /// 2. ${Menu.SELECT_ARCHIVE.title}, (меню ${Menu.SELECT_ARCHIVE.num})
        /// 3. ${Menu.CREATE_NOTE.title}, (меню ${Menu.CREATE_NOTE.num})
        ///////////////////////////////////
        ${ANSIColor.RESET}
        """.trimMargin("/")

    init {
        println("- Создание заметки:")
    }

    override fun create() {
        if(archive == null){
            println("${ANSIColor.RED}Архив не выбран!${ANSIColor.RESET}")
            println(tmpManual)
            return
        }

        val title = InputConsole.readText("Введите название заметки или 0 чтобы вернуться назад:")
        when{
            title == "0" -> return
        }
        val content = InputConsole.readText("Введите текст заметки или 0 чтобы вернуться назад:")
        when{
            content == "0" -> return
        }
        archive.notes.add(Note(title, content))
        println("${ANSIColor.GREEN}Заметка \"$title\" создана.${ANSIColor.RESET}\n")
    }
}
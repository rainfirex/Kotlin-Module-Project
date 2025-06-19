import Models.Note
import Utils.ANSIColor
import Utils.InputConsole

class NoteScreen(private val note: Note?) {

    private val tmpManual = """${ANSIColor.YELLOW}
        ///////////////////////////////////
        /// Выполните следующие действия:
        /// 1. ${Menu.CREATE_ARCHIVE.title}, (меню ${Menu.CREATE_ARCHIVE.num})
        /// 2. ${Menu.SELECT_ARCHIVE.title}, (меню ${Menu.SELECT_ARCHIVE.num})
        /// 3. ${Menu.CREATE_NOTE.title}, (меню ${Menu.CREATE_NOTE.num})
        /// 4. ${Menu.SELECT_NOTE.title}, (меню ${Menu.SELECT_NOTE.num})           
        /// 5. ${Menu.NOTE_SCREEN.title}, (меню ${Menu.NOTE_SCREEN.num})
        ///////////////////////////////////
        ${ANSIColor.RESET}
        """.trimMargin("/")

    fun show(){
        if(note != null){
            println("- Просмотр заметки:")
            while (true){
                println("----------------------")
                println("Заголовок: ${note.title}")
                println("Текст: ${note.content}")
                println("----------------------")

                val c = InputConsole.readText("\nВведите текст для новой строки или 0 чтобы вернуться назад:")
                when{
                    c == "0" -> return
                    else -> note.content += "\nНовая строка: $c"
                }
            }
        }else{
            println("${ANSIColor.RED}Заметка не выбрана =(${ANSIColor.RESET}")
            println(tmpManual)
        }
    }
}
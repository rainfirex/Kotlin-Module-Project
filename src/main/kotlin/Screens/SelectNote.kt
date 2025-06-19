import Models.Archive
import Models.Note
import Utils.ANSIColor
import Utils.InputConsole

class SelectNote(private val archive: Archive?): IScreenSelect<Note?> {

    private val tmpManual = """${ANSIColor.YELLOW}
        ///////////////////////////////////
        /// Выполните следующие действия:
        /// 1. ${Menu.CREATE_ARCHIVE.title}, (меню ${Menu.CREATE_ARCHIVE.num})
        /// 2. ${Menu.SELECT_ARCHIVE.title}, (меню ${Menu.SELECT_ARCHIVE.num})
        /// 3. ${Menu.CREATE_NOTE.title}, (меню ${Menu.CREATE_NOTE.num})
        /// 4. ${Menu.SELECT_NOTE.title}, (меню ${Menu.SELECT_NOTE.num}) 
        ///////////////////////////////////
        ${ANSIColor.RESET}
        """.trimMargin("/")

    private var notes: MutableList<Note> = mutableListOf()

    init {
        if(archive != null && archive.notes.size > 0){
            println("- Список заметок:")
            this.notes = archive.notes
            notes.forEachIndexed{index, item -> println("${index+1}. ${item.title}") }
        }
    }

    override fun select() : Note?{
        if(notes.size > 0){

            println("\nВыбор заметки:")

            while (true){
                val index = InputConsole.readNumber("Введите номер заметки или 0 чтобы вернуться назад:")
                when{
                    index == 0 -> return null
                }

                if(index-1 > notes.size-1){
                    println("Заметка под номером $index не найдена.")
                }
                else{
                    val note: Note = notes[index-1]
                    println("${ANSIColor.GREEN}Заметка выбрана: $index. ${note.title}.${ANSIColor.RESET}\n")
                    return note
                }
            }
        }

        println("${ANSIColor.RED}Заметки еще не созданы =(${ANSIColor.RESET}")
        println(tmpManual)

        return null
    }
}
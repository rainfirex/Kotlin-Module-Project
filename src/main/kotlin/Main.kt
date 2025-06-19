import Models.Archive
import Models.Note
import Utils.ANSIColor
import Utils.InputConsole
import java.lang.NumberFormatException

fun main(args: Array<String>) {
    val archives = mutableListOf<Archive>()
    var archive: Archive? = null
    var note: Note? = null

    while (true){

        printMenu(archive, note)

        try {

            val command: String = InputConsole.readText("Введите номер меню:")//Scanner(System.`in`).nextLine().trim()
            if(command.isEmpty()) continue

            val isNum = command.all { it.isDigit() }
            when{
                !isNum -> {
                    println("${ANSIColor.RED}Следует вводить цифру!${ANSIColor.RESET}")
                    continue
                }
                command.toInt() > 5 -> {
                    println("${ANSIColor.RED}Команды под этой цифрой нет.${ANSIColor.RESET}")
                    continue
                }
            }
            val option: Int = command.toInt()
            when(option){
                Menu.SELECT_ARCHIVE.num -> archive = SelectArchive(archives).select()
                Menu.CREATE_ARCHIVE.num -> CreateArchive(archives).create()
                Menu.SELECT_NOTE.num -> note = SelectNote(archive).select()
                Menu.CREATE_NOTE.num -> CreateNote(archive).create()
                Menu.NOTE_SCREEN.num -> NoteScreen(note).show()
                Menu.ClOSE_APP.num -> return
                else -> {
                    println("Следует вводить цифру")
                    continue
                }
            }
        }
        catch (e: NumberFormatException){
            println(e)
        }
    }
}

private fun printMenu(archive: Archive?, note: Note?){
    println("\nГЛАВНОЕ МЕНЮ")
    if(archive != null){
        println("Выбранный архив: ${ANSIColor.GREEN}\"${archive.name}\"${ANSIColor.RESET}")
    }
    if(note != null){
        println("Выбраная заметка: ${ANSIColor.GREEN}\"${note.title}\"${ANSIColor.RESET}")
    }
    println("----------------------")
    for (item in Menu.values()){
        println("${item.num} - ${item.title}")
    }
    println("----------------------")
}
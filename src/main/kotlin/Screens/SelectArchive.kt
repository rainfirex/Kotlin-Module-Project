import Models.Archive
import Utils.ANSIColor
import Utils.InputConsole

class SelectArchive(private val archives: MutableList<Archive>): IScreenSelect<Archive?> {

    private val tmpManual = """${ANSIColor.YELLOW}
        ///////////////////////////////////
        /// Выполните следующие действия:
        /// 1. ${Menu.CREATE_ARCHIVE.title}, (меню ${Menu.CREATE_ARCHIVE.num})
        /// 2. ${Menu.SELECT_ARCHIVE.title}, (меню ${Menu.SELECT_ARCHIVE.num})
        ///////////////////////////////////
        ${ANSIColor.RESET}
        """.trimMargin("/")

    init {
        if(archives.size > 0){
            println("- Список архивов:")
            archives.forEachIndexed{index, item -> println("${ANSIColor.GREEN}${index+1}. ${item.name}${ANSIColor.RESET}") }
        }
    }

    override fun select(): Archive?{
        if (archives.size > 0){
            while (true){
                println("\nВыбор архива:")
                val index = InputConsole.readNumber("Введите номер архива или 0 чтобы вернуться назад:")
                when{
                    index == 0 -> return null
                }

                if(index-1 > archives.size-1){
                    println("${ANSIColor.RED}Архив под номером $index не найден.${ANSIColor.RESET}")
                }
                else{
                    val archive: Archive = archives[index-1]
                    println("${ANSIColor.GREEN}Архив выбран: $index. ${archive.name}.${ANSIColor.RESET}\n")
                    return archive
                }
            }
        }
        else{
            println("${ANSIColor.RED}Архивы еще не созданы =(${ANSIColor.RESET}")
            println(tmpManual)
        }

        return null
    }
}
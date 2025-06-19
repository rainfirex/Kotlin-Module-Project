package Utils

import java.util.Scanner

class InputConsole {
    companion object{
        private val getText: () -> String = {Scanner(System.`in`).nextLine().trim()}

        fun readText(message: String, error: String = "Пустая строка!"): String{
            while(true){
                println(message)
                val command = getText()
                if(command.isNotEmpty()){
                    return command
                }
                println("${ANSIColor.RED}$error${ANSIColor.RESET}")
            }
        }

        fun readNumber(message: String, error: String = "Неправильное значение"): Int{
            while(true){
                println(message)
                val command = getText()
                val isNum = command.all { it.isDigit() }

                if(command.isNotEmpty() && isNum){
                    return command.toInt()
                }
                println("${ANSIColor.RED}$error${ANSIColor.RESET}")
            }
        }
    }
}
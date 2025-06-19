enum class Menu(val num: Int, val title: String) {
    SELECT_ARCHIVE(1,"Выбор архива"),
    CREATE_ARCHIVE(2, "Создание архива"),
    SELECT_NOTE(3, "Выбор заметки"),
    CREATE_NOTE(4,"Создание заметки"),
    NOTE_SCREEN(5, "Экран заметки"),
    ClOSE_APP(0, "Выйти из программы")
}
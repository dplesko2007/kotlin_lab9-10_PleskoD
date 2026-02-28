package outpostState

import java.io.File

object StateStorage {
    private const val FILE_NAME = "outpost_state.txt"
    fun save(resources: List<ObservableResource>) {
        val file = File(FILE_NAME)
        file.writeText( resources.joinToString(separator = "\n") {
                "${it.name};${it.amount}" } )
        println("Состояние сохранено в файл '$FILE_NAME'")
    }
    fun load(): List<ObservableResource> {
        val file = File(FILE_NAME)
        if (!file.exists()) {
            println("Файл '$FILE_NAME' не найден. Начинаем с нуля.")
                return emptyList()
        }
        println("[StateStorage] Загружаем состояние из файла '$FILE_NAME'")
            return file.readLines()
                .filter { it.isNotBlank() }
                .map { line ->
                    val (name, amount) = line.split(";")
                    ObservableResource(name = name, initialAmount = amount.toInt())
                }
    }
}
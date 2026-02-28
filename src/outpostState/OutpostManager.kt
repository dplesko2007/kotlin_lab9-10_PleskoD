package outpostState

class OutpostManager {
    init {
        println("OutpostManager создан и готов к работе")
    }
    private val resources = mutableListOf<ObservableResource>()
    fun add(resource: ObservableResource) {
        resources.add(resource)
        println("Добавлен ресурс: ${resource.name} (${resource.amount})")
    }
    fun get(name: String): ObservableResource? =
        resources.find { it.name == name }
    fun getAll(): List<ObservableResource> = resources.toList()
    fun printAll() {
        println("\nРесурсы базы")
        resources.forEach { println(it) }
    }
}
object OutpostManagerProvider {
    val manager: OutpostManager by lazy {
        println("Инициализируем OutpostManager...")
        OutpostManager()
    }
}
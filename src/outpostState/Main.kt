package outpostState

fun main() {
    val manager = OutpostManagerProvider.manager
    val loaded = StateStorage.load()
    if (loaded.isNotEmpty()) {
        loaded.forEach { manager.add(it) }
    } else {
        // Файла нет — создаём начальные ресурсы
        val minerals = ObservableResource(name = "Minerals",
            initialAmount = 100)
        val gas = ObservableResource(name = "Gas",
            initialAmount = 50)
        val energy = ObservableResource(name = "Energy",
            initialAmount = 200)
        manager.add(minerals)
        manager.add(gas)
        manager.add(energy)
    }
    val observer = ResourceObserver(label = "HUD")
    manager.getAll().forEach { resource -> resource.addObserver(observer::onChanged)
    }
    println("\n=== Изменяем ресурсы ===")
    manager.get("Minerals")?.amount = 120
    manager.get("Gas")?.amount = 30
    manager.get("Energy")?.amount = 250
    manager.printAll()
    StateStorage.save(manager.getAll())
}
package outpostState

import kotlin.properties.Delegates
class ObservableResource(val name: String, initialAmount: Int) {
    private val observers = mutableListOf<(String, Int, Int) -> Unit>()
    var amount: Int by Delegates.observable(initialValue =
        initialAmount) { _, old, new ->
        println("Ресурс $name изменён: $old → $new")
        observers.forEach { observer -> observer(name, old, new) }
    }
    fun addObserver(observer: (String, Int, Int) -> Unit) {
        observers.add(observer)
    }
    override fun toString(): String = "$name: $amount"
}

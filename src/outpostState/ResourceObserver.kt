package outpostState

class ResourceObserver(private val label: String) {
    fun onChanged(resourceName: String, old: Int, new: Int) {
        val delta = new - old
        val sign = if (delta >= 0) "+" else ""
        println("[$label] Наблюдатель: $resourceName изменился на ${sign}${delta} (итого: $new)")
    }
}
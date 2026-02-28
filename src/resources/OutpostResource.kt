package resources
import kotlin.properties.Delegates

data class OutpostResource(
    val id: Int,
    val name: String,
    var amountInit: Int
) {
    override fun toString(): String {
        return "Ваш ресурс: $id | Имя: $name | Количество: $amount"
    }
    var amount: Int by Delegates.observable(initialValue =
        amountInit) { _, old, new ->
        println("Ресурс [$name] изменился: $old → $new")
    }
}


fun main() {
    val gas = OutpostResource(1,"Gas",100)
    val minerals = OutpostResource(2,"Minerals",250)
    println("Успех! Вы добыли дополнительное количество минералов: ${minerals.amount + 50}")
    val bonusMineral = minerals.copy(id = 3, name = "Minerals Bonus", minerals.amount + 50)
    println(gas.toString())
    println(minerals.toString())
    println(bonusMineral.toString())
}
package example

object GameSession {
    init {
        println("Игровая сессия создана")
    }
    var isActive: Boolean = false
    fun start() {
        isActive = true
        println("Игра началась")
    }
    fun end() {
        isActive = false
        println("Игра завершена")
    }
}
object Logger {
    var count = 0
    fun log(message: String) {
        count++
        println("[$count] $message")
    }
}
object AppSettings {
    val version = "1.0.0"
    var isDarkMode = true
    fun toggleTheme() {
        isDarkMode = !isDarkMode
    }
}
fun checkTheme() {
    if (AppSettings.isDarkMode) {
        println("Тёмная тема включена")
    }
}
object Colors {
    const val RED = "#FF0000"
    const val GREEN = "#00FF00"
    const val BLUE = "#0000FF"
}

class MyCar(val model: String) {
    fun drive() = println("$model едет")
}
object TrafficController {
    var carCount = 0
    fun carPassed() {
        carCount++
    }
}
sealed class OrderStatus {
    object Created : OrderStatus()
    object Paid : OrderStatus()
    object Shipped : OrderStatus()
    data class Cancelled(val reason: String) : OrderStatus()
}
fun handleOrder(status: OrderStatus) {
    when (status) {
        OrderStatus.Created -> println("Заказ создан")
        OrderStatus.Paid -> println("Заказ оплачен")
        OrderStatus.Shipped -> println("Заказ отправлен")
        is OrderStatus.Cancelled -> println("Отменён: ${status.reason}")
    }
}


fun main() {
    println("Программа запущена")
    println("Проверяем состояние, но не трогаем GameSession")
    println("Теперь запускаем игру")
    GameSession.start()
    println("Проверяем состояние ещё раз")
    println("Активна ли сессия: ${GameSession.isActive}")

    Logger.log("Первое сообщение")
    Logger.log("Второе сообщение")
    val logger1 = Logger
    val logger2 = Logger
    println(logger1 === logger2)

    val handler = object {
        val name = "Обработчик"
        fun handle() {
            println("Обрабатываю...")
        }
    }
    println(handler.name)
    handler.handle()

    MyCar(model = "Toyota")
    MyCar(model = "BMW")
    TrafficController.carPassed()

    handleOrder(status = OrderStatus.Created)
    handleOrder(status = OrderStatus.Paid)
    handleOrder(status = OrderStatus.Shipped)
    handleOrder(status = OrderStatus.Cancelled(reason = "Нет товара на складе"))

}

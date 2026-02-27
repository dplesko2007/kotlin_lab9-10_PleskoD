fun main() {
    val manager = ResourceManager()
    val minerals = OutpostResource(1,"Minerals",300)
    val gas = OutpostResource(2,"Gas",100)

    manager.add(minerals)
    manager.add(gas)
    manager.printAll()

    val bonus = minerals.copy(amount = minerals.amount + 50)
    println("Копия минералов с бонусом: $bonus")

    val denis: Human
//    val pavel: Human("Pavel")

    val denis2: Person = Person("Denis", 18)
    val maksim: Person = Person("Maksim", 20)
    denis2.hello()
    maksim.hello()
}
abstract class Human(val name: String) {
    abstract var age: Int
    abstract fun hello()
}
class Person(name: String, override var age: Int): Human(name) {
    override fun hello() {
        println("My name is $name")
    }
}
abstract class Figure {
    abstract fun perimeter(): Float
    abstract fun area(): Float
}
class Rectangle(val width: Float, val height: Float) : Figure() {
    override fun perimeter(): Float {
        return 2 * (width + height)
    }

    override fun area(): Float {
        return width * height
    }
}
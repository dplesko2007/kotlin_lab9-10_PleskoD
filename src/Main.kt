import modules.EnergyGenerator
import modules.ModuleResults
import modules.ResearchLab
import resources.OutpostResource
import resources.ResourceManager

//fun characters.characters.example.example.resources.main() {
//    val manager = resources.ResourceManager()
//    val minerals = resources.OutpostResource(1, "Minerals", 300)
//    val gas = resources.OutpostResource(2, "Gas", 100)
//
//    manager.add(minerals)
//    manager.add(gas)
//    manager.printAll()
//
//    val bonus = minerals.copy(amount = minerals.amount + 50)
//    println("Копия минералов с бонусом: $bonus")
//
//    //    val denis: example.Human
////    val pavel: example.Human("Pavel")
////
////    val denis2: example.Person = example.Person("Denis", 18)
////    val maksim: example.Person = example.Person("Maksim", 20)
////    denis2.hello()
////    maksim.hello()
////}

////}
//    abstract class Figure {
//        abstract fun perimeter(): Float
//        abstract fun area(): Float
//    }
//
//    class Rectangle(val width: Float, val height: Float) : Figure() {
//        override fun perimeter(): Float {
//            return 2 * (width + height)
//        }
//
//        override fun area(): Float {
//            return width * height
//        }
//    }
//}

fun main() {
    val manager = ResourceManager()

    manager.add(OutpostResource(1, "Minerals", 120))
    manager.add(OutpostResource(2, "Gas", 40))

    val generator = EnergyGenerator()
    val lab = ResearchLab()

    println()
    manager.printAll()

    fun handleModuleResult(result: ModuleResults) {
        when (result) {
            is ModuleResults.Success -> println("УСПЕХ: ${result.message}")
            is ModuleResults.ResourceProduced ->
                println("Произведено: ${result.resourceName} +${result.amount}")
            is ModuleResults.NotEnoughResources ->
                println("Недостаточно ресурса ${result.resourceName}. " + "Нужно: ${result.required}, есть:${result.available}")
            is ModuleResults.Error ->
                println("ОШИБКА: ${result.reason}")
        }
    }
    val generatorResult = generator.performAction(manager)
    val labResult = lab.performAction(manager)
    handleModuleResult(generatorResult)
    handleModuleResult(labResult)
    println()
    manager.printAll()
}
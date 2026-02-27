package modules

import resources.OutpostResource
import resources.ResourceManager

class EnergyGenerator : OutpostModule("Генератор энергии") {
    override fun performAction(manager: ResourceManager) : ModuleResults {
        println("Генератор работает... Производит 20 энергии")
        val energy = manager.get("Energy")
        return if (energy!=null) {
            energy.amount += 20
            ModuleResults.ResourceProduced(resourceName = "Energy", amount = 20)
        } else {
            manager.add(OutpostResource(99, "Energy", 20))
            ModuleResults.Success(message = "Энергия создана впервые")
        }
    }
}
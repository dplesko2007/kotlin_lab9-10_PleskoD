package modules

import resources.ResourceManager

class ResearchLab : OutpostModule("Исследовательская лаборатория") {
    override fun performAction(manager: ResourceManager) : ModuleResults {
        val minerals = manager.get("Minerals")
        if (minerals == null || minerals.amount<30) {
            println("Недостаточно минералов для исследования")
            return ModuleResults.NotEnoughResources(
                resourceName = "Minerals",
                required = 30,
                available = minerals?.amount?:0
            )
        } else {
            minerals.amount -= 30
            return ModuleResults.Success("Исследование завершено")
        }
    }
}
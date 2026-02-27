package modules

sealed class ModuleResults {
    data class Success(val message: String) : ModuleResults()
    data class ResourceProduced(
        val resourceName: String, val amount: Int
    ) : ModuleResults()
    data class NotEnoughResources(
        val resourceName: String,
        val required: Int,
        val available: Int
    ) : ModuleResults()
    data class Error(val reason: String) : ModuleResults()
}
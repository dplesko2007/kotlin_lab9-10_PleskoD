package Homework

class DevelopmentDepartment : Department() {
    override val departmentName: String = "Отдел разработки"
    override fun printDepartmentGoal() {
        println("Цель: Писать чистый и поддерживаемый код")
    }
}
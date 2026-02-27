package Homework

class DevelopmentDepartment : Department(), ReportGenerator {
    override val departmentName: String = "Отдел разработки"
    override fun printDepartmentGoal() {
        println("Цель: Писать чистый и поддерживаемый код")
    }
    override fun generateReport(): String {
        return "Название: $departmentName | Цель: разработка качественного ПО"
    }
}
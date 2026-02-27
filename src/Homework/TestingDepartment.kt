package Homework

class TestingDepartment : Department() {
    override val departmentName: String = "Отдел тестирования"
    override fun printDepartmentGoal() {
        println("Цель: Находить все баги до выхода в продакшн")
    }
}
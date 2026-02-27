package Homework

abstract class Department {
    abstract val departmentName: String
    abstract fun printDepartmentGoal()
    fun introduce() {
        println("Отдел: $departmentName")
        printDepartmentGoal()
    }
}
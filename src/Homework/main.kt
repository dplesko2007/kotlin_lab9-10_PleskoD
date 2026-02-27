package Homework

fun main() {
    val emp = Employee("Иван Петров", "Разработчик", 80000, 5)
    emp.salary = -5000
    emp.salary = 90000
    emp.yearsOfExperience = 100
    println(emp.salary)
    println(emp.yearsOfExperience)
}
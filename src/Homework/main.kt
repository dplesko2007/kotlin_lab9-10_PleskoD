package Homework
import Homework.priority.LOW
import Homework.priority.MEDIUM
import Homework.priority.HIGH

fun main() {
    val emp = Employee("Иван Петров", "Разработчик", 80000, 5)
    emp.salary = -5000
    emp.salary = 90000
    emp.yearsOfExperience = 100
    println(emp.salary)
    println(emp.yearsOfExperience)

    val task1 = task("Отчёт", "Написать отчёт", HIGH)
    val task2 = task("Отчёт", "Написать отчёт", HIGH)
    val task3 = task("Встреча", "Провести встречу", LOW)
    println(task1 == task2)
    println(task1 == task3)
    println(task1)
    val urgentTask = task1.copy(Priority = HIGH, isCompleted = false)
    println(urgentTask)
    println(task1.hashCode() == task2.hashCode())
    val (title, description, priority) = task1
    println("$title | $description | $priority")

    val dev = DevelopmentDepartment()
    val test = TestingDepartment()
    dev.introduce()
    test.introduce()

    val employee = Employee("Мария Иванова", "Тестировщик", 75000, 3)
    val devDept = DevelopmentDepartment()
    val reporters: List<ReportGenerator> = listOf(employee, devDept)
    reporters.forEach { reporter ->
        println(reporter.generateReport())
        println()
    }

    val emp2 = Employee("Алексей Смирнов", "Разработчик", 95000, 7)
    val dept = DevelopmentDepartment()
    val task4 = task("Рефакторинг", "Упростить модуль авторизации", HIGH)
    val task5 = task("Документация", "Написать README", LOW)
    val task6 = task("Code Review", "Проверить PR коллеги", MEDIUM)
    emp.assignTask(task1)
    emp.assignTask(task2)
    emp.completeTask()
    emp.assignTask(task3)
    println()
    println("Отчет:")
    println(emp.generateReport())
    println(dept.generateReport())
}
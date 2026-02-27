package Homework

fun main() {
    val emp = Employee("Иван Петров", "Разработчик", 80000, 5)
    emp.salary = -5000
    emp.salary = 90000
    emp.yearsOfExperience = 100
    println(emp.salary)
    println(emp.yearsOfExperience)

    val task1 = task("Отчёт", "Написать отчёт", priority.HIGH)
    val task2 = task("Отчёт", "Написать отчёт", priority.HIGH)
    val task3 = task("Встреча", "Провести встречу", priority.LOW)
    println(task1 == task2)
    println(task1 == task3)
    println(task1)
    val urgentTask = task1.copy(Priority = priority.HIGH, isCompleted = false)
    println(urgentTask)
    println(task1.hashCode() == task2.hashCode())
    val (title, description, priority) = task1
    println("$title | $description | $priority")

    val dev = DevelopmentDepartment()
    val test = TestingDepartment()
    dev.introduce()
    test.introduce()
}
package Homework

class Employee(
fullName: String,
position: String,
salary: Int,
yearsOfExperience: Int
) : ReportGenerator {
    val fullName: String = fullName
    val position: String = position
    var salary: Int = salary
        set(value) {
            if (value < 0) {
                println("Предупреждение: зарплата не может быть отрицательной!")
            } else {
                field = value
            }
        }
    var yearsOfExperience: Int = yearsOfExperience
        set(value) {
            field = value.coerceIn(0, 50)
            println("Опыт установлен: $field лет")
        }

    override fun generateReport(): String {
        return "ФИО: $fullName | Должность: $position | Зарплата: $salary | Опыт: $yearsOfExperience"
    }

    var currentTask: task? = null
        private set

    fun assignTask(newTask: task) {
        if (currentTask != null && currentTask!!.isCompleted == false) {
            println("Сотрудник уже занят задачей: ${currentTask!!.title}")
        } else {
            currentTask = newTask
            println("Задача '${newTask.title}' назначена сотруднику $fullName")
        }
    }

    fun completeTask() {
        currentTask = currentTask?.copy(isCompleted = true)
        println("Задача '${currentTask?.title}' завершена!")
    }
}

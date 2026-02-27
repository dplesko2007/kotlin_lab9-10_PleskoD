package Homework

class Employee(
fullName: String,
position: String,
salary: Int,
yearsOfExperience: Int
) {
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
}
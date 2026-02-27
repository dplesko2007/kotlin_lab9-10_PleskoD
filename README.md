~~# Лабораторная работа №9-10: Продвинутое ООП на Kotlin
## Описание
Лабораторная работа посвящена изучению продвинутых концепций объектно-ориентированногопрограммирования в Kotlin. ## Структура проекта
Проект содержит примеры реализации продвинутых механизмов ООП, а также пояснения к ключевымконцепциям. ## Как запустить проект
1. Клонируйте репозиторий: ```bash
git clone <URL_репозитория>
``` 2. Откройте проект в IntelliJ IDEA. 3. Запустите любой пример через контекстное меню или напрямую из `main`. 
2. ## Автор Плеско Д.
## Лицензия
Проект создан в учебных целях.

## Геттеры и сеттеры
Геттеры и сеттеры позволяют управлять доступом к свойствам.
Кастомный сеттер используется для валидации или ограничения значения.
Пример:
```kotlin
var age: Int = 18
 set(value) {
 if (value > 0 && value < 110) field = value
 }
fun main() {
 println(age) // 18
 age = 45
 println(age) // 45
 age = -345
 println(age) // 45 (не изменилось)
}
```
## Инкапсуляция
Инкапсуляция скрывает внутреннее состояние объекта.
Реализуется через модификаторы доступа и кастомные аксессоры.
Пример:
```kotlin
var level: Int = 1
 private set // только класс может изменять уровень
fun levelUp() {
 level++
 println("Уровень повышен до $level")
}
```
## Data-классы
Data-классы автоматически генерируют equals(), hashCode(),
toString(), copy(). Идеально подходят для хранения данных.
Пример:
```kotlin
data class Task(
 val id: Int,
 val name: String,
 val quantity: Int
)
val task = Task(1, "Work", 5)
val taskCopy = task.copy(quantity = 10)
println(task) // Task(id=1, name=Work, quantity=5)
println(taskCopy) // Task(id=1, name=Work, quantity=10)
```
## Абстрактные классы
Абстрактный класс нельзя создать напрямую. Он задаёт структуру
для подклассов и может содержать реализованные и абстрактные методы.
Пример:
```kotlin
abstract class Figure {
 abstract fun area(): Float
 abstract fun perimeter(): Float
}
class Rectangle(val w: Float, val h: Float) : Figure() {
 override fun area() = w * h
 override fun perimeter() = 2 * (w + h)
}
```
## Интерфейсы
Интерфейс — контракт поведения. Один класс может реализовывать
несколько интерфейсов, что решает проблему множественного наследования.
Пример:
```kotlin
interface VideoPlayable {
 fun play() = println("Play video")
}
interface AudioPlayable {
 fun play() = println("Play audio")
}
class MediaPlayer : VideoPlayable, AudioPlayable {
 override fun play() {
 println("Start playing")
 super<VideoPlayable>.play()
 super<AudioPlayable>.play()
 }
}
```
## Как запустить проект
1. Клонируйте репозиторий: git clone <URL>
2. Откройте проект в IntelliJ IDEA
3. Запустите Main.kt
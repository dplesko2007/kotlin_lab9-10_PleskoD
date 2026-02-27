interface Movable{
    var speed: Int
    val model: String
    val number: String
    fun move()
    fun stop() {
        println("Останавливаемся...")
    }
}
class Car (
    override val model: String,
    override val number: String
) : Movable{
    override var speed = 60
    override fun move() {
        println("Едем на машине со скоростью $speed км/ч")
    }
}
class Aircraft (
    override val model: String,
    override val number: String
) : Movable{
    override var speed = 600
    override fun move() {
        println("Летим на самолете со скоростью $speed км/ч")
    }

    override fun stop() {
        println("Приземляемся...")
    }
}
fun travel(obj: Movable) = obj.move()

//Playable
class MediaPlayer : VideoPlayable, AudioPlayable {
    override fun play() {
        println("Play audio and video")
        super<VideoPlayable>.play()
        super<AudioPlayable>.play()
    }

}

interface VideoPlayable {
    fun play() = println("play video")
}
interface AudioPlayable {
    fun play() = println("play audio")
}

fun main() {
    val car = Car("LADA", "134LAD")
    val aircraft = Aircraft("Boeing", "737")
    car.move()
    aircraft.move()
    aircraft.stop()
//    travel(car)
//    travel(aircraft)

    //Playable interface
    val player = MediaPlayer()
    player.play()
}
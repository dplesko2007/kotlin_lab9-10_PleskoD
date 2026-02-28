package gameCharacter

class GameCharacter(val name: String) {
    var state: CharacterState = CharacterState.Idle
        private set

    fun changeState(newState: CharacterState) {
        state = newState
        println("$name меняет состояние -> ${state::class.simpleName}")
    }
}
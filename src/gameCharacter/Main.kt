package gameCharacter

fun handleState(character: GameCharacter) {
    val name = character.name
    when (val state = character.state) {
        CharacterState.Idle ->
            println("$name бездействует")

        CharacterState.Running ->
            println("$name бежит")

        is CharacterState.Attack ->
            println("$name атакует с уроном ${state.damage}")

        is CharacterState.Death ->
            println("$name погиб: ${state.cause}")
    }
}

fun main() {
    val hero = GameCharacter(name = "Артур")
    handleState(hero)
    hero.changeState(CharacterState.Running)
    handleState(hero)
    hero.changeState(CharacterState.Attack(damage = 42))
    handleState(hero)
    hero.changeState(CharacterState.Death(cause = "Попал под дракона"))
    handleState(hero)
}
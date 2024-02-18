import interfaces.IDice

class DicesRoller(private val dices:  List<IDice>) {
    fun roll():Int {
        return dices.sumOf { it.roll() }
    }
}
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

import dices.D6
import loggers.ConsoleLogger
import  Game

fun main() {

    val dr = DicesRoller(listOf(D6(),D6()))
    val cl = ConsoleLogger()
    val maxCells = 65
    val g = Game(listOf(Player("Stepa",maxCells),
                        Player("Vera",maxCells),
                        Player("Vasya",maxCells)),
                dr,
                cl,
                maxCells)
    g.play()

}
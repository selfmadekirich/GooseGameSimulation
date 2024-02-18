package cells
import interfaces.Cell
import interfaces.ILogger

import Player

class OversteppedCell(private val logger:ILogger):Cell {
    override fun throwEvent(player: Player) {
        logger.log("${player.name} will move back ${player.getLastThrownValue()} cells!")
        player.acceptEvent(player.getCurrentCell() - player.getLastThrownValue(),player.getTurnsToSkip(),player.getNeedWaitAnotherPlayer())
    }

    override fun toString(): String {
        return "Overstepped Cell"
    }
}
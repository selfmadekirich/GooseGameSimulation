package cells
import interfaces.Cell
import interfaces.ILogger

import Player

class BasicCell(private val logger:ILogger):Cell {
    override fun throwEvent(player: Player) {
        logger.log("No side effects on this cell!")
    }

    override fun toString(): String {
        return "Basic Cell"
    }
}
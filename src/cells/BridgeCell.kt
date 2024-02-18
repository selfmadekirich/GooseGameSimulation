package cells
import interfaces.Cell
import Player
import interfaces.ILogger

class BridgeCell(private val distCell:Int,private val logger: ILogger):Cell {

    override fun throwEvent(player: Player) {
        logger.log("${player.name} will move to $distCell cell!")
        player.acceptEvent(this.distCell,player.getTurnsToSkip(),player.getNeedWaitAnotherPlayer())
    }

    override fun toString(): String {
        return "Bridge Cell"
    }
}
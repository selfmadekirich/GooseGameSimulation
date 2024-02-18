import interfaces.Cell
import interfaces.ILogger

class DeathCell(private val logger: ILogger): Cell {

    override fun throwEvent(player: Player) {
        logger.log("${player.name} will move to the begging cell!")
        player.acceptEvent(0,player.getTurnsToSkip(),player.getNeedWaitAnotherPlayer())
    }

    override fun toString(): String {
        return "Death Cell"
    }
}
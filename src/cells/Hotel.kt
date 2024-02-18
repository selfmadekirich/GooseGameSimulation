package cells
import interfaces.Cell
import Player
import interfaces.ILogger

class HotelCell(private val logger: ILogger):Cell {

    override fun throwEvent(player: Player) {
           logger.log("${player.name} will skip next turn!")
            player.acceptEvent(player.getCurrentCell(),
                1,
            player.getNeedWaitAnotherPlayer())
    }

    override fun toString(): String {
        return "Bridge Cell"
    }
}
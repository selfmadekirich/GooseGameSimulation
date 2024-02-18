package cells
import interfaces.Cell
import Player
import interfaces.ILogger

class WellCell(private val logger: ILogger):Cell {
    private var oldPlayer:Player? = null

    override fun throwEvent(player: Player) {
        logger.log("${player.name} will be here until smb helps him!")

        if (oldPlayer != null) {

            logger.log("${oldPlayer?.name} is released! ")

            oldPlayer?.acceptEvent(player.getCurrentCell(),
                0,
                false)
        }

        if (this.oldPlayer == null) {
            oldPlayer = player
        }

        player.acceptEvent(
            player.getCurrentCell(),
            0,
            true
        )
    }


    override fun toString(): String {
        return "Well Cell"
    }
}
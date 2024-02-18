import interfaces.Cell
import cells.*
import interfaces.ILogger


class Game(
    private val players:List<Player>,
    private val dr: DicesRoller,
    private val logger: ILogger,
    cellNums:Int) {

    private val board = MutableList<Cell>(cellNums){ BasicCell(logger) }

    init {
        board[6] = BridgeCell(12,logger)
        board[19] = HotelCell(logger)
        board[31] = WellCell(logger)
        board[42] = MazeCell(39,logger)
        board[52] = PrisonCell(logger)
        board[58] = DeathCell(logger)
        for (i in 64..<cellNums){
            board[i] = OversteppedCell(logger)
        }
    }

    private fun getPlayingOrder():MutableList<Player>{
        val playersDiceList = mutableMapOf<Player, Int>().apply { for (pl in players){ this[pl] = dr.roll()} }

        for(pl in playersDiceList){
            logger.log("${pl.key.name} has thrown ${pl.value}")
        }
        return mutableListOf<Player>().apply{for (pl in playersDiceList.entries.sortedByDescending{ it.value }){ this.add(pl.key) } }
    }

    fun play(){
       for(player in players){
           logger.log("${player.name} joined game!")
       }

        logger.log("Game started!")

        logger.log("Rolling dices to determine order")
        val sortedPlayers = getPlayingOrder()

        logger.log("Players will be playing in this order:")
        for (pl in sortedPlayers){
            logger.log(pl.name)
        }

        var round = 1
        var gameFinished = false
        while(round < 1000 && !gameFinished){
            logger.log("Round $round start!")
            for(pl in sortedPlayers){
                logger.log("Now is ${pl.name} turn")

                val thrownValue = dr.roll()

                logger.log("${pl.name} throws $thrownValue")

                val hasMoved = pl.tryMove(thrownValue)
                if(pl.getCurrentCell() == 63){
                        logger.log("${pl.name} wins!")
                        gameFinished = true
                        break
                }

                if(hasMoved){
                    logger.log("${pl.name} lands on cell with number ${pl.getCurrentCell()}  which is ${board[pl.getCurrentCell()]}")
                    board[pl.getCurrentCell()].throwEvent(pl)
                }

            }
            if (!gameFinished) {
                logger.log("Round $round ends!")
                round++
            }
        }

        if (!gameFinished){
        logger.log("Ooops! Seems to be draw!")
        }


    }
}
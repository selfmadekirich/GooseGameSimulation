import kotlin.math.max
import kotlin.math.min

data class Player(val name:String,val maxCells:Int) {

    private var currentCell:Int = 0
    private var turnToSkip:Int = 0
    private var waitAnotherPlayer:Boolean = false
    private var lastThrownValue:Int = 0

    fun getCurrentCell() = currentCell
    fun getTurnsToSkip() = turnToSkip
    fun getNeedWaitAnotherPlayer() = waitAnotherPlayer
    fun getLastThrownValue() = lastThrownValue

    fun tryMove(cellNums:Int):Boolean{

            if(turnToSkip != 0){
                turnToSkip--
                return false
            }
            if (waitAnotherPlayer){
               return  false
            }
        lastThrownValue = cellNums
        currentCell = min(currentCell+cellNums,maxCells-1)
        return true
    }

    fun acceptEvent(newCell:Int,turnToSkip:Int,waitAnotherPlayer:Boolean){
        this.currentCell = newCell
        this.turnToSkip = turnToSkip
        this.waitAnotherPlayer = waitAnotherPlayer
    }
}
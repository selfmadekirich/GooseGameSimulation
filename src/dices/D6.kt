package dices
import interfaces.IDice
class D6: IDice {
    override fun roll() =  (1..6).random()
}
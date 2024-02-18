package loggers
import interfaces.ILogger
class ConsoleLogger:ILogger {
    override fun log(logString: String) {
        val currentDateTime = java.util.Date().toString()
        println("$currentDateTime : $logString")
    }
}
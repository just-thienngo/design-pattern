package creationalPatterns

import java.util.Locale


interface Computer {
    fun getType(): String
}

class Laptop : Computer {
    override fun getType() = "Laptop"
}

class Desktop : Computer {
    override fun getType() = "Desktop"
}
object ComputerFactory {

    fun createComputer(type: String): Computer? {
        return when (type.lowercase(Locale.ROOT)) {
            "laptop" -> Laptop()
            "desktop" -> Desktop()
            else -> null
        }
    }
}

fun main()
{
    val myLaptop = ComputerFactory.createComputer("Laptop")
    val myDesktop = ComputerFactory.createComputer("Desktop")

    println("Laptop: ${myLaptop?.getType()}")
    println("Desktop: ${myDesktop?.getType()}")
}
package behavioralPatterns


// Interface cho người quan sát
interface WeatherObserver {
    fun onWeatherUpdate(temperature: Int)
}
// Đối tượng được quan sát (Subject)
class WeatherStation {
    private val observers = mutableListOf<WeatherObserver>()
    private var temperature: Int = 0
        set(value) {
            field = value
            notifyObservers() // Thông báo khi nhiệt độ thay đổi
        }

    fun addObserver(observer: WeatherObserver) {
        observers.add(observer)
    }

    fun removeObserver(observer: WeatherObserver) {
        observers.remove(observer)
    }

    private fun notifyObservers() {
        for (observer in observers) {
            observer.onWeatherUpdate(temperature)
        }
    }

    // Hàm để thay đổi trạng thái
    fun updateTemperature(newTemp: Int) {
        this.temperature = newTemp
    }
}
// Một người quan sát cụ thể
class PhoneDisplay : WeatherObserver {
    override fun onWeatherUpdate(temperature: Int) {
        println("Phone Display: Weather updated! New temperature is $temperature°C")
    }
}

// Một người quan sát khác
class WindowDisplay : WeatherObserver {
    override fun onWeatherUpdate(temperature: Int) {
        if (temperature > 25) {
            println("Window Display: It's hot! Temperature is $temperature°C")
        }
    }
}


fun main()
{
    val weatherStation = WeatherStation()
    val phone = PhoneDisplay()
    val window = WindowDisplay()

    // Đăng ký các observers
    weatherStation.addObserver(phone)
    weatherStation.addObserver(window)

    // Thay đổi trạng thái của Subject
    println("--- Setting temperature to 27°C ---")
    weatherStation.updateTemperature(27)

    println("\n--- Setting temperature to 15°C ---")
    weatherStation.updateTemperature(15)
}
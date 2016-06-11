object BerlinClock {

    val TopHoursLampCount = 4
    val BottomHoursLampCount = 4
    val TopMinutesLampCount = 11
    val BottomMinutesLampCount = 4
    val HoursPerLamp, MinutesPerLamp = 5


    def convertToBerlinTime(time: String) = {
        val timeArray = time.split(":").map(_.toInt)
        val secondsInt = timeArray(2)
        val minutesInt = timeArray(1)
        val hoursInt = timeArray(0)
        Array(
            seconds(secondsInt),
            topHours(hoursInt), bottomHours(hoursInt),
            topMinutes(minutesInt), bottomMinutes(minutesInt))
    }


    def bottomMinutes(minutes: Int) =
        onOffSigns(BottomMinutesLampCount, minutes%MinutesPerLamp, "Y")

    def topMinutes(minutes: Int) =
        onOffSigns(TopMinutesLampCount, minutes/MinutesPerLamp, "Y").replace("YYY", "YYR")

    def bottomHours(hours: Int) =
        onOffSigns(BottomHoursLampCount, hours % HoursPerLamp, "R")

    def topHours(hours: Int) =
        onOffSigns(TopHoursLampCount, hours / HoursPerLamp, "R")


    def seconds(seconds: Int) = if (seconds % 2 == 0) "Y" else "O"

    private def onOffSigns(lampsCount: Int, onSignsCount: Int, onSign: String) = {
        onSign * onSignsCount + "O" * (lampsCount - onSignsCount)
    }

}
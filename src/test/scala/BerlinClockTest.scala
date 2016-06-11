import org.scalatest.{FlatSpec, Matchers}

class BerlinClockTest extends FlatSpec with Matchers {

    val AnyHours = 21
    val AnyMinutes = 56

    "Top seconds" must "light yellow light on even seconds and off on odd seconds" in {
        BerlinClock.seconds(0) should be("Y")
        BerlinClock.seconds(1) should be("O")
        BerlinClock.seconds(10) should be("Y")
    }

    "Top hours" must "have 4 lamps" in {
        BerlinClock.topHours(AnyHours).length should be(4)
    }

    it must "light red lamps for each 5 hours" in {
        BerlinClock.topHours(0) should be("OOOO")
        BerlinClock.topHours(6) should be("ROOO")
        BerlinClock.topHours(11) should be("RROO")
        BerlinClock.topHours(15) should be("RRRO")
        BerlinClock.topHours(21) should be("RRRR")
    }

    "Bottom hours" must "have 4 lamps" in {
        BerlinClock.bottomHours(AnyHours).length should be(4)
    }

    it must "light red lamps for hours that left from topHours" in {
        BerlinClock.bottomHours(15) should be("OOOO")
        BerlinClock.bottomHours(1) should be("ROOO")
        BerlinClock.bottomHours(7) should be("RROO")
        BerlinClock.bottomHours(13) should be("RRRO")
        BerlinClock.bottomHours(14) should be("RRRR")
    }

    "Top minutes" must "have 11 lamps" in {
        BerlinClock.topMinutes(AnyMinutes).length should be(11)
    }

    it must "light up yellow lamps for every 5 minutes, but, 3, 6, 9 should be red" in {
        BerlinClock.topMinutes(0) should be("OOOOOOOOOOO")
        BerlinClock.topMinutes(5) should be("YOOOOOOOOOO")
        BerlinClock.topMinutes(10) should be("YYOOOOOOOOO")
        BerlinClock.topMinutes(15) should be("YYROOOOOOOO")
        BerlinClock.topMinutes(20) should be("YYRYOOOOOOO")
        BerlinClock.topMinutes(25) should be("YYRYYOOOOOO")
        BerlinClock.topMinutes(30) should be("YYRYYROOOOO")
        BerlinClock.topMinutes(35) should be("YYRYYRYOOOO")
        BerlinClock.topMinutes(40) should be("YYRYYRYYOOO")
        BerlinClock.topMinutes(45) should be("YYRYYRYYROO")
        BerlinClock.topMinutes(50) should be("YYRYYRYYRYO")
        BerlinClock.topMinutes(55) should be("YYRYYRYYRYY")
    }

    "Bottom minutes" must "have 4 lamps" in {
        BerlinClock.bottomMinutes(AnyMinutes).length should be(4)
    }

    it must "light up yellow lamps the left from top minutes's lamps" in {
        BerlinClock.bottomMinutes(0) should be("OOOO")
        BerlinClock.bottomMinutes(1) should be("YOOO")
        BerlinClock.bottomMinutes(2) should be("YYOO")
        BerlinClock.bottomMinutes(3) should be("YYYO")
        BerlinClock.bottomMinutes(4) should be("YYYY")
        BerlinClock.bottomMinutes(5) should be("OOOO")
        BerlinClock.bottomMinutes(6) should be("YOOO")
    }

    "BerlinClock" should "result in array with 5 elements" in {
        BerlinClock.convertToBerlinTime("13:17:01").size should be(5)
    }

    it should "result in correct seconds, hours, and minutes" in {
        val berlinTime = BerlinClock.convertToBerlinTime("16:37:16")
        val expected = Array("Y", "RRRO", "ROOO", "YYRYYRYOOOO", "YYOO")
        berlinTime should be(expected)
    }

}

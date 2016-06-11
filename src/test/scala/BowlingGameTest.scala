import org.scalatest.{BeforeAndAfterEach, FlatSpec, Matchers}

/**
  * Created by Pajace on 2016/6/11.
  */
class BowlingGameTest extends FlatSpec with Matchers with BeforeAndAfterEach {

    var game : BowlingGame = _

    override protected def beforeEach(): Unit = {
        game = new BowlingGame
    }

    private def rollMany(n:Int, pins:Int) = (1 to n).foreach(rolls=> game.roll(pins))

    "BowlingGame" should "be create by new" in {
        game.isInstanceOf[BowlingGame] should be (true)
    }

    "Score" should "be 0, if all frames are knocked 0 pin" in {
        rollMany(20, 0)
        game.score should be (0)
    }

    it should "be 20, if all knocked 1 pins for every rolls in every frames" in {
        rollMany(20, 1)
        game.score should be (20)
    }

    "One spare" should "get bonus by next frame's first roll's pins" in {
        rollSpare(5)
        game.roll(3)
        rollMany(17, 0)

        game.score should be (16)
    }

    "One strike" should "get bouns by next frame's score" in {
        rollStrike()
        game.roll(3)
        game.roll(4)
        rollMany(16, 0)

        game.score() should be (24)
    }

    "PerfectGame" should "get 300 as score" in {
        rollMany(12, 10)

        game.score() should be (300)
    }

    private def rollStrike(): Unit = {
        game.roll(10)
    }

    private def rollSpare(firstRoll:Int): Unit = {
        game.roll(firstRoll)
        game.roll(10-firstRoll)
    }
}

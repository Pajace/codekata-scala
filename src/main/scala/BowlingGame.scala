

/**
  * Created by Pajace on 2016/6/11.
  */
class BowlingGame {

    var rolls = List[Int]()

    def roll(pins: Int) = {
        rolls = rolls :+ pins
    }

    def score() = {
        var totalScore = 0
        var frameIndex = 0

        def increaseFrameIndex(bonusType: BonusType.Value) = bonusType match {
            case BonusType.Strike => frameIndex = frameIndex + 1
            case _ => frameIndex = frameIndex + 2
        }

        for (frame <- 1 to 10) {
            val twoRollScore = (rolls(frameIndex), rolls(frameIndex + 1))
            val result = calculateFrameScore(twoRollScore, frameIndex)

            increaseFrameIndex(result._2)
            totalScore = totalScore + result._1
        }
        totalScore
    }

    private def calculateFrameScore(score: (Int, Int), frameIndex: Int) = (isStrike(score), isSpare(score)) match {
        case (true, false) =>
            val result = score._1 + rolls(frameIndex + 1) + rolls(frameIndex + 2)
            (result, BonusType.Strike)
        case (false, true) =>
            val result = score.sum + rolls(frameIndex + 2)
            (result, BonusType.Spare)
        case _ =>
            (score.sum, BonusType.None)
    }

    private def isSpare(score: (Int, Int)) = score.sum == 10

    private def isStrike(score: (Int, Int)) = score._1 == 10

    implicit class ImproveTuple(value: (Int, Int)) {
        def sum = value._1 + value._2
    }

    object BonusType extends Enumeration {
        val Strike, Spare, None = Value
    }

}
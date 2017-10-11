import org.scalatest.{FlatSpec, Matchers}

/**
  * Created by pajace_chen on 2016/6/3.
  */
class FizzBuzzTest extends FlatSpec with Matchers {

    "FizzBuzz" should "return Fizz, if number is dividable by 3 " in {
        FizzBuzz.calcResult(3) should be ("Fizz")
        FizzBuzz.calcResult(6) should be ("Fizz")
    }

    it should "return Buzz, if the number is dividable by 5" in {
        FizzBuzz.calcResult(5) should be ("Buzz")
        FizzBuzz.calcResult(10) should be ("Buzz")
    }

    it should "return FizzBuzz if the number is dividable by 15" in {
        FizzBuzz.calcResult(15) should be ("FizzBuzz")
        FizzBuzz.calcResult(30) should be ("FizzBuzz")
    }

    it should "return the same number if no other requirement is fulfilled" in {
        FizzBuzz.calcResult(1) should be ("1")
        FizzBuzz.calcResult(2) should be ("2")
        FizzBuzz.calcResult(4) should be ("4")
    }

}

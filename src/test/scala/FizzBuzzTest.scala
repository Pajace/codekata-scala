import org.scalatest.{FlatSpec, Matchers}
import com.logdown.mycodetub.easy.FizzBuzz

/**
  * Created by pajace_chen on 2016/6/3.
  */
class FizzBuzzTest extends FlatSpec with Matchers {

    "FizzBuzz" should "return Fizz, if number is dividable by 3 " in {
        FizzBuzz.getResult(3) should be ("Fizz")
        FizzBuzz.getResult(6) should be ("Fizz")
    }

    it should "return Buzz, if the number is dividable by 5" in {
        FizzBuzz.getResult(5) should be ("Buzz")
        FizzBuzz.getResult(10) should be ("Buzz")
    }

    it should "return FizzBuzz if the number is dividable by 15" in {
        FizzBuzz.getResult(15) should be ("FizzBuzz")
        FizzBuzz.getResult(30) should be ("FizzBuzz")
    }

    it should "return the same number if no other requirement is fulfilled" in {
        FizzBuzz.getResult(1) should be ("1")
        FizzBuzz.getResult(2) should be ("2")
        FizzBuzz.getResult(4) should be ("4")
    }

}

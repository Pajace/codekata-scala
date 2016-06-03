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

}

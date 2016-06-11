/**
  * Created by pajace_chen on 2016/6/3.
  */
object FizzBuzz {
    def getResult(number: Int) = (number % 3, number % 5) match {
        case (0, 0) => "FizzBuzz"
        case (0, _) => "Fizz"
        case (_, 0) => "Buzz"
        case (_) => number.toString
    }
}

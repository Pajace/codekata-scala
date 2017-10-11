/**
  * Created by pajace_chen on 2016/6/3.
  */
object FizzBuzz {

    implicit class FizzBuzzEnhancement(input: Int) {

        def isFizz: Int => Boolean = x => x % 3 == 0

        def isBuzz: Int => Boolean = x => x % 5 == 0

        def isFizzBuzz: Int => Boolean = x => isFizz(x) && isBuzz(x)

        def determineFizzBuzz: String = {
            val result =
                if (isFizzBuzz(input)) "FizzBuzz"
                else if (isFizz(input)) "Fizz"
                else if (isBuzz(input)) "Buzz"
                else input.toString
            result
        }
    }

    def calcResult: Int => String = input => input.determineFizzBuzz

}

package com.logdown.mycodetub.easy

/**
  * Created by pajace_chen on 2016/6/3.
  */
object FizzBuzz {
    def getResult(number: Int) = (number % 3 == 0, number % 5 == 0) match {
        case (true, true) => "FizzBuzz"
        case (true, _) => "Fizz"
        case (_, true) => "Buzz"
        case (_) => number.toString
    }
}

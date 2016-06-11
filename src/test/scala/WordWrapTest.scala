import org.scalatest.{FlatSpec, Matchers}
import WordWrap._

/**
  * Created by Pajace on 2016/6/11.
  */
class WordWrapTest extends FlatSpec with Matchers {

    val AnyNumber = 10

    "WordWrap" should "return empty string if there is no text is specified" in {
        "".wordWrap(AnyNumber) should be("")
    }

    it should "work with a single word" in {
        "Kata".wordWrap(4) should be("Kata")
    }

    it should "return wrapped text with small sample" in {
        val input = "This kata"
        val expected = "This\nkata"
        input.wordWrap(4) should be(expected)
    }

    it should "return wrapped text" in {
        val input = "This kata should be easy unless there are hidden, or not hidden, obstacles. Let's tart!"
        val expected = "This kata\n" +
            //23456789012
            "should be\n" +
            "easy unless\n" +
            "there are\n" +
            "hidden, or\n" +
            "not hidden,\n" +
            "obstacles.\n" +
            "Let's tart!"
        input wordWrap (12) should be(expected)
    }

    it should "return the same text if max length is the same as the length of the text" in {
        val input = "Lorem ipsum dolor sit amet."
        val expected = "Lorem ipsum dolor sit amet."
        input.wordWrap(input.length) should be(expected)
    }

}

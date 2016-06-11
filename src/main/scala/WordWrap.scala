/**
  * Created by Pajace on 2016/6/11.
  */

object WordWrap {

    implicit class StringImprovements(text: String) {

        def wordWrap(maxLengthForWrap: Int): String = {
            val textArray = text.split(" ")
            textArray.foldLeft(Array(""))((out, in) => {
                val withNexWordLength = (out.last + " " + in).trim.size
                if (withNexWordLength > maxLengthForWrap) out :+ in
                else out.updated(out.size - 1, out.last.trim + " " + in)
            }).mkString("\n").trim

        }
    }

}


package dev.lavi

import org.jsoup.nodes.Document
import org.junit.Assert.*
import org.junit.Test

class ParserTest {
    @Test
    fun `Downloads the page, saves it to the file, counts number of uniq words and prints the statistics` (){
        Parser.address= "http://google.com"
        val page : Document = Parser.getPage()
        Parser.countUniqWords(Parser.parsePage(page))
        Parser.saveFile(page)
    }

}

package dev.lavi

import org.jsoup.*
import org.jsoup.nodes.Document
import java.io.File
import java.io.FileWriter

object Parser {

    var address: String? = null

    fun saveFile(page: Document ) {

        val outputFile = File("fullPageText.txt")
        outputFile.createNewFile()
        val writer = FileWriter(outputFile)
        writer.write(page.body().text())
        writer.flush()
        writer.close()
    }
    fun countUniqWords(words:List<String>) {
        val wordsMap = mutableMapOf<String, Int>()
        words.forEach {
            val word = wordsMap[it]
            if(word==null){
                wordsMap[it] = 1
            } else {
                wordsMap[it]= word+1
            }
        }
        wordsMap.forEach(System.out::println)
    }
    fun getPage():Document {
        return Jsoup.connect(address).get()

    }

    fun parsePage(page: Document) : List<String> {

        return page.body().text().split(' ', ',', '.', '!', '?', '-', '-','"', ';', ':', '[', ']', '(', ')', '\n', '\r', '\t', ignoreCase = true)

    }

}

package dk.fyhr.kotlin.personalLibrary

fun main() {
    displayMainMenu()
}

fun displayMainMenu() {
    println("""
            Welcome to your Personal Library
            --------------------------------
            1 - Create new book entry
            2 - Delete book entry
            3 - Show list of books
            9 - Close application
            --------------------------------
            Select option: 
            """.trimIndent())

    readln() // wait for user input
}

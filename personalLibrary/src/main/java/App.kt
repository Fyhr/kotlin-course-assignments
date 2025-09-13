package dk.fyhr.kotlin.personalLibrary

import dk.fyhr.kotlin.personalLibrary.dk.fyhr.kotlin.personalLibrary.Book


val books = mutableListOf<Book>()

fun main() {
    displayMainMenu()
}

fun displayMainMenu() {
    while (true){
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

        val choice = readln().toInt()
        when(choice){
            1 -> enterCreateBookMode()
            else -> println("Invalid option [$choice]")
        }
    }
}

fun enterCreateBookMode() {
    do{
        println("Enter book title:")
        val title = readln()
        println("Enter number of pages:")
        val numberOfPages = readln().toInt()
        println("Enter purchase price:")
        val price = readln().toDouble()
        println("Enter condition:")
        val condition = readln()

        val priceInCents = (price * 100).toInt()
        val book = Book(title, numberOfPages, priceInCents, condition)

        books.add(book)
        println()
        println("Book added: $title")
        println()
        println("Do you want to add another book? (yes/no): ")
    } while(readln().lowercase() == "yes")
}
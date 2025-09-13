package dk.fyhr.kotlin.personalLibrary

private const val currency = '€'
val books = mutableListOf<Book>()

fun main() {
    books.add(Book("The Hobbit", 250, 1250, "New"))
    books.add(Book("Lord Of The Rings", 756, 4000, "Minimal Wear"))
    books.add(Book("The Golden Compass", 300, 1525, "New"))

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

        when(val choice = readln().toInt()){
            1 -> enterCreateBookMode()
            3 -> enterViewBookListMode()
            9 -> break
            else -> println("Invalid option [$choice]")
        }
    }
}

fun enterViewBookListMode() {
//        Condition:
//          Factory New: 1
//          Squaky clean: 1
//
    println("Book List:")
    for ((i, book) in books.withIndex()){
        println("${i + 1}. ${book.title}, Pages: ${book.numberOfPages.format()}, Price: ${book.priceInCents.formatCurrency(
            currency
        )}, Condition: ${book.condition}")
    }
    println()
    val totalPriceInCents = books.sumOf { it.priceInCents }
    val totalNumberOfPages = books.sumOf { it.numberOfPages }
    println("Total Price: ${totalPriceInCents.formatCurrency(currency)}")
    println("Total Number of Pages: ${totalNumberOfPages.format()}")
    println()
    println("Condition:")
    for(condition in books.map { it.condition }.distinct()){
        val count = books.filter { it.condition == condition }.size
        println("  ${condition}: $count")
    }
    println()
    println("Press any key to go back to the menu:")
    readln()
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
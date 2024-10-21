import kotlin.random.Random

/**
 * ------------------------------------------------------------------------
 * Mancala Rip-Off
 * Level 2 programming project
 *
 * by Jasper Davidson
 *
 *
 *
 *
 * ------------------------------------------------------------------------
 */


/**
 * Program entry point
 */
fun main() {
    menu()

    // initBoard(10, 3) // Menu entry point for game
}

fun menu(){
    println("Welcome to Old Gold")
    println("")
    while (true){
        println("Options:")
        println("[1]. Play")
        println("[2]. Exit")
        print("Select: ")
        val option = readln()
        when(option){
            "1" -> {
                players()
                println()
                break
            }
            "2" -> break
            else -> {
                println("Invalid Option")
                println()
            }
        }
    }
}

fun players(){
    println()
    var numPlayers: Int
    val playersList = arrayListOf<String>()
    while (true) {
        while (true) {
            print("How many people are playing?: ")
            numPlayers = readln().toInt()
            if (numPlayers <=1){
                println("Invalid Number of Players, please try again")
            }
            else{
                break
            }
        }
        println()
        print("Are you sure? y/n: ")
        if (readln().lowercase() == "y") {
            println()
            break
        }
    }
    while (true) {
        repeat(numPlayers) { i ->
            print("What is player ${i + 1} name: ") // +1 required for Zero Index
            playersList.add(i, readln().toString())
            println()
        }
    }
}

fun initBoard(bSize: Int, bCoin: Int){  // Function takes in board size and number of coins
    val board = mutableListOf<String>()
    println(bSize-(bSize/bCoin))
    for(i in 1 .. bSize-(bSize/bCoin)){
        board.add(0, "[_]")
    }
    println(bSize/bCoin)
    for(i in 1..<(bSize/bCoin)){
        board.add(0, "[C]")
    }
    board.add(0, "[G]")
    board.shuffle()
    println(board.joinToString(""))
}

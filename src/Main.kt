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

// Global Variables
val SPACE = "[ ]"


fun main() {
    val grid = initBoard(10,2) // Stores game board
    while (true) {
        displayBoard(grid)
        if (playerMove(grid) == "WIN") break
    }

    println("Congrats Player {Insert Name Here}, you have won") // Need to do dynamic player count
}

fun initBoard(bSize: Int, bCoin: Int): MutableList<String>{  // Function takes in board size and number of coins
    val board = mutableListOf<String>()
    // println(bSize-(bSize/bCoin)) This was used for debug purposes
    for(i in 1 .. bSize-(bSize/bCoin)){
        board.add(SPACE)
    }
    // println(bSize/bCoin)
    for(i in 1..<(bSize/bCoin)){
        board.add("[C]")
    }
    board.add("[G]")
    board.shuffle()
    return board
}

fun displayBoard(board: MutableList<String>){
    val gameBoard = board
    println(gameBoard.joinToString(""))
    for (i in 0 .. board.size-1){
      print(" ${i+1} ")
    }
    println()
}

fun playerMove(board: MutableList<String>): String {
        // Variable decleration for local use inside of function
        var s1: Int
        var s2: Int

        println("Player One") // Need to make this dynamic
        println()
        while(true){
            print("Which coin to move/remove: ")
            s1 = readln().toInt()-1

            if(board[s1] == "[C]" || board[s1] == "[G]"){  // -1 added to deal with zero error
                break
            }
            println("Invalid Move, Try Again!")
        }

        // Are we removing a coin?
        if(s1 == 0) {
            // Yes, so check if it's gold
            if(board[0] == "[G]") {
                // It is, so we're done
                return "WIN"
            }
            // Otherwise, just remove it
            board[0] = SPACE
        }
        else {
            // No, so we need to find out where to move iot to
            while (true) {
                println()
                print("Move it to where: ")
                s2 = readln().toInt() - 1

                if (board[s2] == SPACE) {
                    var coinCount = 0
                    for (i in s1 - 1 downTo s2) {
                        if (board[i] != SPACE) {
                            coinCount++
                        }
                    }
                    if (coinCount == 0) {
                        break
                    }
                }
                println("Invalid Move, Try Again!")
            }
            board[s2] = board[s1]
            board[s1] = SPACE
        }
    return "Continue"
}


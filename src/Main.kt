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
    game(initBoard(10, 2))
}

fun initBoard(bSize: Int, bCoin: Int): MutableList<String>{  // Function takes in board size and number of coins
    val board = mutableListOf<String>()
    // println(bSize-(bSize/bCoin)) This was used for debug purposes
    for(i in 1 .. bSize-(bSize/bCoin)){
        board.add("[_]")
    }
    // println(bSize/bCoin)
    for(i in 1..<(bSize/bCoin)){
        board.add("[C]")
    }
    board.add("[G]")
    board.shuffle()
    return board
}

// This function is the Main Gameloop
fun game(board: MutableList<String>){
    while (true){
        // Variable decleration for local use inside of function
        var s1: Int
        var s2: Int



        println("Player One") // Need to make this dynamic
        println(board.joinToString(""))
        println()
        while(true){
            print("Which coin to move: ")
            s1 = readln().toInt()-1

            if(board[s1] == "[C]" || board[s1] == "[G]"){  // -1 added to deal with zero error
                break
            }
            println(board[s1])
            println("Invalid Move, Try Again!")
        }

        while(true) {
            println()
            print("Move it to where: ")
            s2 = readln().toInt()-1

            if (board[s2] == "[_]") { // -1 added to deal with zero error
                var coinCount = 0
                for (i in s1-1 downTo s2){
                    if (board[i] != "[_]"){
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
        board[s1] = "[_]"


    }

}


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
    return board
}

// This function is the Main Gameloop
fun game(board: MutableList<String>){
    while (true){
        // Variable decleration for local use inside of function
        var s1: Int
        var s2: Int

        var count: Int

        println("Player One") // Need to make this dynamic
        println(board.joinToString(""))
        println()
        while(true){
            print("Slot 1: ")
            s1 = readln().toInt()

            if(board[s1-1] == "[C]" || board[s1-1] == "[G]"){  // -1 added to deal with zero error
                break
            }
            println(board[s1])
            println("Invalid Move, Try Again!")
        }

        while(true) {
            println()
            print("Slot 2: ")
            s2 = readln().toInt()

            if (board[s2-1] == "[C]" || board[s2-1] == "[G]") { // -1 added to deal with zero error
                break
            }
            println(board[s2])
            println("Invalid Move, Try Again!")
        }

        for (i in s1-1 downTo s2-1){
            if (board[i] == "[_]"){
                count +=1
            }
            else{
                print("Invalid Move, Try Again!")
                break
            }
        }

    }

}


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
    println(board.joinToString(""))
    return board
}

fun game(board: MutableList<String>){
    println(board.joinToString(""))

    println("Coin to move?: ")
    val c1 = readln()
}


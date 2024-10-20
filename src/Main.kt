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
    initBoard() // Menu entry point for game
}

fun menu(){

}

fun initBoard(){
    var response: String? = null
    while (true) {
        print("Board Size: ")
        response = readlnOrNull()
        if (!response.isNullOrEmpty()) {
            break
        }
    }
    val bLength = response!!.toInt()
    val coins = bLength/3
    val gBoard = mutableListOf<String>()
    for (i in 0..<bLength) {
        gBoard.add(i, "[O]")

    }
    for( i in 0 .. coins){
        val j = (0..gBoard.size).random()
        gBoard.replace(j, "[C]")
    }
    println(gBoard.joinToString(""))
}

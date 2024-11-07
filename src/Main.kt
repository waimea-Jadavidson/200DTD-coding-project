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
val GOLD = "[G]"
val COIN = "[C]"


fun main() {
    val grid = initBoard(10,2) // Stores game board
    var round = 0
    println("WELCOME TO MANCALA RIP-OFF [2 or More Player Game!!]")
    println()
    val players = playerNames()
    while (true) {
        // displays the generated code
        displayBoard(grid)
        if (playerMove(grid, players, round) == "WIN") break // checks win condition, else adds 1 to round counter
        round ++
        if(round == players.size){
            round = 0
            // (Above) Resets round counter once == to num of players so the game continues on
        }
    }

    println("Congrats, you have won")
}

fun initBoard(bSize: Int, bCoin: Int): MutableList<String>{  // Function takes in board size and number of coins
    val board = mutableListOf<String>()
    // Generates the board depending on the size and the coin amount
    for(i in 1 .. bSize-(bSize/bCoin)){
        board.add(SPACE)
    }
    for(i in 1..<(bSize/bCoin)){
        board.add(COIN)
    }
    // Adds gold coin in after the board has been generated
    board.add(GOLD)
    board.shuffle()
    // Loop below will make sure game is valid and gold coin not in num 1 slot
    while(true){
        if (board[0] == GOLD){
            board.shuffle()
        }else{
            break
        }
    }

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

fun playerNames(): MutableList<String>{
    val players = mutableListOf<String>()
    val numOfPlayers: Int
    while (true) {
        print("Number of Players: ")
        // Checks for Number of players, make sures its and Int otherwise converts to null
        val playerCount = readln()
        val test = playerCount.toIntOrNull()
        if(test == null || test <2){
            println("Please try again: ")
        }else{
            numOfPlayers = test
            break
        }
    }
    repeat(numOfPlayers){ i ->
        while (true) {
            print("Player ${i + 1}: ")
            val name = readln()
            if (name.isNotBlank()){ // Checks to make sure player inputs a name
                players.add(name) // Adds player name to list
                break
            }
            else{
                println("Empty is not a valid name, please try again")
            }
        }
    }
    return players
}

fun moveChecker(board: MutableList<String>): Int{
    // Checks if player move is a valid input
    var slot:String
    while (true) {
        slot = readln()
        val test = slot.toIntOrNull()
        if(test != null && test < board.size){
            break
        }else{
            print("Please Try Again!: ")
        }
    }
    return slot.toInt()-1
}

fun playerMove(board: MutableList<String>, player: MutableList<String>, round: Int): String {
        // Variable decleration for local use inside of function

        var s1:Int
        var s2:Int

        println("Player ${player[round]}") // Shows player name for turn
        println()
        while(true){
            print("Which coin to move/remove: ")
            s1 = moveChecker(board)

            if(board[s1] == COIN || board[s1] == GOLD){ // Checks if slot 1 is removable
                    break
            }
            println("Invalid Move, Try Again!")
        }

        // Are we removing a coin?
        if(s1 == 0) {
            // Yes, so check if it's gold
            if(board[0] == GOLD) {
                // It is, so we're done
                return "WIN"
            }
            // Otherwise, just remove it
            board[0] = SPACE
        }
        else {
            // No, so we need to find out where to move it to
            while (true) {
                println()
                print("Move it to where: ")
                s2 = moveChecker(board)

                if (board[s2] == SPACE && s2 < s1) {
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


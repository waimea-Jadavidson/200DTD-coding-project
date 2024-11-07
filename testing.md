# Test Plan and Evidence / Results of Testing

## Game Description

The project involves the programming of a two-player game.

This project is about the programming of the two or more player game 'Old Gold'. 
The game is played on a one line grid with coins randomly placed across it. 
Players take turns moving a coin any amount of spaces to the left without jumping over other coins. 
If a coin/gold coin is in the first slot it can be removed from the board. 
The player to remove the gold coin from the board is the winner.

### Game Features and Rules

The game has the following features and/or rules:

- 1x10 Board with randomly distributed coins/gold

Players take turns moving coins leftwards within the rules of the game (see below).

- Any coin/gold can be moved left, but not backwards.
- The coin/gold may not jump any other coins.
- The coin/gold can only move left till it hits another coin/gold.
- A coin may be removed if in slot 1, this counts as a turn.

To win:
- The player that removes the gold coin from slot 1 win.

---

## Test Plan

The following game features / functionality and player actions will need to be tested:

Initialisation:
- Number of players
- Player Names

Game Loop:
- Player Name shown, player turn is accurate e.g player 1 is round 1, player 2 is round 2 etc
- Moving of coins/gold
- Removing of coin or gold from first slot

Win Condition:
- Player who removes gold coin wins 
- Winning player name is shown

The following tests will be run against the completed game. The tests should result in the expected outcomes shown.


### Number of players

The number of players can be entered without breaking the game

#### Test Data / Actions to Use

1) Player enters a number >= 2
2) Player enters blank statement
3) Player enters a number < 2

#### Expected Outcome

1) Game continues
2) Game throws back a please try again but does not break
3) Game throws back a please try again but does not break


### Player Names

Player names are entered without break game

#### Test Data / Actions to Use

1) Player name properly e.g "Joe" or "Blogs"
2) Player enters blank statement
3) Player enters a char e.g A or B (Edge Case)

#### Expected Outcome

1) Game continues
2) Game throws back a please try again but does not break
3) Game continues



### Player Name and Round Displayed Accurately

The player name and is shown correctly according to the round at the start

#### Test Data / Actions to Use

1) Game continues from player naming to main gameplay without breaking

#### Expected Outcome

1) Name is shown with prefix of Player and was entered as player 1 etc
2) Name is shown with prefix of Player for round two
3) Game loops properly showing correct names for the round


### Moving of Coins/Gold

Players can move Coins/Gold, game checks for invalid moves and handles correctly if invalid move

#### Test Data / Actions to Use

1) Removing of a Coin/Gold in slot 1
2) Valid Coin Move
   - Coin is not moving backwards
   - Coin is not jumping another coin
   - Coin is not moving 0 slots
   - Coin is only moving to an empty slot
   - Coin slot is inside the parameters of the board

#### Expected Outcome

1) Game checks if valid, if so removes coin
   2) If slot 1 is gold, then main loop is broken and win statement is handled correctly
2) Game continues if valid. If invalid, then throws an invalid move


### Win Condition

If player makes a winning move, the game handles correctly without errors

#### Test Data / Actions to use

1) Player makes winning move, else game loop continues

#### Expected Outcome

1) Game finishes and win message is displayed with correct player name

---


## Evidence / Results of Testing

### Number of Players

[NumPlayers.mp4](media%2FNumPlayers.mp4)

Expected outcomes were shown as expected


### Player Names

[playerNames.mp4](media%2FplayerNames.mp4)

Expected outcomes were shown as expected


### Player Names and Round Looping

[roundLooping.mp4](media%2FroundLooping.mp4)

Expected outcomes were shown as expected


### Removing and Moving of coins/gold

[movingCoins.mp4](media%2FmovingCoins.mp4)

Through out demonstration, board is never shown to have gold coin in slot 1 making a game invalid.
This was added purposely.

### Win Statement


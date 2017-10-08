
# Shiritori framework
##Construction
! [alt text] (http://ganbaruyo.net/images/structure.png "Logo Title Text 1")
##Description

1. Create a shiritori game using Java socket communication

2. Class description

    2.1 Shitori: entrance class of shiritori game. Creation of referee class, waiting for player
Start the game, etc.

    2.2 Referee: Referee class. Give handouts between players, make a game end decision, etc.
.

    2.3 PlayerThread: It is generated from the referee class and receives and hands a word from the corresponding player.

    2.4 Player: Player class. In order to implement the strategy (AI) operating in the framework of this game, we need to inherit this class.

    2.5 WordReceiver, WordSender: Generated from the Player class, each receiving the opponent's word from the referee, sending the word the player says to the referee, etc.

## Execution
### Build
`` `
    ./remove.sh
    ./build.sh
`` `
### Execution
`` `
    ./run.sh ./ai.sh ./ai.sh shiritori internet tail grep less telnet sed
`` `
### Option Execution of AI Program
(You will read the word dictionary from the dict.txt file with the -f option.)
`` `
    ./ai.sh -f
`` `

## Remarks
Although it does not violate the rules of the game, there are still cases where the result as expected does not come out

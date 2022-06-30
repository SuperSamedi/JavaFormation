const boardHTML = document.getElementById("board");
const messageHTML = document.getElementById("message")

const board = [];
let firstPlayerTurn = true;
let won = false;


for (let i = 0; i < 9; i++) {
    const newTile = document.createElement("input");
    newTile.type = "button";
    newTile.classList.add("tile");
    newTile.id = i;
    newTile.value = "";
    newTile.addEventListener("click", onTileClick);
    board.push(newTile);
    boardHTML.appendChild(newTile);
}

messageHTML.innerText = "It's player 1's turn...";

function onTileClick(){
    if(this.value || won){
        return;
    }

    if (firstPlayerTurn) {
        this.value = "X";
    }
    else{
        this.value = "O"
    }

    checkForGameOver();
    if (won) {
        return;
    }

    firstPlayerTurn = !firstPlayerTurn;
    if (firstPlayerTurn) {
        messageHTML.innerText = "It's player 1's turn...";
    }
    else{
        messageHTML.innerText = "It's player 2's turn...";
    }
}

function checkForGameOver(){
    //Diagonal lines
    checkLine(0, 4, 8);
    checkLine(2, 4, 6);
    //Vertical lines
    checkLine(0, 3, 6);
    checkLine(1, 4, 7);
    checkLine(2, 5, 8);
    //Horizontal lines
    checkLine(0, 1, 2);
    checkLine(3, 4, 5);
    checkLine(6, 7, 8);
}

function checkLine(x, y, z){
    console.log(`Checking line ${x}-${y}-${z}`)
    let evalValue = "";
    let sameValueSequence = 0;
    
    for (let i = x; i < z+1; i += (z-y)) {
        //If empty tile we stop checking this line
        if (!board[i].value) {
            return;
        }
        
        //If first tile of the line to be evaluated we store the value of that tile.
        if (!evalValue) {
            evalValue = board[i].value;
            sameValueSequence++;
            console.log("Same value in sequence: " + sameValueSequence)
            continue;
        }

        //Check if the value of the tile equals the previous tiles value.
        if (board[i].value === evalValue) {
            sameValueSequence++;
            console.log("Same value in sequence: " + sameValueSequence)
        }
    }
    //Check if we got a sequence of 3 same value in that line
    if(sameValueSequence === 3){
        win(x, y, z);
    }
}

function win(x, y, z){
    won = true;
    const tileX = document.getElementById(x);
    const tileY = document.getElementById(y);
    const tileZ = document.getElementById(z);

    tileX.classList.add("winningTile");
    tileY.classList.add("winningTile");
    tileZ.classList.add("winningTile");
    messageHTML.classList.add("winMessage");

    if (firstPlayerTurn) {
        messageHTML.innerText = "Player 1 won!";
    }
    else{
        messageHTML.innerText = "Player 2 won!";
    }
}
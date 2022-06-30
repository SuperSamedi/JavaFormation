class Card {
    constructor(cardType) {
        this.cardType = cardType;
    }
}

const boardHTML = document.getElementById("board");
const victoryHTML = document.getElementById("victory");
const cardTypes = ["plains", "island", "swamp", "mountain", "forest"];
const cardsPerType = 2;
let cards = [];
let numberOfClicks = 0;
let cardsToCheck = [];
let resetCardsToCheck = false;


cards = generateCards();
shuffle(cards);
setupBoard();

const allCardsHTML = document.querySelectorAll(".card");


function onCardClick() {
    // If already up or we reached the number of clicks maximum we cancel the function.
    if(this.value === "up" || numberOfClicks >= cardsPerType){
        return;
    }
    //Otherwise we turn the card face up, add it to the cards to evaluate the match.
    numberOfClicks++;
    this.value = "up";
    cardsToCheck.push(this);
    //If we turned at least 2 cards face up, we check if they match.
    if (cardsToCheck.length > 1) {
        verifyMatch();
    }
}

function verifyMatch(){
    //We take the first card turned up and we store it's type.
    const typeOfFirstCard = cardsToCheck[0].classList.value;
    for (let i = 0; i < cardsToCheck.length; i++) {
        //If at least one of the cards turned up does not match the type of the first one,
        //we turned back the cards face down after a small timer.
        if (cardsToCheck[i].classList.value != typeOfFirstCard) {
            setTimeout(turnBack, 750);
            return;
        }
    }
    // If they all match we mark them as found.
    if (cardsToCheck.length === cardsPerType) {
        markAsFound();
    }
}

function turnBack(){
    for (const card of cardsToCheck) {
        card.value = "down";
    }
    //Reset
    cardsToCheck = [];
    numberOfClicks = 0;
}

function markAsFound() {
    for (const card of cardsToCheck) {
        card.classList.add("found");
    }
    // Reset
    cardsToCheck = [];
    numberOfClicks = 0;
    checkVictory();
}

function checkVictory(){
    for (const card of allCardsHTML) {
        // If at least one of the card was not marked as found, we stop checking.
        if (!card.classList.contains("found")) {
            return;
        }
    }
    // If we get here, it means all cards were marked as found.
    victoryHTML.className = "won";
}

//For each card type we generate as many cards as needed by the difficulty level (cardsPerType)
function generateCards() {
    const cardArray = [];
    for (let i = 0; i < cardTypes.length; i++) {
        for (let j = 0; j < cardsPerType; j++) {
            const newCard = new Card(cardTypes[i]);
            cardArray.push(newCard);
        }
    }
    return cardArray;
}

//We generate html buttons for each generated cards.
function setupBoard(){
    for (const card of cards) {
        const newCardHTML = document.createElement("input");
        newCardHTML.type = "button";
        newCardHTML.classList.add("card");
        newCardHTML.classList.add(card.cardType);
        newCardHTML.value = "down";
        newCardHTML.addEventListener("click", onCardClick);
        boardHTML.appendChild(newCardHTML);
    }
}

function shuffle(array) {
    let currentIndex = array.length;
    let randomIndex;
    // While there remain elements to shuffle.
    while (currentIndex != 0) {
        // Pick a remaining element.
        randomIndex = Math.floor(Math.random() * currentIndex);
        currentIndex--;

        // And swap it with the current element.
        [array[currentIndex], array[randomIndex]] = [array[randomIndex], array[currentIndex]];
    }
    return array;
}

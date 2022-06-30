const itemListHTML = document.getElementById("itemList")
const winnerHTML = document.getElementById("winner")

const nbrItems = parseInt(prompt("How may items to pick from?"))
const items = []

let item
for (let i = 0; i < nbrItems; i++) {
    item = prompt("What is the item's name?")
    items.push(item)

    const itemHTML = document.createElement("li")
    itemHTML.innerText = item
    itemListHTML.appendChild(itemHTML)
}

const randomIndex = Math.floor(Math.random() * nbrItems)
winnerHTML.innerText = "Winner: " + items[randomIndex]
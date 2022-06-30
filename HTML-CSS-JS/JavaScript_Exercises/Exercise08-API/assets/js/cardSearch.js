// Scryfall API's adress
const scry = "https://api.scryfall.com"

const cardDisplayHTML = document.querySelector(".cards-display")
const searchButtonHTML = document.querySelector("#search-bar input[type=button]")
const searchBarHTML = document.querySelector("#search-bar input[type=text]")


searchButtonHTML.addEventListener("click", research)

// Event to trigger research when enter is pressed.
searchBarHTML.addEventListener("keyup", (e) => {
    if (e.code === "Enter") {
        research();
    }
})

function research() {
    fetch(scry + "/cards/search?q=" + encodeURIComponent(searchBarHTML.value)) // Percent encoding
        .then(response => response.json())
        .then(data => {
            console.log(data)
            displayData(data)
        })
        .catch(e => {
            console.log(e)
            cardDisplayHTML.innerHTML = "An unexpected error occured."
        })
}

function displayData(data) {
    cardDisplayHTML.innerHTML = "";
    for (let i = 0; i < data.data.length; i++) {
        if (data.data[i].image_uris) {
            const newCardHTML = document.createElement("img");
            newCardHTML.classList.add("card")
            if (data.data[i].image_uris.large) {
                newCardHTML.setAttribute("src", data.data[i].image_uris.large)
            }
            else {
                newCardHTML.setAttribute("src", data.data[i].image_uris.normal)
            }
            cardDisplayHTML.appendChild(newCardHTML)
        }
    }
    
    console.log(data.data[0])
}
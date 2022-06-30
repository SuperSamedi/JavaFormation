const scry = "https://api.scryfall.com"

const getRandomButtonHTML = document.getElementById("get-random")
const cardDisplayHTML = document.getElementById("random-card")

const searchButtonHTML = document.getElementById("search-button")

getRandomButtonHTML.addEventListener("click", () => {
    fetch(scry + "/cards/random")
        .then(response => response.json())
        .then(data => {
            console.log(data)
            cardDisplayHTML.setAttribute("src", data.image_uris.large)
        })
        .catch(e => {
            console.log("An unexpected error occured.")
        })
})

searchButtonHTML.addEventListener("click", () => {
    // fetch(scry + "/cards/search?set=clb")
    //     .then(response => response.json())
    //     .then(data => {
    //         console.log(data)
    //     })
    //     .catch(e => {
    //         console.log("An unexpected error occured.")
    //     })
})
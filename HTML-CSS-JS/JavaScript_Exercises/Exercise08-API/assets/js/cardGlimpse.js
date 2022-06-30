// Scryfall API's adress
const scry = "https://api.scryfall.com"

const glimpseSpansHTML = document.querySelectorAll(".glimpse")
const cardPreviewHTML = document.querySelector("#previewDisplay img")
console.log(cardPreviewHTML)
// Generate search string from the glimpse spans.
let searchString = ""
glimpseSpansHTML.forEach(element => {
    searchString += "\"" + element.id + "\" or " 
});

let previewSearchData 

// Fetch the search result.
fetch(scry + "/cards/search?q=" + encodeURIComponent(searchString))
    .then(response => response.json())
    .then(data => previewSearchData = data)
    .then(() => console.log(previewSearchData))
    .catch(e => {
        console.log(e)
        cardDisplayHTML.innerHTML = "An unexpected error occured."
    })

// We tell glimpse spans to listen to hover/focus
glimpseSpansHTML.forEach(element => {
    element.addEventListener("mouseover", displaycardPreview);
    // element.innerHTML = "Coucou"
});

// When span is hovered/focused
function displaycardPreview() {
    for (let i = 0; i < previewSearchData.data.length; i++) {
        if (previewSearchData.data[i].name === this.id) {
            console.log("Match!")
            if (previewSearchData.data[i].image_uris.large) {
                console.log("Large image present")
                cardPreviewHTML.setAttribute("src", previewSearchData.data[i].image_uris.large)
            }
            else if (previewSearchData.data[i].image_uris.normal) {
                console.log("Normal image present")
                cardPreviewHTML.setAttribute("src", previewSearchData.data[i].image_uris.normal)
            }
        }
    }
}
// searchButtonHTML.addEventListener("click", research)

// // Event to trigger research when enter is pressed.
// searchBarHTML.addEventListener("keyup", (e) => {
//     if (e.code === "Enter") {
//         research();
//     }
// })

// function research() {
//     fetch(scry + "/cards/search?q=" + encodeURIComponent(searchBarHTML.value)) // Percent encoding
//         .then(response => response.json())
//         .then(data => {
//             console.log(data)
//             displayData(data)
//         })
//         .catch(e => {
//             console.log(e)
//             cardDisplayHTML.innerHTML = "An unexpected error occured."
//         })
// }

// function displayData(data) {
//     cardDisplayHTML.innerHTML = "";
//     for (let i = 0; i < data.data.length; i++) {
//         if (data.data[i].image_uris) {
//             const newCardHTML = document.createElement("img");
//             newCardHTML.classList.add("card")
//             if (data.data[i].image_uris.large) {
//                 newCardHTML.setAttribute("src", data.data[i].image_uris.large)
//             }
//             else {
//                 newCardHTML.setAttribute("src", data.data[i].image_uris.normal)
//             }
//             cardDisplayHTML.appendChild(newCardHTML)
//         }
//     }
    
//     console.log(data.data[0])
//}
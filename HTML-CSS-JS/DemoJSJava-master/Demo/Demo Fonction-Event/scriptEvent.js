const inputHTML = document.querySelector("input")
const buttonHTML = document.querySelector("button")
const h2HTML = document.querySelector("h2")
const submitHTML = document.getElementById("submit")

// Evenement prend le type d'evenemtn en paramètre ainsi
// que la fonction appelé au moment du clique
buttonHTML.addEventListener("click", () => {
    const valeurInput = inputHTML.value
    h2HTML.innerText = valeurInput
    console.log(valeurInput)
})

// Evenement effectuer à chaque changement dans l'input
inputHTML.addEventListener("input", (event) => {
    console.log(event.target.value)
    h2HTML.innerText = event.target.value
})

// Récupérer la touche sur laquelle l'utilisateur a appuié
inputHTML.addEventListener("keyup", (e) => {
    console.log(e.key)
    if (e.key === "Enter") {
        console.log("Bonjour")
    }
})

// Empêche les évenements par défaut
submitHTML.addEventListener("click", (e) => {
    e.preventDefault()
})


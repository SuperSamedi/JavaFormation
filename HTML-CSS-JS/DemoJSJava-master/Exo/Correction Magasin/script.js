const tabBodyHTML = document.querySelector("tbody")
const prixTotalHTML = document.getElementById("prix-total")

const nameProduits = ["Pomme", "Poire", "Cerise"]
const prixProduits = [0.3, 0.5, 0.2]

let prixTotal = 0

let promo = true

for (let i = 0; i < nameProduits.length; i++) {

    const quantite = parseInt(prompt(`Combien de ${nameProduits[i]} voulez-vous ?`))

    if (quantite) {
        const ligneHTML = document.createElement("tr")

        const nomHTML = document.createElement("td")
        nomHTML.innerText = nameProduits[i]

        const quantiteHTML = document.createElement("td")
        quantiteHTML.innerText = quantite

        const prixHTML = document.createElement("td")
        prixHTML.innerText = quantite * prixProduits[i]

        prixTotal = prixTotal + (quantite * prixProduits[i])

        ligneHTML.appendChild(nomHTML)
        ligneHTML.appendChild(quantiteHTML)
        ligneHTML.appendChild(prixHTML)

        tabBodyHTML.appendChild(ligneHTML)
    }
    else {
        promo = false
    }

}

if (promo) {
    prixTotal = prixTotal * 0.9
    prixTotalHTML.classList.add("red")
}

prixTotalHTML.innerText = `Prix total : ${prixTotal}`

// Utilisation d'un template

// const template = `<div><h1>__name__</h1>
// <p>__description__</p></div>`

// const harryPotter = template.replace("__name__", "Harry Potter")
//     .replace("__description__", "Description d'Harry Potter")
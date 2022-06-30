const listJoueurHTML = document.querySelector("ul")
const gagnantHTML = document.getElementById("gagnant")

const nbrJoueur = parseInt(prompt("Combien de joueur y a-t-il ?"))

const nameJoueur = []

let nom
for (let i = 0; i < nbrJoueur; i++) {
    nom = prompt("Quel est le nom du joueur " + (i+1))
    nameJoueur.push(nom)

    const nameHTML = document.createElement("li")
    nameHTML.innerText = nom

    listJoueurHTML.appendChild(nameHTML)
}

const randomIndice = Math.floor(Math.random()*nbrJoueur)

gagnantHTML.innerText = "Gagnant : " + nameJoueur[randomIndice]


// Structure conditionnelle

// If else

const age = 18

if (age >= 18) {
    console.log("Bonjour")
}
// Type of : idem que instance of (retourne le type)
// === plutôt que == 
else if (typeof(age) === "number") {
    console.log("Vous n'êtes pas assez agé")
}
else {
    console.log("Erreur")
}

// Switch
const a = 42
switch(true) {
    case a >= 42:
        console.log("La variable vaut 42")
        break
    case a < 42:
        console.log("La variable vaut 43")
        break
    default:
        console.log("Default")
        break
}

const b = 0
const c = ""

// "Faux" booléen
if (b) {
    console.log("Je passe dans le if")
}

if (c) {
    console.log("Je passe dans le if")
}

// Structure itérative

// While
let i = 0
while (i < 10) {
    console.log(i)
    i++
}

console.log(i)

// For i
for (let j = 0; j < 10; j++) {
    console.log(j)
}

// console.log(j) lance une erreur

// Boucle for of (équivalent for each)
const tab = ["Salameche", "Bulbizarre", "Carapuce"]
for(const pokemon of tab) {
    console.log(pokemon)
}

// Boucle for in (Ancienne boucle)
for(const indice in tab) {
    console.log(indice)
}

// La boucle for in permet d'itérer sur les attribut d'un objet
const salameche = {
    name: "Salameche",
    type: "Feu",
    level: 12
}

console.log(salameche.type)
salameche.type = "Eau"
console.log(salameche["type"])

for (const at in salameche) {
    console.log(salameche[at])
}
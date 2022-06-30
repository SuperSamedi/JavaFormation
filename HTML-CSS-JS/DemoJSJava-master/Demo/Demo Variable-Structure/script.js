// Pour afficher dans la console
console.log("Bonjour le monde");

// Pas d'erreur (car c'est un var)
console.log(myOldVariable)

// Lance une erreur 
// console.log(myConstantVariable)

// Pour déclarer une constante
const myConstantVariable = 5.115

// Pou déclarer une variable
let myVariable = 5

// (Ancienne notation)
var myOldVariable = 5

// Type Nombre
let a = 4.12
let b = 12

// Pour récupérer une valeur d'un utilisateur
// const input = parseInt(window.prompt("Entrez une valeur"))
// console.log(input)

// Pour confirmer
// const confirm = window.confirm("Ok")

// Pour faire une alerte
// alert("Ceci est une alerte")

// Type Chaine de caractère
const salameche = "Salameche" + " Pokemon"

const sacha = `Sacha a capturé un ${salameche}`

console.log(sacha)

// Type booléen

const majeur = true
const mineur = false

// Pas de valeur
const a1 = undefined
const a2 = null
const a3 = NaN

// Opérateur
const x = a + b ** 5 // ** = exposant

// Même opérateur qu'en java

// Tableau
const tabVide = []
const tab = ["Salameche", "Bulbizarre", "Carapuce"]
console.log(tab[0])
tab[2] = "Kaiminus"
console.log(tab.length)
tab.push("Hericendre")
tab.push("Germignon")
console.log(tab)

// Fonction des tableaux
// Enleve le dernier élément
tab.pop()

// Coupe le tableau
const tabSlice = tab.slice(1, 2)

// Supprime un certian nombre d'élément à partir d'un indice (vous pouvez ussi remplacer)
tab.splice(1, 2, "Vilépierre")

// Ajoute un tableau au tableau
const tabConcat = tab.concat(["Ronflex", "Mewtwo"])

console.log(tabConcat)

// Attention : ajoute un tableau à la dernière position (devient multidimensionnel)
tabConcat.push(["Ortide", "Mystherbe"])


// Reverse un tableau
tab.reverse()

// Ordonner tableau (par ordre alphabétique)
tab.sort()

const tabNombre = [5, 1, 2, 8, 4]
tabNombre.sort(function(a, b) {
    return a - b
})

console.log(tabConcat)
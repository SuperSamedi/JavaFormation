// Méthode 1
function multiplierPar2(x) {
    return x*2
}
console.log(multiplierPar2(5))

// Méthode 2
const multiplierPar3 = function(x) {
    return x * 3
}
console.log(multiplierPar3(5))

// Méthode 3
const multiplierPar4 = (x) => {
    return x * 4
}
console.log(multiplierPar4(5))

// Méthode 4
const multiplierPar5 = x => x*5
console.log(multiplierPar5(5))

// Parmètre REST

function afficherNom(messageDebut, ...noms) {
    console.log(messageDebut)
    console.log("-------------------")
    for (const nom of noms) {
        console.log(nom)
    }
}
afficherNom("Bienvenue", "Salameche", "Bulbizarre", "Carapuce", 45)

// Fonction de fontion

function faireCalcul(x, cb) {
    console.log("---------------")
    if (typeof(cb) === "function") {
        const resultat = cb(x)
        console.log("Le résultat est de " + resultat)
    }
    console.log("----------------")
}
faireCalcul(5, multiplierPar5)

faireCalcul(10, (x) => {
    return x * x
})

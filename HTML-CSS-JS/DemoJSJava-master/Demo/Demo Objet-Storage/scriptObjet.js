// Objet

const salameche = {
    name: "Salameche",
    type: "Feu",
    level: 12,
    crie() {
        console.log(this.name + " crie")
    }
}

salameche.crie()

// Classe (voir classScript.js)

const bulbizarre = new Pokemon("Bulbizarre", "Plante", 12)
bulbizarre.crie()



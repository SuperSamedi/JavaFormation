class Pokemon {
    #name = 0 // Pour mettre un valeur par défaut et un champ privé
    constructor(name, type, level) {
        this.#name = name
        this.type = type
        this.level = level
    }

    crie() {
        console.log(this.#name + " crie")
    }

    get typeAndLevel() { // Getter
        return this.type + this.level
    }
}
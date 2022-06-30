const name = localStorage.getItem("name")

if (name) {
    console.log("Bonjour" + name)
}
else {
    const newName = prompt("Quel est votre nom ?")
    localStorage.setItem("name", newName)
}
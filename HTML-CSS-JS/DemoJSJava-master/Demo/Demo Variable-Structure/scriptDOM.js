// Récupérer un élément html via son ID
const h1HTMLbyId = document.getElementById("title")
h1HTMLbyId.innerText = "Mon nouveau titre"
h1HTMLbyId.innerHTML = "<p>Mon très nouveau titre</p>"

// Récupérer des éléments html via leur classe
const h1HTMLbyClass = document.getElementsByClassName("title")
h1HTMLbyClass[0].innerText = "Mon titre récup par la classe"

const h1HTMLbyTag = document.getElementsByTagName("h1")
h1HTMLbyTag[0].innerText = "Mon titre récupérer par Tag"

// Récupère le premier élément html qui correspond au selecteur css donné en paramètre
const h1RecupByQuerySelector = document.querySelector("body > h1")


// Récupère tous les éléments html qui correspondent au selecteur css
const allH1 = document.querySelectorAll("body > h1")

// Manipulation des classes
h1HTMLbyId.classList.add("red")
h1HTMLbyId.classList.remove("red")

// Manipulation attribut HTML
console.log(h1HTMLbyId.getAttribute("class"))
h1HTMLbyId.setAttribute("class", "title red")

// Création d'élément

const conteneurHTML = document.querySelector(".mon-contenu")

const newPHTML = document.createElement("p")
newPHTML.innerText = "Mon contenu"
newPHTML.classList.add("red")

conteneurHTML.appendChild(newPHTML)

// Récupération d'enfant

console.log(conteneurHTML.children)

console.log(document.querySelector("body").children)
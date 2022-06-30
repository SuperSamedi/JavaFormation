const compteurHTML = document.querySelector("span")
const incrValueHTML = document.querySelector("input")
const incrHTML = document.getElementById("incr")
const decrHTML = document.getElementById("decr")

incrHTML.addEventListener("click", () => {
    if (!isNaN(parseInt(incrValueHTML.value))) {
        compteurHTML.innerText = parseInt(compteurHTML.innerText) + parseInt(incrValueHTML.value)
    }
})

decrHTML.addEventListener("click", () => {
    if (!isNaN(parseInt(incrValueHTML.value))) {
        compteurHTML.innerText = compteurHTML.innerText - incrValueHTML.value
    }
})

incrValueHTML.addEventListener("input", () => {
    incrHTML.innerText = "+" + incrValueHTML.value
    decrHTML.innerText = "-" + incrValueHTML.value
})


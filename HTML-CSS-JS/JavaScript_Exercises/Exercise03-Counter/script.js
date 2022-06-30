const modifierHTML = document.getElementById("modifierValue");
const counterHTML = document.getElementById("counterValue");
const decrementButtonHTML = document.getElementById("decrementButton");
const incrementButtonHTML = document.getElementById("incrementButton");

modifierHTML.value = 1;
counterHTML.innerText = 0;

decrementButtonHTML.addEventListener("click", () => {
    if(!isNaN(parseInt(modifierHTML.value))){
        counterHTML.innerText = parseInt(counterHTML.innerText) - parseInt(modifierHTML.value);
    }
})

incrementButtonHTML.addEventListener("click", () => {
    if(!isNaN(parseInt(modifierHTML.value))){
        counterHTML.innerText = parseInt(counterHTML.innerText) + parseInt(modifierHTML.value);
    }
})

modifierHTML.addEventListener("input", () => {
    decrementButtonHTML.value = "-" + modifierHTML.value;
    incrementButtonHTML.value = "+" + modifierHTML.value;
})
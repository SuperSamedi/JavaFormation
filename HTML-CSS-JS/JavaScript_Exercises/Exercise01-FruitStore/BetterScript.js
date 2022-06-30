const apple = {
    name: "Apple",
    price: "0.22",
}

const pear = {
    name: "Pear",
    price: "0.36",
}

const cherry = {
    name: "Cherry",
    price: "0.05",
}

const products = [apple, pear, cherry]
const basket = []
let subTotal = 0
let total = 0

const productListHTML = document.getElementById("#productList")
const basketListHTML = document.getElementById("#basket")
const subTotalHTML = document.getElementById("#subTotalPrice")
const totalPriceHTML = document.getElementById("#totalPrice")


let rebateAvailable = true
for (const product of products) {
    //Populate the products list
    const newListElementHTML = document.createElement("li")
    newListElementHTML.innerText = `${product.name} : €${product.price}/u`
    productListHTML.appendChild(newListElementHTML)
    
    //Ask for customer choice and put wanted products into basket
    const amount = parseInt(window.prompt(`Add to basket : \n${product.name}...`))
    if(amount > 0){
        basket.push(product)

        //we add its total price to the sub-total and a line to the basket display
        const newListElementHTML = document.createElement("li")
        newListElementHTML.innerText = `${amount} x ${product.name} --- ${amount * product.price}€`
        basketListHTML.appendChild(newListElementHTML)
        subTotal += amount * product.price
    }
    else{
        //If customer does not buy one of the item the rebate is void.
        rebateAvailable = false
    }
}

//total = sub-total. We will modify it if rebate is applicable
total = subTotal

//If applicable : apply rebate and create an additional line which indicate the rebate
if(rebateAvailable){
    total -= total * 0.1 
    const newListElementHTML = document.createElement("li")
    newListElementHTML.innerText = "Rebate: 10%"
    basketListHTML.appendChild(newListElementHTML)
}

//Update sub-total and total display
subTotalHTML.innerText = `Sub-total: ${subTotal}€`
totalPriceHTML.innerText = `Total: ${total}€`
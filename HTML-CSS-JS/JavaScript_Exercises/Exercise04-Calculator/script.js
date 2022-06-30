const firstNumberHTML = document.getElementById("firstNumber")
const secondNumberHTML = document.getElementById("secondNumber")
const operatorHTML = document.getElementById("operator")
const resultHTML = document.getElementById("result")
const executeButtonHTML = document.getElementById("execute")

resultHTML.value = 0;

executeButtonHTML.addEventListener("click", () => {
    switch (operatorHTML.options[operatorHTML.selectedIndex].value) {
        case "+":
            resultHTML.value = parseFloat(firstNumberHTML.value) + parseFloat(secondNumberHTML.value);
            break;
        case "-":
            resultHTML.value = firstNumberHTML.value - secondNumberHTML.value;
            break;
        case "*":
            resultHTML.value = parseFloat(firstNumberHTML.value) * parseFloat(secondNumberHTML.value);
            break;
        case "/":
            if (secondNumberHTML.value != 0) {
                resultHTML.value = parseFloat(firstNumberHTML.value) / parseFloat(secondNumberHTML.value);
            }
            else {
                const everything = document.querySelectorAll("*");
                for (const elem of everything) {
                    elem.classList.add("blueScreen");
                }
                const title = document.querySelector("h1");
                title.innerText = "***** ERROR *****\n--- DIVISION BY ZERO ---\n Reality collapse is imminent! \n Goodbye world..."
            }
            break;
        case "%": 
            resultHTML.value = parseFloat(firstNumberHTML.value) % parseFloat(secondNumberHTML.value);
            break;
        default:
            break;
    }
})

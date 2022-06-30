const nb1HTML = document.getElementById('nb1')
const nb2HTML = document.getElementById('nb2')
const resultHTML = document.getElementById('result')
const operateurHTML = document.getElementById('operateur')
const submitHTML = document.getElementById('submit')

submitHTML.addEventListener('click', function () {
    switch(operateurHTML.value) {
        case '+':
            resultHTML.value = parseInt(nb1HTML.value) + parseInt(nb2HTML.value)
            break;
        case '-':
            resultHTML.value = parseInt(nb1HTML.value) - parseInt(nb2HTML.value)
            break;
        case '*':
            resultHTML.value = parseInt(nb1HTML.value) * parseInt(nb2HTML.value)
            break;
        case '/':
            resultHTML.value = parseInt(nb1HTML.value) / parseInt(nb2HTML.value)
            break;
    }
})
const dateHTML = document.querySelector("h1")
const dateTimeOutHTML = document.querySelector("h2")
setInterval(() => {
    const d = new Date()
    dateHTML.innerText = d.toLocaleTimeString()
}, 1000)

function getDate() {
    const d = new Date()
    dateTimeOutHTML.innerText = d.toLocaleTimeString()
    setTimeout(getDate, 1000)
}

getDate()


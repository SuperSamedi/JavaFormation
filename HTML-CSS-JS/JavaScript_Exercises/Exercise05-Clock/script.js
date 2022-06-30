const clockHTML = document.querySelector("h2")

setInterval(() => {
    const d = new Date();
    clockHTML.innerText = d.toLocaleTimeString();
}, 500)


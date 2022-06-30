const a = setTimeout(() => {
    console.log("Bonjour")
}, 2000)

console.log("Au revoir")

clearTimeout(a)

const b = setInterval(() => {
    console.log("Mon setInterval")
}, 2000)

clearInterval(b)
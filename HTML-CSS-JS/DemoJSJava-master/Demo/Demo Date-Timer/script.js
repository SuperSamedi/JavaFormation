const d = new Date() // Plusieurs plusieurs constructeurs possibles

console.log(d.getDate()) // Date du jour
console.log(d.getMonth()) // Attention : le mois commence à 0
console.log(d.getFullYear())
console.log(d.getDay()) // Jour de la semaine

console.log(d.toString()) // Toutes les infos

console.log(d.toDateString()) // Format de date avec des lettres

console.log(d.toLocaleDateString()) // Format local de date
console.log(d.toLocaleTimeString()) // Format local d'heure

console.log(d.getTime()) // Temp en milliseconde
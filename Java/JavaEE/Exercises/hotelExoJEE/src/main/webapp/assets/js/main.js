var today = new Date().toISOString().split('T')[0];
document.getElementsByName("checkin")[0].setAttribute('min', today);
document.getElementsByName("checkout")[0].setAttribute('min', today);

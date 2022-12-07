
/*
const btn = document.querySelector(".btn-add-product")

btn.addEventListener("click", (e) => {

    e.preventDefault()
    const input = document.createElement("select");


    input.setAttribute("type", "text");
    input.setAttribute("name", "textInput");


    document.getElementById("product-input").appendChild(input)

})*/



function calculateAmount(){
    let firstElement = document.getElementById("serviceQuantity").value;
    let secondElement = document.getElementById("service").selectedOptions[0].dataset.price;
    console.log(firstElement)
    console.log(secondElement)


    if(firstElement > 0) {
    let totalPrice = firstElement * secondElement
        document.getElementById("priceHT").value = totalPrice.toFixed(2)
        calculateTTC(totalPrice)

    }

}

function calculateTTC(totalPrice){
    let tva = document.getElementById("service").selectedOptions[0].dataset.tva;

    let totalPriceTTC = (tva * totalPrice)/100 + totalPrice
    document.getElementById("priceTTC").value = totalPriceTTC.toFixed(2)
}
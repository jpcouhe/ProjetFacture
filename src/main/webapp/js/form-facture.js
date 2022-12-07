console.log("salut")


const btn = document.querySelector(".btn-add-product")

btn.addEventListener("click", (e) => {

    e.preventDefault()
    const input = document.createElement("select");
    

    input.setAttribute("type", "text");
    input.setAttribute("name", "textInput");


    document.getElementById("product-input").appendChild(input)

})
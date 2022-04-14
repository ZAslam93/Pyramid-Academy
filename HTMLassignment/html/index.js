function render() {
    userInfo = [document.getElementById("first-name").value,
                document.getElementById("last-name").value,
                document.getElementById("email").value,
                document.getElementById("country-select").value]
    document.getElementById("show-form").innerHTML = 
    `${userInfo[0]}<br>${userInfo[1]}<br>${userInfo[2]}<br>${userInfo[3]}`
    console.log("Success?")
}
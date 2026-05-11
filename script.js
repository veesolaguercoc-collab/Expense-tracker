let userName = "";
let budget = 0;
let remaining = 0;
let expenses = [];

function setName() {
    userName = document.getElementById("nameInput").value;
    if(userName === "") return alert("Enter name!");

    document.getElementById("nameSection").classList.add("hidden");
    document.getElementById("budgetSection").classList.remove("hidden");
    document.getElementById("welcomeText").innerText = "Hello, " + userName;
}

function setBudget() {
    budget = parseFloat(document.getElementById("budgetInput").value);
    if(isNaN(budget)) return alert("Enter valid budget!");

    remaining = budget;

    document.getElementById("budgetSection").classList.add("hidden");
    document.getElementById("menuSection").classList.remove("hidden");

    log("Budget set: " + budget);
}

function showAdd() {
    document.getElementById("addSection").classList.toggle("hidden");
}

function addExpense() {
    let category = document.getElementById("category").value;
    let amount = parseFloat(document.getElementById("amount").value);

    if(category === "" || isNaN(amount)) {
        alert("Fill all fields!");
        return;
    }

    expenses.push({category, amount});
    remaining -= amount;

    log("Added! Category: " + category + " | Amount: " + amount);
    log("Remaining: " + remaining);

    document.getElementById("category").value = "";
    document.getElementById("amount").value = "";
}

function viewStatus() {
    log("------ STATUS ------");
    log("Total Budget: " + budget);
    log("Remaining: " + remaining);

    expenses.forEach((e, i) => {
        log((i+1) + ". " + e.category + " - " + e.amount);
    });
}

function exitApp() {
    alert("Thank you, " + userName + "!");
    location.reload();
}

function log(message) {
    let logBox = document.getElementById("log");
    logBox.innerHTML += message + "<br>";
    logBox.scrollTop = logBox.scrollHeight;
}

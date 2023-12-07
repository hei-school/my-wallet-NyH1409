const prompt = require("prompt-sync")();
const { Wallet } = require("./model/Wallet");


function menu() {
    console.log("Bienvenue sur MyWallet!");
    console.log("1 - Placer de l'argent dans une poche");
    console.log("2 - Consulter le montant total dans une poche");
    console.log("3 - Consulter le montant total dans la portefeuille");
    console.log("4 - Retirer de l'argent");
    console.log("5 - Securiser la portefeuille");
    console.log("6 - S'identifier");
}

function redirect(wallet, choice) {

    switch (choice) {
        case 1:
            const pocketNumber = +prompt("Dans quelle poche ? (1 - 4) ")
            const amount = +prompt("Le montant a placer ? (MGA) ")
            wallet.putIn(pocketNumber, amount);
            break;
        case 2:
            const pocketNum = +prompt("Dans quelle poche ? (1 - 4) ")
            console.log(`Dans la poche ${pocketNum}, vous avez ${wallet.getAmountInPocket(parseInt(pocketNum))} (MGA)`);
            break;
        case 3:
            console.log(`Dans la portefeuille , vous avez ${wallet.getAmountIn()} (MGA)`);
            break;
        case 4:
            const pocket = +prompt("Dans quelle poche ? (1 - 4) ")
            const toPull = +prompt("Le montant a retirer ? (MGA) ")
            wallet.retrieveMoney(pocket, toPull);
            break;
        case 5:
            const pass = prompt("Ajouter un mot de passe : ");
            wallet.secure(pass);
            break;
        case 6:
            const pwd = prompt("Entrer le mot de passe : ");
            wallet.authenticate(pwd);
            break;
        default:
            console.log(`Vous avez dans votre portefeuille : ${wallet.getAmountIn()}`);
    }
}


const myWallet = new Wallet();

while (true) {
    menu();
    const choice = +prompt("Saisir : ");
    redirect(myWallet, choice);
}

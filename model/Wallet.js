const { Pocket } = require("./Pocket")

class Wallet {
    
    constructor() {
        this.isSecured = false;
        this.password = "";
        this.pockets = [new Pocket(1), new Pocket(2), new Pocket(3), new Pocket(4), new Pocket(5)];
    }

    putIn(pocketNumber, amount) {
        if (this.isSecured) {
            console.log("La portefeuille est en mode sécurisé. Veuillez vous authentifier svp (6)");
        } else {
            const pocket = this.pockets.find(pk => pk.number === pocketNumber);
            if (pocket) {
                pocket.putIn(amount);
            }
        }
    }

    getAmountIn() {
        if (this.isSecured) {
            console.log("La portefeuille est en mode sécurisé. Veuillez vous authentifier svp (6)!");
        } else {
            return this.pockets.reduce((total, pocket) => total + pocket.getAmountIn(), 0);
        }
    }

    getAmountInPocket(pocketNumber) {
        if (this.isSecured) {
            console.log("La portefeuille est en mode sécurisé. Veuillez vous authentifier svp (6)!");
        } else {
            const pocket = this.pockets.find(pk => pk.number === pocketNumber);
            return pocket ? pocket.getAmountIn() : 0;
        }
    }

    secure(password) {
        this.isSecured = true;
        this.password = password;
    }

    authenticate(password) {
        if (this.password === password) {
            this.isSecured = false;
        } else {
            console.log("Mot de passe incorrect");
        }
    }

    retrieveMoney(pocketNumber, amount) {
        const pocket = this.pockets.find(pk => pocketNumber === pk.number);

        if (this.isSecured) {
            console.log("La portefeuille est en mode sécurisé. Veuillez vous authentifier svp (6)!");
        } else {
            if (pocket.getAmountIn() < amount) {
                console.log(`Les billets dans la poche ${pocketNumber} sont insuffisants pour le retrait.`);
                const remain = amount - pocket.getAmountIn();
                pocket.empty();

                const random = this.pockets.find(pk => pk.getAmountIn() >= remain);
                if (!random) {
                    console.log("Vous n'avez pas assez d'argent.");
                } else {
                    const remainInRandom = random.getAmountIn() - remain;
                    random.empty();
                    random.putIn(remainInRandom);
                }
            } else {
                const remain = pocket.getAmountIn() - amount;
                pocket.empty();
                pocket.putIn(remain);
            }
        }
    }
}


module.exports = { Wallet }
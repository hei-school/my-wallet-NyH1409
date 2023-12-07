class Pocket {
    
    constructor(number) {
        this.amounts = [];
        this.number = number;
    }

    getAmountIn() {
        return this.amounts.reduce((total, amount) => total + amount, 0);
    }

    putIn(amount) {
        this.amounts.push(amount);
    }

    empty() {
        this.amounts = [];
    }
}


module.exports = { Pocket }
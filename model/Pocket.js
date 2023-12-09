class Pocket {
    constructor(number) {
        this._objects = [];
        this._number = number;
    }

    getObjects() {
        return this._objects;
    }

    getNumber() {
        return this._number;
    }

    empty() {
        this._objects = [];
    }

    putObject(obj) {
        this._objects.push(obj);
    }

    retrieveObject(obj) {
        const index = this._objects.indexOf(obj);
        if (index !== -1) {
            this._objects.splice(index, 1);
        }
    }

    toString() {
        return `Pocket{objects=${this._objects}, number=${this._number}}`;
    }
}


export default Pocket;
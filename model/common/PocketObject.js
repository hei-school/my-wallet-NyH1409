class PocketObject {
    constructor(id) {
        this._id = id;
        this._isLost = false;
    }

    isLost() {
        return this._isLost;
    }

    setLost(lost) {
        this._isLost = lost;
    }

    getId() {
        return this._id;
    }
}

export default PocketObject;
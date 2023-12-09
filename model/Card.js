import PocketObject from './common/PocketObject.js';


class Card extends PocketObject {
    constructor(id, type) {
        super(id);
        this._type = type;
    }

    getType() {
        return this._type;
    }

    toString() {
        return `Card{type=${this._type}}`;
    }
}

export default Card
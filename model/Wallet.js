import CardType from './CardType.js';
import Card from './Card.js';
import Money from './Money.js';
import Pocket from './Pocket.js';

class Wallet {
    constructor() {
        this._pockets = Array.from({ length: 5 }, (_, i) => new Pocket(i + 1));
    }

    putObjectIn(pocketNumber, obj) {
        const matchingPockets = this._pockets.filter(pocket => pocket.getNumber() === pocketNumber);
        if (matchingPockets.length > 0) {
            matchingPockets[0].putObject(obj);
        }
        return matchingPockets;
    }

    putObjectOut(objectId) {
        const obj = this.getObjects().find(o => o.getId() === objectId);
        if (obj) {
            this._pockets.forEach(pocket => pocket.retrieveObject(obj));
        }
        return this._pockets;
    }

    getObjectLocation(objectId) {
        const obj = this.getObjects().find(o => o.getId() === objectId);
        return obj ? this._pockets.find(pocket => pocket.getObjects().includes(obj)) : null;
    }

    getObjects() {
        return this._pockets.flatMap(pocket => pocket.getObjects());
    }

    getObjectIn(pocketNumber) {
        const matchingPocket = this._pockets.find(pocket => pocket.getNumber() === pocketNumber);
        return matchingPocket ? matchingPocket.getObjects() : [];
    }

    getBalance() {
        const money = this.getObjects().filter(obj => obj instanceof Money);
        return money.reduce((total, m) => total + m.getAmount(), 0);
    }

    countObject(objectType) {
        const cards = this.getObjects().filter(obj => obj instanceof Card);
        switch (objectType) {
            case CardType.NI_CARD:
                return cards.filter(cd => cd.getType() === CardType.NI_CARD).length;
            case CardType.CREDIT_CARD:
                return cards.filter(cd => cd.getType() === CardType.CREDIT_CARD).length;
            case CardType.DRIVING_CARD:
                return cards.filter(cd => cd.getType() === CardType.DRIVING_CARD).length;
            case CardType.VISIT_CARD:
                return cards.filter(cd => cd.getType() === CardType.VISIT_CARD).length;
            default:
                return 0;
        }
    }
}

export default Wallet;
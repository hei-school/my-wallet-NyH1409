import Card from '../model/Card.js';
import Money from '../model/Money.js';
import Photo from '../model/Photo.js';
import CardType from '../model/CardType.js';

class AppUtils {
    static beautifulMenu() {
        console.log("+++++++++++++++++++++++++++++++++++++");
        console.log("++wwww+++++++++++++++++++++wwww++++++");
        console.log("+++wwww++++++++++++++++++wwww++++++++");
        console.log("++++wwww++++wwwwwww++++wwww++++++++++");
        console.log("++++++wwww+wwww+wwww+wwww++++++++++++");
        console.log("+++++++wwwwww++++wwwwwww+++++++++++++");
        console.log("+++++++++++++++++++++++++++++++++++++");
        console.log("+++++++++++++++++++++++++++++++++++++");
    }

    static menu() {
        console.log("Welcome to MyWallet!");
        AppUtils.beautifulMenu();
        console.log("1 - Put object in");
        console.log("2 - Put object out");
        console.log("3 - Get money balance");
        console.log("4 - Get objects in a specific pocket");
        console.log("5 - Find object (provide the identifier)");
        console.log("6 - Count object [Credit card, visit card, driving card, National Card]");
        console.log("7 - Indicate object lost or found");
    }

    static objectTypeMenu(wallet, objectId, pocketNumber, type) {
        switch (type) {
            case 1:
                console.log("Money amount: ");
                const amount = parseFloat(prompt());
                wallet.putObjectIn(pocketNumber, new Money(objectId, amount));
                break;
            case 2:
                wallet.putObjectIn(pocketNumber, new Photo(objectId));
                break;
            case 3:
                wallet.putObjectIn(pocketNumber, new Card(objectId, CardType.CREDIT_CARD));
                break;
            case 4:
                wallet.putObjectIn(pocketNumber, new Card(objectId, CardType.VISIT_CARD));
                break;
            case 5:
                wallet.putObjectIn(pocketNumber, new Card(objectId, CardType.DRIVING_CARD));
                break;
            case 6:
                wallet.putObjectIn(pocketNumber, new Card(objectId, CardType.NI_CARD));
                break;
            default:
                console.log("Unrecognized object type ");
        }
    }

    static objectCountMenu(wallet, type) {
        switch (type) {
            case 1:
                console.log(`Credit card count: ${wallet.countObject(CardType.CREDIT_CARD)}`);
                break;
            case 2:
                console.log(`Visit card count: ${wallet.countObject(CardType.VISIT_CARD)}`);
                break;
            case 3:
                console.log(`Driving card count: ${wallet.countObject(CardType.DRIVING_CARD)}`);
                break;
            case 4:
                console.log(`NI card count: ${wallet.countObject(CardType.NI_CARD)}`);
                break;
            default:
                console.log("Unrecognized object type ");
        }
    }
}

export default AppUtils;
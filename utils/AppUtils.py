from model import Card, Money, Photo
from model import CardType


class AppUtils:
    @staticmethod
    def beautiful_menu():
        print("+++++++++++++++++++++++++++++++++++++")
        print("++wwww+++++++++++++++++++++wwww++++++")
        print("+++wwww++++++++++++++++++wwww++++++++")
        print("++++wwww++++wwwwwww++++wwww++++++++++")
        print("++++++wwww+wwww+wwww+wwww++++++++++++")
        print("+++++++wwwwww++++wwwwwww+++++++++++++")
        print("+++++++++++++++++++++++++++++++++++++")
        print("+++++++++++++++++++++++++++++++++++++")

    @staticmethod
    def menu():
        print("Welcome to MyWallet!")
        AppUtils.beautiful_menu()
        print("1 - Put object in")
        print("2 - Put object out")
        print("3 - Get money balance")
        print("4 - Get objects in a specific pocket")
        print("5 - Find object (provide the identifier)")
        print("6 - Count object [Credit card, visit card, driving card, National Card]")
        print("7 - Indicate object lost or found")

    @staticmethod
    def object_type_menu(wallet, object_id, pocket_number, obj_type):
        if obj_type == 1:
            amount = float(input("Money amount: "))
            wallet.put_object_in(pocket_number, Money.Money(object_id, amount))
        elif obj_type == 2:
            wallet.put_object_in(pocket_number, Photo.Photo(object_id))
        elif obj_type == 3:
            wallet.put_object_in(pocket_number, Card.Card(object_id, CardType.CardType.CREDIT_CARD))
        elif obj_type == 4:
            wallet.put_object_in(pocket_number, Card.Card(object_id, CardType.CardType.VISIT_CARD))
        elif obj_type == 5:
            wallet.put_object_in(pocket_number, Card.Card(object_id, CardType.CardType.DRIVING_CARD))
        elif obj_type == 6:
            wallet.put_object_in(pocket_number, Card.Card(object_id, CardType.CardType.NI_CARD))
        else:
            print("Unrecognized object type")

    @staticmethod
    def object_count_menu(wallet, obj_type):
        if obj_type == 1:
            print(f"Credit card count: {wallet.count_object(CardType.CardType.CREDIT_CARD)}")
        elif obj_type == 2:
            print(f"Visit card count: {wallet.count_object(CardType.CardType.VISIT_CARD)}")
        elif obj_type == 3:
            print(f"Driving card count: {wallet.count_object(CardType.CardType.DRIVING_CARD)}")
        elif obj_type == 4:
            print(f"NI card count: {wallet.count_object(CardType.CardType.NI_CARD)}")
        else:
            print("Unrecognized object type")

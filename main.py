import random

from utils import AppUtils

from model import Wallet


def main():
    my_wallet = Wallet.Wallet()

    while True:
        AppUtils.AppUtils.menu()
        print("Saisir : ")
        choice = int(input())
        redirect(my_wallet, choice)


def redirect(wallet, choice):
    object_id = random.randint(1, 100)

    if choice == 1:
        print("Which pocket ? (1 - 5) ")
        pocket_number = int(input())
        print("Object type : ")
        print("1 - Money ")
        print("2 - Photo")
        print("3 - Credit Card")
        print("4 - Visit Card")
        print("5 - Driving Card")
        print("6 - National Identity Card")
        print("Choice : ")
        obj_type = int(input())
        AppUtils.AppUtils.object_type_menu(wallet, object_id, pocket_number, obj_type)
    elif choice == 2:
        print("All object you can put out ")
        objects = wallet.get_objects()
        for obj in objects:
            print(f"[{obj.get_id()} - {obj.__class__.__name__}] ")
        print("Choose object identifier : ")
        obj_id = int(input())
        wallet.put_object_out(obj_id)
    elif choice == 3:
        print(f"Actual Balance : {wallet.get_balance()} MGA ")
    elif choice == 4:
        print("Which pocket ? (1 - 5) ")
        pocket = int(input())
        print(f"All objects in pocket number {pocket} ")
        object_list = wallet.get_object_in(pocket)
        for obj in object_list:
            print(f"[{obj.get_id()} - {obj.__class__.__name__}] ")
    elif choice == 5:
        wallet_objects = wallet.get_objects()
        for obj in wallet_objects:
            print(f"[{obj.get_id()} - {obj.__class__.__name__}] ")
        print("Choose object identifier : ")
        obj_ide = int(input())
        print(f"Object found in the pocket number {wallet.get_object_location(obj_ide).get_number()} ")
    elif choice == 6:
        print("Object type : ")
        print("1 - Credit Card")
        print("2 - Visit Card")
        print("3 - Driving Card")
        print("4 - National Identity Card")
        print("Choice : ")
        card_type = int(input())
        AppUtils.AppUtils.object_count_menu(wallet, card_type)
    else:
        pass


if __name__ == "__main__":
    main()

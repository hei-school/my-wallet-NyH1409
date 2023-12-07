from model.Wallet import Wallet


def menu():
    print("Bienvenue sur MyWallet!")
    print("1 - Placer de l'argent dans une poche")
    print("2 - Consulter le montant total dans une poche")
    print("3 - Consulter le montant total dans la portefeuille")
    print("4 - Retirer de l'argent")
    print("5 - Securiser la portefeuille")
    print("6 - S'identifier")


def redirect(wallet, choice):
    if choice == 1:
        pocket_number = int(input("Dans quelle poche ? (1 - 4) "))
        amount = float(input("Le montant a placer ? (MGA) "))
        wallet.put_in(pocket_number, amount)
    elif choice == 2:
        pocket_number = int(input("Dans quelle poche ? (1 - 4) "))
        print(f"Dans la poche {pocket_number}, vous avez {wallet.get_amount_in_pocket(pocket_number)} (MGA)")
    elif choice == 3:
        print(f"Dans la portefeuille, vous avez {wallet.get_amount_in()} (MGA)")
    elif choice == 4:
        pocket_number = int(input("Dans quelle poche ? (1 - 4) "))
        to_pull = float(input("Le montant a retirer ? (MGA) "))
        wallet.retrieve_money(pocket_number, to_pull)
    elif choice == 5:
        password = input("Ajouter un mot de passe : ")
        wallet.secure(password)
    elif choice == 6:
        password = input("Entrer le mot de passe : ")
        if wallet.authenticate(password):
            print("Authentification réussie.")
        else:
            print("Mot de passe incorrect.")
    else:
        print(f"Vous avez dans votre portefeuille : {wallet.get_amount_in()}")


if __name__ == "__main__":
    my_wallet = Wallet()
    while True:
        menu()
        choice = int(input("Saisir : "))
        redirect(my_wallet, choice)

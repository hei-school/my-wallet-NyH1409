from model.Pocket import Pocket


class Wallet:

    def __init__(self):
        self.is_secured = False
        self.password = ""
        self.pockets = [Pocket(1), Pocket(2), Pocket(3), Pocket(4), Pocket(5)]

    def put_in(self, pocket_number, amount):
        if self.is_secured:
            print("La portefeuille est mon mode securise. Veuillez vous authentifier svp (6)")
        else:
            pocket = [pk for pk in self.pockets if pk.number == pocket_number][0]
            pocket.put_in(amount)

    def get_amount_in(self):
        if self.is_secured:
            print("La portefeuille est mon mode securise. Veuillez vous authentifier svp (6)!")
        else:
            return sum([pk.amounts for pk in self.pockets])

    def secure(self, password):
        self.is_secured = True
        self.password = password

    def authenticate(self, password):
        if self.password == password:
            self.is_secured = False
        else:
            print("Mot de passe incorrect")

    def retrieve_money(self, pocker_number, amount):
        pocket = [pk for pk in self.pockets if pocker_number == pk.number][0]
        if self.is_secured:
            print("La portefeuille est mon mode securise. Veuillez vous authentifier svp (6)!")
        else:
            if pocket.get_amount_in() < amount:
                print(f"Les billets dans la poche {pocker_number} est insuffisant pour le retrait.")
                remain = amount - pocket.get_amount_in()
                pocket.empty()
                random = [pk for pk in self.pockets if pk.get_amount_in() >= remain]
                if len(random) == 0:
                    print("Vous n'avez pas assez d'argent.")

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
            return sum([sum(pk.amounts) for pk in self.pockets])

    def get_amount_in_pocket(self, pocket_number):
        if self.is_secured:
            print("La portefeuille est mon mode securise. Veuillez vous authentifier svp (6)!")
        else:
            pocket = [pk for pk in self.pockets if pk.number == pocket_number][0]
            return sum(pocket.amounts)

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
                else :
                    random_pk = random[0]
                    remain_in_random = random_pk.get_amount_in() - remain
                    random_pk.empty()
                    random_pk.put_in(remain_in_random)
            else:
                remain = pocket.get_amount_in() - amount
                pocket.empty()
                pocket.put_in(remain)
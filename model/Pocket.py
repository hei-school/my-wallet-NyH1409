class Pocket:
    def __init__(self, number):
        self.amounts = []
        self.number = number

    def get_amount_in(self):
        return sum(self.amounts)

    def put_in(self, amount):
        self.amounts.append(amount)

    def empty(self):
        self.amounts.clear()
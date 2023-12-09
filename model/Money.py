from model.common.PocketObject import PocketObject


class Money(PocketObject):
    def __init__(self, id, amount):
        super().__init__(id)
        self._amount = amount

    def get_amount(self):
        return self._amount

    def set_amount(self, amount):
        self._amount = amount

    def __str__(self):
        return f"Money{{amount={self._amount}}}"

from model.common.PocketObject import PocketObject


class Card(PocketObject):
    def __init__(self, id, card_type):
        super().__init__(id)
        self._type = card_type

    def get_type(self):
        return self._type

    def __str__(self):
        return f"Card{{type={self._type}}}"

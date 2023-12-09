from model import Card, Money, Pocket


class Wallet:
    def __init__(self):
        self._pockets = [Pocket.Pocket(i) for i in range(1, 6)]

    def put_object_in(self, pocket_number, obj):
        matching_pockets = [pocket for pocket in self._pockets if pocket.get_number() == pocket_number]
        if matching_pockets:
            matching_pockets[0].put_object(obj)
        return matching_pockets

    def put_object_out(self, object_id):
        obj = next((o for o in self.get_objects() if o.get_id() == object_id), None)
        if obj:
            for pocket in self._pockets:
                pocket.retrieve_object(obj)
        return self._pockets

    def get_object_location(self, object_id):
        obj = next((o for o in self.get_objects() if o.get_id() == object_id), None)
        if obj:
            return next((pocket for pocket in self._pockets if obj in pocket.get_objects()), None)

    def get_objects(self):
        return [obj for pocket in self._pockets for obj in pocket.get_objects()]

    def get_object_in(self, pocket_number):
        matching_pocket = next((pocket for pocket in self._pockets if pocket.get_number() == pocket_number), None)
        return matching_pocket.get_objects() if matching_pocket else []

    def get_balance(self):
        money = [obj for obj in self.get_objects() if isinstance(obj, Money.Money)]
        return sum(m.get_amount() for m in money)

    def count_object(self, object_type):
        cards = [obj for obj in self.get_objects() if isinstance(obj, Card.Card)]
        return sum(1 for card in cards if card.get_type() == object_type)

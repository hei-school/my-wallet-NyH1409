class PocketObject:
    def __init__(self, id):
        self._id = id
        self._is_lost = False

    def is_lost(self):
        return self._is_lost

    def set_lost(self, lost):
        self._is_lost = lost

    def get_id(self):
        return self._id
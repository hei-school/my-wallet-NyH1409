from typing import List

from model.common import PocketObject


class Pocket:
    def __init__(self, number):
        self._objects: List[PocketObject] = []
        self._number = number

    def get_objects(self):
        return self._objects

    def get_number(self):
        return self._number

    def empty(self):
        self._objects.clear()

    def put_object(self, obj):
        self._objects.append(obj)

    def retrieve_object(self, obj):
        self._objects.remove(obj)

    def __str__(self):
        return f"Pocket{{objects={self._objects}, number={self._number}}}"

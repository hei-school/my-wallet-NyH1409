from model.Pocket import Pocket

if __name__ == "__main__":
    pocket = Pocket(1)
    pocket.put_in(10000)
    pocket.put_in(10000)
    print(pocket.get_amount_in())

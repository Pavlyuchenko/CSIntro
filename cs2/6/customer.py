class Customer:
    def __init__(self, name, prod_list):
        self.name = name
        self.prod_list = prod_list

    def add(self, name, amount):
        self.prod_list.append((name, amount))

    def products(self):
        return self.prod_list

    def expensive_products(self, price):
        return [prod[0] for prod in self.prod_list if prod[1] > price]


if __name__ == '__main__':
    c = Customer('John', [])
    c.add('milk', 1)
    c.add('bread', 2)
    c.add('butter', 3)
    print(c.products())
    print(c.expensive_products(4))

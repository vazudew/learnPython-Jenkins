class CalculatorClass:

    def __init__(self, operand1, operand2, oper):
        self.item1 = operand1
        self.item2 =operand2
        self.operator = oper

    def setOperator(self, oper):
        # print ("setting operator to " + str(oper))
        self.operator = oper

    def runOperation(self):
        print("Operator is " + str(self.operator))
        switcher = {
            '+': self.item1 + self.item2,
            '-': self.item1 - self.item2,
            '*': self.item1 * self.item2,
            '/': self.item1 / self.item2
        }
        return switcher.get(self.operator, "invalid output");

def main():
    a = CalculatorClass(1,5,"+")
    if a.item2 == 0 and a.operator =='/' :
        raise Exception("Sorry, Operator can not be division when Operand is 0")
    print(a.runOperation())

if __name__ == "__main__":
    main()
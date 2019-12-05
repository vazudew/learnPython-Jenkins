import unittest
from CalculatorClass import CalculatorClass


class MyTestCase(unittest.TestCase):
    tempCalculatorObject = None

    def test_init(self):
        tempCalculatorObject = CalculatorClass(1,5,2)
        self.assertEqual(tempCalculatorObject.item1, 1)
        self.assertEqual(tempCalculatorObject.item2, 5)
        self.assertEqual(tempCalculatorObject.operator, 2)

    def test_setOperator(self):
        tempCalculatorObject = CalculatorClass(1, 5, 2)
        tempCalculatorObject.setOperator("+")
        self.assertEqual(tempCalculatorObject.operator, "+")

    def test_runOperationInvalidOuput(self):
        tempCalculatorObject = CalculatorClass(1, 5, 2)
        self.assertEqual(tempCalculatorObject.runOperation(), "invalid output")

    def test_runOperationZeroDivision(self):
        tempCalculatorObject = CalculatorClass(1, 0, "/")
        with self.assertRaises(ZeroDivisionError):
            tempCalculatorObject.runOperation()

    def test_runOperationMultiplication(self):
        tempCalculatorObject = CalculatorClass(12, 500, "*")
        self.assertEqual(tempCalculatorObject.runOperation(), 6000)

    def test_runOperationNegativeSubtraction(self):
        tempCalculatorObject = CalculatorClass(12, 500, "-")
        self.assertEqual(tempCalculatorObject.runOperation(), -488)

def suite():
    suite = unittest.TestSuite()
    suite.addTest(MyTestCase('test_init'))
    suite.addTest(MyTestCase('test_setOperator'))
    suite.addTest(MyTestCase('test_runOperationInvalidOuput'))
    suite.addTest(MyTestCase('test_runOperationZeroDivision'))
    suite.addTest(MyTestCase('test_runOperationMultiplication'))
    suite.addTest(MyTestCase('test_runOperationNegativeSubtraction'))
    return suite

if __name__ == '__main__':
    runner = unittest.TextTestRunner()
    runner.run(suite())

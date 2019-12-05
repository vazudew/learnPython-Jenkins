import unittest
import CalculatorClass


class MyTestCase(unittest.TestCase):
    item1 = CalculatorClass(1,2,3)

    def test_something(self):
        self.assertEqual(True, False)


if __name__ == '__main__':
    unittest.main()

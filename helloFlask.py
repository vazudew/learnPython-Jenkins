from CalculatorClass import CalculatorClass
from flask import Flask, redirect, url_for, request, jsonify
app = Flask(__name__)

tempCalculatorObject = None


@app.route('/init',methods = ['POST', 'GET'])
def init():
   if request.method == 'POST':
       item1 = request.form['item1input']
       item2 = request.form['item2input']
       oper = request.form['Operator']
   else:
       item1 = request.args.get('item1input')
       item2 = request.args.get('item2input')
       oper = request.args.get('Operator')
       print("item1" + str(item1) + " item2 " + str(item2) + " Operator :" + oper)
   tempCalculatorObject = CalculatorClass (item1, item2, oper)
   return jsonify(
       item1 = tempCalculatorObject.item1,
       item2 = tempCalculatorObject.item2,
       operator = tempCalculatorObject.operator
   )

if __name__ == '__main__':
   app.run()
from CalculatorClass import CalculatorClass
from flask import Flask, request, render_template
app = Flask(__name__)

tempCalculatorObject = None
switcher = {
    "add" : "+",
    "sub" : "-",
    "mul" : "*",
    "div" : "/"
    }

@app.route('/init',methods = ['POST', 'GET'])
def init():
   if request.method == 'POST':
       item1 = int(request.form['item1input'])
       item2 = int(request.form['item2input'])
       oper = switcher.get(request.form['Operator'])
   else:
       item1 = int(request.args.get('item1input'))
       item2 = int(request.args.get('item2input'))
       oper = switcher.get(request.args.get('Operator'))
       print("item1" + str(item1) + " item2 " + str(item2) + " Operator :" + oper)
   tempCalculatorObject = CalculatorClass (item1, item2, oper)
   return render_template('result.html', item1 = str(tempCalculatorObject.item1), item2 = str(tempCalculatorObject.item2),
                          oper = str(tempCalculatorObject.operator), result = str(tempCalculatorObject.runOperation()))

if __name__ == '__main__':
    app.debug = True
   app.run(host='0.0.0.0', port='5000')
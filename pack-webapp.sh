#!/usr/bin/bash

echo "remove older artefacts if exist"
rm -rf webapp
echo "create folder structure and populate content"
mkdir webapp
cp -rf static webapp/.
cp -rf templates webapp/.
cp  CalculatorFlask.py webapp/.
cp CalculatorClass.py webapp/.
cp pipreq.txt webapp/.
cp README.md webapp/.


#!/usr/bin/env groovy

pipeline {
agent any
	stages {
		stage('checkout') {
				steps {
					sh 'echo "checkout the code here "'
					sh 'echo "remove older content from directory"'
					sh 'pwd'
					cleanWs()
					sh 'echo "create working directory again"'
					sh 'echo "ensure empty folder"'
					sh 'ls -la'
					sh 'echo "execute git clone and check the folder"'
					git credentialsId: '7776e9c9-9379-45e6-a4fd-f97d834f1dda', url: 'https://github.com/vazudew/jenkins_setup.git'
					sh 'ls -la'
			 }
		}
		stage('Test') {
				steps {
					sh 'echo "Test Phase"'
					sh 'pwd'
					sh 'ls -la'
					sh 'uname -a'
					sh 'ifconfig '
					sh 'python CalculatorTest.py'
				}
			}

		stage('Deploy') {
				steps {
					sh 'echo "Deploy phase"'
			 }
		}
	}
}

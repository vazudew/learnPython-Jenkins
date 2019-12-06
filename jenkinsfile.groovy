#!/usr/bin/env groovy

pipeline {
agent { docker { image 'python:3.7.2' } }
		options {
		skipStagesAfterUnstable()
	}
	stages {
		stage('checkout') {
				steps {
					sh 'echo "checkout step here"'
					//git credentialsId: '7776e9c9-9379-45e6-a4fd-f97d834f1dda', url: 'https://github.com/vazudew/jenkins_setup.git'
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
					sh 'docker stop $(docker ps -a -q)'
					sh 'docker rm $(docker ps -a -q)'
			 }
		}
	}
}

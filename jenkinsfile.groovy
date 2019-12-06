#!/usr/bin/env groovy

pipeline {
agent { 
		docker { image 'python:3.7.2' 
		} 
	}
		options {
		skipStagesAfterUnstable()
	}
	stages {
		stage('checkout') {
				steps {
					sh 'echo "checkout step here"'
					sh 'echo "remove older content"'
					sh 'rm -rf /var/lib/jenkins/workspace/webapp'
					sh 'echo "create working directory again"'
					sh 'mkdir /var/lib/jenkins/workspace/webapp'
					dir(path: '/var/lib/jenkins/workspace/webapp')
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
					sh 'docker stop $(docker ps -a -q)'
					sh 'docker rm $(docker ps -a -q)'
			 }
		}
	}
}

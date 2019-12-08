#!/usr/bin/env groovy

pipeline {
agent any
	stages {
		stage('checkout') {
				steps {
					sh 'echo "checkout the code here "'
					cleanWs()
					sh 'echo "execute git clone and check the folder"'
					git branch: 'master', credentialsId: '7776e9c9-9379-45e6-a4fd-f97d834f1dda', url: 'https://github.com/vazudew/learnPython-Jenkins.git'
			 }
		}
		stage('Test') {
				steps {
					sh 'echo "Test Phase"'
					sh 'pwd'
					sh 'ls -la'
					sh 'uname -a'
					sh 'ifconfig '
					sh 'whoami '
					sh 'python CalculatorTest.py'
				}
			}

		stage('Deploy') {
				steps {
					sh 'echo "Deploy phase "'
					sh 'echo "create webapp packer"'
					sh 'sudo chmod 0755 pack-webapp.sh'
					sh 'sudo chmod 0755 sshexpects.sh'
					sh './pack-webapp.sh'
					sh 'echo "try to ssh and copy artefacts into deployment server"'
					sh 'scp  -r /var/lib/jenkins/workspace/webapp/calap/ jenkins@3.125.118.211:/home/jenkins/.'
					sh 'set'
					sh './sshexpects.sh'
			 }
		}
	}
}

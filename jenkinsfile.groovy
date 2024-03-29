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
					sh 'sudo chmod 0755 sshexpectsCleanWS.sh'
					sh 'sudo chmod 0755 scpexpects.sh'
					sh 'sudo chmod 0755 sshexpectsAppRun.sh'
					sh 'sudo chmod 0755 pack-webapp.sh'
					
					sh 'echo "create webapp packer"'
					sh 'sudo chmod 0755 pack-webapp.sh'
					sh './pack-webapp.sh'

					sh 'echo "clean workspace of webserver"'
					sh './sshexpectsCleanWS.sh'

					sh 'echo "try to ssh and copy artefacts into deployment server"'
					sh './scpexpects.sh'
					sh 'set'

					sh 'echo "execute the webserver and app"'
					sh './sshexpectsAppRun.sh'

					
			 }
		}
	}
}

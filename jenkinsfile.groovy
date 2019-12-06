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
					sh 'echo $USER '
			 }
		}

		stage('Build') {
				steps {
					sh 'echo "Build phase"'
				}
		}

		stage('Test') {
				steps {
					sh 'echo "Test Phase"'
				}
			}

		stage('Deploy') {
				steps {
					sh 'echo "deploy"'
			 }
		}
	}
}

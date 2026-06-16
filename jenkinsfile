pipeline {
	agent any
	environment {
		mavenHome = tool 'myMaven'
		//dockerHome = tool 'myDocker'
		PATH = "$mavenHome/bin:$PATH"
	}
	// agent {docker {image 'maven:3.8.4-openjdk-21'}}
	stages {
		stage('Checkout'){
			steps {
				sh 'mvn --version'
				//sh 'docker version'
				echo "Checkout"
				echo "PATH"
			}
		}
		stage('compile') {
			steps {
				sh 'mvn clean compile'
				echo "Compile"
			}
		}
		stage('Test') {
			steps {
				sh 'mvn test'
				echo "Test"
			}
		}
	}
}

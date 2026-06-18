pipeline {
    agent any

    environment {
        mavenHome = tool 'myMaven'
        PATH = "${mavenHome}/bin:${PATH}"
    }

    stages {
        stage('Compile') {
            steps {
                sh 'mvn clean compile'
            }
        }

        stage('Install Browsers') {
            steps {
                sh 'mvn exec:java -Dexec.mainClass=com.microsoft.playwright.CLI -Dexec.args="install chromium"'
            }
        }

        stage('Test') {
            steps {
                sh 'mvn clean test -DsuiteXmlFile=Suite.xml'
            }
        }
    }
}
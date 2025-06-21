pipeline {
    agent any

    tools {
        maven 'Maven 3'
        jdk 'JDK 21'
    }

    environment {
        CHROME_BIN = '/usr/bin/google-chrome'
        CHROMEDRIVER_BIN = '/usr/bin/chromedriver'
    }

    stages {
        stage('Checkout Code') {
            steps {
                git url: 'https://github.com/NITHISH132390/jenkins-Selenium.git'
            }
        }

        stage('Build with Maven') {
            steps {
                sh 'mvn clean install'
            }
        }

        stage('Run Selenium Tests') {
            steps {
                sh 'mvn test'
            }
        }
    }

    post {
        always {
            junit 'target/surefire-reports/*.xml'
        }
    }
}

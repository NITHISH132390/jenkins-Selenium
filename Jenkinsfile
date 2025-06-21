pipeline {
    agent any

    tools {
        jdk 'JDK 21'           // Must match your configured name in Jenkins
        maven 'Maven 3'        // Must match your configured Maven tool name
    }

    environment {
        CHROME_BIN = '/usr/bin/google-chrome'
        CHROMEDRIVER_BIN = '/usr/bin/chromedriver'
    }

    stages {
        stage('Checkout Code') {
            steps {
                echo 'Cloning Git repository...'
                // You can hardcode Git clone here if you want
                sh '''
                    rm -rf selenium-maven
                    git clone https://github.com/NITHISH132390/jenkins-Selenium.git selenium-maven
                '''
            }
        }

        stage('Build Project') {
            steps {
                dir('selenium-maven') {
                    sh 'mvn clean compile'
                }
            }
        }

        stage('Run Selenium Tests') {
            steps {
                dir('selenium-maven') {
                    sh 'mvn test'
                }
            }
        }
    }

    post {
        always {
            echo 'Archiving test results...'
            dir('selenium-maven') {
                junit 'target/surefire-reports/*.xml'
            }
        }
    }
}

pipeline {
    agent any

    tools {
            jdk 'jdk1.7'
        }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Test') {
            steps {
                bat 'mvn test'
            }
        }

        stage('Package') {
            steps {
                bat 'mvn package'
            }
        }

        stage('Deploy') {
            steps {
                bat 'mvn spring-boot:run'
            }
        }
    }
}

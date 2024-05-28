pipeline {
    agent any

    tools {
            jdk 'JAVA_HOME'
        }

    environment {
            DOCKER_COMPOSE_FILE = 'docker-compose.yml'
       }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build') {
                    steps {

                        bat 'mvn clean install'
                    }
        }



        stage('Test') {
            steps {
                bat 'mvn test'
            }
        }

         stage('Deploy with Docker Compose') {
                    steps {
                        script {
                            bat """
                                docker-compose -f ${DOCKER_COMPOSE_FILE} down
                                docker-compose -f ${DOCKER_COMPOSE_FILE} up --build -d
                            """
                        }
                    }
         }


    }
}

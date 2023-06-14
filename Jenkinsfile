pipeline {
    agent any

    stages {
        stage('Clone repository') {
            steps {
                checkout([$class: 'GitSCM', branches: [[name: 'your-branch-name']], userRemoteConfigs: [[url: 'https://github.com/your-repo.git']]])
            }
        }
        
        stage('Build microservice') {
            steps {
                sh 'mvn clean package' // Assuming Maven is used for building
            }
        }
        
        stage('Build Docker image') {
            steps {
                sh 'docker build -t your-image-name .'
            }
        }
        
        stage('Push Docker image') {
            steps {
                withCredentials([usernamePassword(credentialsId: 'your-docker-credentials-id', usernameVariable: 'DOCKER_USERNAME', passwordVariable: 'DOCKER_PASSWORD')]) {
                    sh 'docker login -u $DOCKER_USERNAME -p $DOCKER_PASSWORD'
                    sh 'docker push your-image-name'
                }
            }
        }
    }
}

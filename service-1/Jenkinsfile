pipeline {
    agent any

    stages {
        stage('Clone repository') {
            steps {
                checkout([$class: 'GitSCM', branches: [[name: 'feature']], userRemoteConfigs: [[url: 'https://github.com/charan-git-official/miniature-spork-1.git']]])
            }
        }
        
        stage('Build microservice') {
            steps {
                bat 'mvn clean package -X' // Assuming Maven is used for building
            }
        }
        
        stage('Build Docker image') {
            steps {
                bat 'docker build -t service-1 .'
            }
        }
        
        stage('Push Docker image') {
            steps {
                withCredentials([usernamePassword(credentialsId: 'docker-creds', usernameVariable: 'sricharanp', passwordVariable: '14KT1a@0371')]) {
                    bat 'docker login -u $sricharanp -p $14KT1a@0371'
                    bat 'docker push service-1'
                }
            }
        }
    }
}

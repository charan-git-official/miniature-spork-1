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
                sh 'mvn clean package' // Assuming Maven is used for building
            }
        }
        
        stage('Build Docker image') {
            steps {
                sh 'docker build -t service-1 .'
            }
        }
        
        stage('Push Docker image') {
            steps {
                withCredentials([usernamePassword(credentialsId: 'docker-creds', usernameVariable: 'sricharanp', passwordVariable: '14KT1a@0371')]) {
                    sh 'docker login -u $sricharanp -p $14KT1a@0371'
                    sh 'docker push service-1'
                }
            }
        }
    }
}

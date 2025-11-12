pipeline {
    agent any

    environment {
        IMAGE_NAME = "springboot-app"
        IMAGE_TAG = "v1"
        DEPLOYMENT_FILE = "deployment.yaml"
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main',
                    url: 'https://github.com/manasa54/SpringBoot-K8s',
                    credentialsId: 'github-creds'
            }
        }

    stage('Build JAR') {
                steps {
                sh 'chmod +x gradlew'
                    sh './gradlew clean build'
                }
            }

        stage('Build Docker Image') {
            steps {
                sh "docker build -t ${IMAGE_NAME}:${IMAGE_TAG} ."
            }
        }

        stage('Deploy to Kubernetes') {
            steps {
                sh "kubectl apply -f ${DEPLOYMENT_FILE}"
            }
        }
    }

    post {
        success {
            echo "Deployment successful!"
        }
        failure {
            echo "Pipeline failed!"
        }
    }
}
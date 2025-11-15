pipeline {
  agent any

  environment {
    IMAGE_NAME = "epms-image"
    CONTAINER_NAME = "epms-container"
  }

  stages {
    stage('Checkout') {
      steps {
        checkout scm
      }
    }

    stage('Build') {
      steps {
        script {
          if (isUnix()) {
            sh 'mvn -B -DskipTests package'
            sh "docker build -t ${IMAGE_NAME}:latest ."
          } else {
            // Windows (use bat)
            bat 'mvn -B -DskipTests package'
            bat "docker build -t %IMAGE_NAME%:latest ."
          }
        }
      }
    }

    stage('Run Container') {
      steps {
        script {
          if (isUnix()) {
            sh "docker rm -f ${CONTAINER_NAME} || true"
            sh "docker run -d --name ${CONTAINER_NAME} -p 8200:8200 ${IMAGE_NAME}:latest"
          } else {
            bat "docker rm -f ${CONTAINER_NAME} || exit 0"
            bat "docker run -d --name ${CONTAINER_NAME} -p 8200:8200 ${IMAGE_NAME}:latest"
          }
        }
      }
    }
  }

  post {
    success { echo "Pipeline completed successfully" }
    failure { echo "Pipeline failed" }
  }
}

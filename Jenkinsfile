pipeline {
  agent any

  environment {
    IMAGE_NAME = "epms-image"
    CONTAINER_NAME = "epms-container"
    DOCKER_REG = ""   // optional: dockerhub/org if you push to registry
  }

  stages {
    stage('Checkout') {
      steps {
        checkout scm
      }
    }

    stage('Build') {
      steps {
        // Use maven to build; if using maven wrapper, change to './mvnw'
        sh 'mvn -B -DskipTests package'
        // Build docker image
        sh "docker build -t ${IMAGE_NAME}:latest ."
      }
    }

    stage('Run Container') {
      steps {
        // stop + remove old container safely
        sh "docker rm -f ${CONTAINER_NAME} || true"
        // run new container mapping host 8200 -> container 8200
        sh "docker run -d --name ${CONTAINER_NAME} -p 8200:8200 ${IMAGE_NAME}:latest"
      }
    }
  }

  post {
    success {
      echo "Pipeline completed successfully"
    }
    failure {
      echo "Pipeline failed"
    }
  }
}

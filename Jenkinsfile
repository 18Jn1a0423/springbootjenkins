pipeline {
    agent any
    tools {
        maven 'Maven 3.9.2'
    }
    stages {
         stage('Git Clone') {
             steps {
		     checkout([$class: 'GitSCM', branches: [[name: '*/main']], userRemoteConfigs: [[url: 'https://github.com/18Jn1a0423/springbootjenkins.git']]])

             } 
         }
         stage('Build Maven') {
             steps {
                 bat 'mvn clean install'
             }
         }   
         stage('Image Build') {
            steps {
                script {
                    def imageExists = bat(script: 'docker images -q spring-boot-jenkins', returnStdout: true).trim()
                    if (imageExists == '') {
                        bat 'docker stop spring-boot-jenkins'
                        bat 'docker rm -f spring-boot-jenkins'
                        bat 'docker rmi -f spring-boot-jenkins'
                    }
                    bat 'docker build -t spring-boot-jenkins .'
                }
            }
        }
        stage('Run the container') {
            steps {
                script {
                    def containerExists = bat(script: 'docker ps -a -q -f name=spring-boot-jenkins', returnStatus: true)
                    if (containerExists == 0) {
                        // bat 'docker stop springboot-jenkins'
                        bat 'docker rm -f spring-boot-jenkins'
                    }
                    bat 'docker run -d -p 8586:8080 --name spring-boot-jenkins spring-boot-jenkins'
                }
            }
        }

	   
}
       
 }
    

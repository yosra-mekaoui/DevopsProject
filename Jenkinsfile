pipeline {
    agent any


    stages {
        stage('Git') {
            steps {
                echo 'Getting Project From Git'
                git branch: 'OussamaGhannay', url: 'https://github.com/yosra-mekaoui/DevopsProject.git'
            }
        }

        stage('Clean') {
            steps {
                // Execute 'mvn clean' command
                sh "mvn clean "
            }
        }
        stage('Compile') {
            steps {
                // Execute 'mvn compile' command
                sh 'mvn compile'
            }
        }

      stage('Mock and JUnit Tests') {
             steps{

                 // tests
                 sh "mvn test "
             }
      }

       stage('Code Quality Check via SonarQube') {
                  steps{

                   		sh " mvn clean verify sonar:sonar -Dsonar.projectKey=DevopsProject -Dsonar.projectName='DevopsProject' -Dsonar.host.url=http://192.168.33.10:9000 -Dsonar.token=squ_33f99e3d4ce0aad8edfb16672f9b601ca5f4858a"

                  }
              }




















    }
}
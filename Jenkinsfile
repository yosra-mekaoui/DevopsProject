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

      stage('Unit Tests') {
             steps{

                 // tests
                 sh "mvn test "
             }
      }


















    }
}
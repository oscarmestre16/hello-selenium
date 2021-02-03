pipeline {
    agents any

    stages {
        stage('Test') {
            steps{
                withGradle{
                    sh './gradlew clean test'
                }
            } 
        }  
        stage('Build') {
            steps {
                withGradle{
                    sh './gradlew assemble'
                }
            }
        }
    }
}

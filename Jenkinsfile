pipeline {
    agent any

    tools {
            maven 'Maven 3.3.9'
            jdk 'jdk8'
        }

    stages {
        stage ('Initialize') {
            steps {
                sh '''
                    echo "PATH = ${PATH}"
                    echo "M2_HOME = ${M2_HOME}"
                    echo "JAVA_HOME = ${JAVA_HOME}"
                '''
            }
        }
        stage('Build') {
            steps {
                echo 'Building...'
                sh '''
                    ls -la ${JAVA_HOME}/bin/java
                    ${JAVA_HOME}/bin/java -version
                    mvn clean package
                '''
            }
        }
        stage('Test') {
            steps {
                sh 'mvn clean verify install'
            }
            post {
                success {
                    junit 'src/wildfly-rest/target/surefire-reports/**/*.xml'
                }
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying....'
            }
        }
    }
}

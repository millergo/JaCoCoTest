pipeline {
  agent {
    label 'master'
  }
  stages {
    stage('Build') {
      steps {
        git 'git@github.com:millergo/JaCoCoTest.git'
        sh 'mvn -Dmaven.test.failure.ignore=true clean package'
      }
    }

    stage('Test') {
      steps {
        sh 'mvn clean test'
      }
    }

    stage('Deploy') {
      steps {
        sh 'echo \'mock depooy\''
      }
    }

  }
  tools {
    maven 'Maven363'
    jdk 'JDK1.8'
  }
}
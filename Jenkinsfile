ansiColor('xterm') {
    node {
        stage("checkout") {
            checkout scm
        }
        stage("unit-testing") {
            sh "sbt test"
            junit 'target/test-reports/*'
        }
        stage('Deploy') {
            sh "echo 'Would be deploying here'"
        }
    }
}

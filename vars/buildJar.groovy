#!/user/bin/env groovy

def call(String branchName) {
    echo "building the application for $branchName"
    sh 'mvn package'
}
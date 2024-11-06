#!/user/bin/env groovy
package com.example


class Docker {

    def script

    Docker(script){
        this.script = script
    }

    def dockerBuildImage(String imageName){
        script.echo "building docker image"
        script.sh "docker build -t '${script.imageName}' ."
    }

    def loginDocker() {
        script.withCredentials([script.usernamePassword(credentialsId: 'docker-hub', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
            script.sh "echo '${script.PASS}' | docker login -u '${script.USER}' --password-stdin"
        }
    }

    def pushDocker(String Image) {
        script.sh "docker push '${script.imageName}'"
    }
}

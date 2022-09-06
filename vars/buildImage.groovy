#!/usr/bin/env groovy
def call(String IMAGE_NAME){ // same for all the definitions
    echo "I am building the image for branch $BRANCH_NAME for image $IMAGE_NAME"
    withCredentials([credentialId:"dockerhub-id", passwordVariable:"PASS", usernameVariable:"USER"]) { 
        sh "docker build . -t $IMAGE_NAME"
        echo "$PASS |  docker login -u $USER --password-stdin"
        sh "docker push $IMAGE_NAME"
    }
}
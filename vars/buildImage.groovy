#!/usr/bin/env groovy
def call(){ // same for all the definitions
    echo "I am building the image"
    withCredential([credentialId:"dockerhub-credent", passwordVariable:"PASS", usernameVariable:"USER"]) { 
        docker build . -t IMAGE_NAME 
        echo "$PASS |  docker login -u $USER --password-stdin"
        docker push IMAGE_NAME
    }
}
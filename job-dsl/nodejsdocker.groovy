job('NodeJS-Docker-Example') {
    scm {
        git('https://github.com/maziz00/nodejs-docker.git') {  node -> // is hudson.plugins.git.GitSCM
            node / gitConfigName('Maziz DSL')
            node / gitConfigEmail('maziz@jenkins-academy.io')
        }
    }
    triggers {
        scm('H/5 * * * *')
    }
    wrappers {
        nodejs('nodejs-7.10') // this is the name of the NodeJS installation in 
                         // Manage Jenkins -> Configure Tools -> NodeJS Installations -> Name
    }
    steps {
        dockerBuildAndPublish {
            repositoryName('mohaziz00/docker-nodejs')
            tag('${GIT_REVISION,length=9}')
            registryCredentials('dockerhub')
            forcePull(false)
            forceTag(false)
            createFingerprints(false)
            skipDecorate()
        }
    }
}

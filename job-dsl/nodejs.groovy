job('NodeJS example') {
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
        shell("npm install")
    }
}

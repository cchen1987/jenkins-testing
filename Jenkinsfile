// CODE_CHANGES = getGitChanges()
pipeline {

    agent any
    tools {
        maven 'Maven'
    }
    parameters {
        string(name: 'VERSION_STRING', defaultValue: '', description: 'version to deploy on prod')
        choice(name: 'VERSION_CHOICE', choices: ['1.1.0', '1.2.0', '1.3.0'], description: '')
        booleanParam(name: 'executeTests', defaultValue: true, description: '')
    }
    environment {
        NEW_VERSION = '1.3.0'
        SERVER_CREDENTIALS = credentials('dev') // need Credentials Binging plugin
    }
    stages {

        stage("build") {
            // when {
            //     expression {
            //         BRANCH_NAME == 'dev' && CODE_CHANGES == true
            //     }
            // }
            steps {
                echo 'building the application...'
                echo "building version ${NEW_VERSION}"
            }
        }
        
        stage("test") {
            when { // define when the stage has to be executed
                expression {
                    params.executeTests == true // Or it can be params.executeTests
                }
            }
            steps {
                echo 'testing the application...'
                mvn --version
            }
        }

        
        stage("deploy") {

            steps {
                echo 'deploying the application...'
                echo "deploying with ${SERVER_CREDENTIALS}"

                withCredentials([
                    usernamePassword(credentialsId: 'dev', usernameVariable: 'USER', passwordVariable: 'PWD')
                ]) {
                    echo "username ${USER}"
                    echo "password ${PWD}"
                }

                echo "deploying version string ${params.VERSION_STRING}"
                echo "deploying version choice ${params.VERSION_CHOICE}"
            }
        }
    }

    // post {
    //     always {

    //     }

    //     failure {

    //     }
    // }
}

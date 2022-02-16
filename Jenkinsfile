// CODE_CHANGES = getGitChanges()
pipeline {

    agent any
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
            // when { // define when the stage has to be executed
            //     expression {
            //         BRANCH_NAME == 'dev'
            //     }
            // }
            steps {
                echo 'testing the application...'
            }
        }

        
        stage("deploy") {

            steps {
                echo 'deploying the application...'
                echo "deploying with ${SERVER_CREDENTIALS}"

                withCredentials([
                    usernamePassword(credentialsId: 'dev', usernameVariable: 'USER', passwordVariable: 'PASSWORD')
                ]) {
                    echo "user: " + $USER + "password: " + $PASSWORD
                }
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

def buildApp() {
    echo 'building the application...'
}

def testApp() {
    echo 'testing the application...'
}

def deployApp() {
    echo 'deploying the application...'
    echo "deploying with ${SERVER_CREDENTIALS}"
    echo "deploying version string ${params.VERSION_STRING}"
    echo "deploying version choice ${params.VERSION_CHOICE}"
}

return this
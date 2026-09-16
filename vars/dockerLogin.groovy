def call(String registry, String credentialsId) {
    withCredentials([
        usernamePassword(
            credentialsId: credentialsId,
            usernameVariable: 'REGISTRY_USERNAME',
            passwordVariable: 'REGISTRY_TOKEN'
        )
    ]) {
        sh """
            echo "\$REGISTRY_TOKEN" | docker login ${registry} \
                -u "\$REGISTRY_USERNAME" \
                --password-stdin
        """
    }
}

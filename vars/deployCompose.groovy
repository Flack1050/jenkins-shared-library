def call(
    String credentialsId,
    String user,
    String host,
    String projectPath,
    String imageTag
) {
    sshagent([credentialsId]) {
        sh """
            ssh -o StrictHostKeyChecking=no \
                ${user}@${host} \
                "cd ${projectPath} && \
                 sed -i 's/^IMAGE_TAG=.*/IMAGE_TAG=${imageTag}/' .env && \
                 docker compose pull && \
                 docker compose up -d"
        """
    }
}

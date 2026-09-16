def call(
    String credentialsId,
    String user,
    String host,
    String projectPath
) {
    sshagent([credentialsId]) {
        sh """
            ssh -o StrictHostKeyChecking=no \
                ${user}@${host} \
                "cd ${projectPath} && docker compose ps"
        """
    }
}

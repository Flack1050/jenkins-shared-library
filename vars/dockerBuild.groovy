def call(String image, String tag, String context) {
    sh """
        docker build \
            -t ${image}:${tag} \
            ${context}
    """
}

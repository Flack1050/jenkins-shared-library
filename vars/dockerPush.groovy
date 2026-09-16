def call(String image, String tag) {
    sh """
        docker push ${image}:${tag}
    """
}

class Greeting {
    private val platform = getPlatform()

    fun greet(): String {
        return "Hello 123, ${platform.name}!"
    }
}
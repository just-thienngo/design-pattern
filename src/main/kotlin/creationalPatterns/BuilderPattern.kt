package creationalPatterns

class UserProfile(
    val username: String,
    val email: String,
    val age: Int?,
    val address: String?,
    val bio: String?
) {
    // Dùng Builder Pattern với Kotlin style
    class Builder(
        private val username: String,
        private val email: String
    ) {
        private var age: Int? = null
        private var address: String? = null
        private var bio: String? = null

        fun setAge(age: Int) = apply { this.age = age }
        fun setAddress(address: String) = apply { this.address = address }
        fun setBio(bio: String) = apply { this.bio = bio }

        fun build() = UserProfile(username, email, age, address, bio)
    }

    override fun toString(): String {
        return "UserProfile(username='$username', email='$email', age=$age, address='$address', bio='$bio')"
    }
}


fun main()
{
        val user = UserProfile.Builder("kotlin_dev", "dev@kotlin.org")
            .setAge(30)
            .setAddress("Ho Chi Minh")
            .setBio("0923")
            .build()

    println(user)


}
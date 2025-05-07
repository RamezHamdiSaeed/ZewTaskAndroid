package com.example.zewtaskandroid.data.model

data class MenuSection(
    val id: String,
    val name: String,
    val items: List<MenuItem>
)

data class MenuItem(
    val id: String,
    val name: String,
    val photoCredit: String,
    val price: Int,
    val restrictions: List<String>,
    val description: String
) {
    val mainImage: String
        get() = name.replace(" ", "_").lowercase()

    val thumbnailImage: String
        get() = "${mainImage}_thumb"

    companion object {
        @JvmStatic
        val example = MenuItem(
            id = "1",
            name = "Maple French Toast",
            photoCredit = "Joseph Gonzalez",
            price = 6,
            restrictions = listOf("G", "V"),
            description = "Sweet, fluffy, and served piping hot, our French toast is flown in fresh every day from Maple City, Canada, which is where all maple syrup in the world comes from. And if you believe that, we have some land to sell you…"
        )
    }
}
package com.example.sleep2.tools

import com.google.gson.annotations.SerializedName

sealed class DataClasses{

    data class BookModel(
        val items: List<Item>
    ):DataClasses()

    data class VolumeInfo(
        val authors: List<String?>,
        val averageRating: Double,
        val imageLinks: ImageLinks,
        val maturityRating: String,
        val pageCount: Int?,
        val publishedDate: String,
        val publisher: String,
        val ratingsCount: Int,
        val subtitle: String,
        val title: String?,
        val previewLink : String?,
    ):DataClasses()

    data class ImageLinks(
        val smallThumbnail: String,
        val thumbnail: String?
    )

    data class Item(
        val etag: String,
        val id: String,
        val kind: String,
        val volumeInfo: VolumeInfo
    ):DataClasses()

    data class Joke(@SerializedName("id") val id : Int,
                    @SerializedName("type") val type : String,
                    @SerializedName("setup") val setup : String,
                    @SerializedName("punchline") val punchline : String):DataClasses()

}

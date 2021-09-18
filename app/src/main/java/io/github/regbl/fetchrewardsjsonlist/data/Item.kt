package io.github.regbl.fetchrewardsjsonlist.data

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Item(
    @Expose
    @SerializedName("id")
    val id: Int,
    @Expose
    @SerializedName("listId")
    val listId: Int,
    @Expose
    @SerializedName("name")
    val name: String
    )

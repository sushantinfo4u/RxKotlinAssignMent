package com.siliconstack.rxkotlinassignment.data.model


import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class MovieData(
    @SerializedName("genre")
    val genre: String?,
    @SerializedName("id")
    val id: Int,
    @SerializedName("poster")
    val poster: String?,
    @SerializedName("title")
    val title: String?,
    @SerializedName("year")
    val year: String?
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readInt(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    ){}

    override fun writeToParcel(parcel: Parcel, p1: Int) {
        parcel.writeString(genre)
        parcel.writeInt(id)
        parcel.writeString(poster)
        parcel.writeString(title)
        parcel.writeString(year)
    }

    override fun describeContents(): Int {
        TODO("Not yet implemented")
    }

    companion object CREATOR : Parcelable.Creator<MovieData> {
        override fun createFromParcel(parcel: Parcel): MovieData {
            return MovieData(parcel)
        }

        override fun newArray(size: Int): Array<MovieData?> {
            return arrayOfNulls(size)
        }
    }
}
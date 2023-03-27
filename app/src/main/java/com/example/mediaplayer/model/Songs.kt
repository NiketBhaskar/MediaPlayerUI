package com.example.mediaplayer.model

import android.media.Image
import android.os.Parcel
import android.os.Parcelable
import android.widget.ImageView

data class Songs(var title :String? = null, var subTitle : String? = null, var length:Long? = null, var imageView: Int? = null)

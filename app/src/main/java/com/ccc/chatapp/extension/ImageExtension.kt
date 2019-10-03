package com.ccc.chatapp.extension

import android.widget.ImageView
import com.ccc.chatapp.R
import com.squareup.picasso.Picasso

fun ImageView.setImageUser(url:String){
    Picasso.get()
        .load(url)
        .error(R.drawable.default_avatar)
        .resize(this.width, this.height)
        .into(this)
}
package net.amazingdomain.sample.myapplication.ui.common.helper

import android.content.res.Resources

//https://stackoverflow.com/questions/22916490/what-does-displaymetrics-scaleddensity-actually-return-in-android
fun Int.dpToPx(): Int = (this * Resources.getSystem().displayMetrics.density).toInt()

fun Int.spToPx(): Float = (this * Resources.getSystem().displayMetrics.scaledDensity)
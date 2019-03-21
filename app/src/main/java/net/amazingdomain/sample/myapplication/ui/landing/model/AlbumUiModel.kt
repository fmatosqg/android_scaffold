package net.amazingdomain.sample.myapplication.ui.landing.model

import net.amazingdomain.sample.myapplication.domain.landing.model.Album

data class AlbumUiModel(val niceName: String,
                        val thumbnailUrl: String)



fun Album.convertToUiModel(): AlbumUiModel {
    return AlbumUiModel(niceName = niceName,
            thumbnailUrl = thumbnail)
}
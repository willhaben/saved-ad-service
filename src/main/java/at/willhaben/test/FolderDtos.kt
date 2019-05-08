package at.willhaben.test

data class CreateFolderDto(val folderName: String)

data class CreateAdvertFolderItemDto(val adId: Long, val title: String,
                                     val description: String, val price: Long, val location: String,
                                     val imageUrl: String) {
    fun toAdvertFolderItem(folderId: Long): AdvertFolderItem {
        return AdvertFolderItem(null, this.adId, this.title, this.description, this.price, this.location,
                this.imageUrl, folderId)
    }
}
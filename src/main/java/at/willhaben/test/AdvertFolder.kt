package at.willhaben.test

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table

interface AdvertFolder {
    val folderId: Long?
    val userId: Long
    val folderName: String
}

@Table("advert_folder")
data class AdvertFolderOnly(@Id override val folderId: Long?, override val userId: Long, override val folderName: String) : AdvertFolder

data class AdvertFolderWithItems(override val folderId: Long?, override val userId: Long,override val folderName: String,
                                 val advertFolderItems: List<AdvertFolderItem>) : AdvertFolder

data class AdvertFolderItem(@Id val itemId: Long?, val adId: Long, val title: String,
                            val description: String, val price: Long, val location: String,
                            val imageUrl: String, val folderId: Long)




package at.willhaben.test

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/saved-ads")
class SavedAdController
@Autowired constructor(private val itemRepository: AdvertFolderItemRepository, private val folderRepository: AdvertFolderRepository) {


    @GetMapping("/{userId}")
    fun getDefaultFolder(@PathVariable userId: Long): List<AdvertFolder> {
        return return folderRepository.findByUserId(userId)
    }

    @PostMapping("/{userId}")
    fun createFolder(@PathVariable userId: Long, @RequestBody folder: CreateFolderDto): AdvertFolder {
        return folderRepository.save(AdvertFolderOnly(null, userId, folder.folderName))
    }

    @GetMapping("/{userId}/{folderId}")
    fun getFolder(@PathVariable userId: Long, @PathVariable folderId: Long): AdvertFolderWithItems {
        val findByIdAndUserId = folderRepository.findByIdAndUserId(folderId, userId)
        return findByIdAndUserId
                .map { folder -> AdvertFolderWithItems(folder.folderId, folder.userId, folder.folderName, itemRepository.findByFolderId(folder.userId)) }
                .orElseThrow()
    }

    @PostMapping("/{userId}/{folderId}")
    fun createItem(@PathVariable userId: Long, @PathVariable folderId: Long, @RequestBody item: CreateAdvertFolderItemDto): AdvertFolderItem {
        return itemRepository.save(item.toAdvertFolderItem())
    }

}

data class CreateFolderDto(val folderName: String)

data class CreateAdvertFolderItemDto(val adId: Long, val title: String,
                                     val description: String, val price: Long, val location: String,
                                     val imageUrl: String, val folderId: Long) {
    fun toAdvertFolderItem(): AdvertFolderItem {
        return AdvertFolderItem(null, this.adId, this.title, this.description, this.price, this.location,
                this.imageUrl, this.folderId)
    }
}

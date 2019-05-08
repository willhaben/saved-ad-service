package at.willhaben.test
import org.springframework.data.jdbc.repository.query.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.Repository


interface AdvertFolderItemRepository : Repository<AdvertFolderItem, Long> {

    @Query("select * from advert_folder_item where folder_id = :folderId")
    fun findByFolderId(folderId: Long): List<AdvertFolderItem>

    fun save(folder: AdvertFolderItem): AdvertFolderItem

}
package at.willhaben.test

import org.springframework.data.jdbc.repository.query.Modifying
import org.springframework.data.jdbc.repository.query.Query
import org.springframework.data.repository.Repository
import java.util.*


interface AdvertFolderRepository : Repository<AdvertFolder, Long> {

    @Query("select * from advert_folder where user_id = :userId")
    fun findByUserId(userId: Long): List<AdvertFolderOnly>

    @Query("select * from advert_folder where folder_id = :folderId and user_id = :userId")
    fun findByIdAndUserId(folderId: Long, userId: Long): Optional<AdvertFolderOnly>

    fun save(folder: AdvertFolder): AdvertFolder
}


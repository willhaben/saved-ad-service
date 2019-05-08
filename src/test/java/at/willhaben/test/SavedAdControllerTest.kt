package at.willhaben.test

import com.fasterxml.jackson.databind.ObjectMapper
import org.hamcrest.Matchers.containsString
import org.hamcrest.core.Is
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultHandlers.print

import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.*


@RunWith(SpringRunner::class)
@SpringBootTest
@AutoConfigureMockMvc
class SavedAdControllerTest {

    @Autowired
    lateinit var mockMvc: MockMvc

    @Autowired
    private lateinit var mapper:ObjectMapper

    @Test
    fun testGetAllFromUser() {
        this.mockMvc.perform(get("/saved-ads/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].userId", Is.`is`(1)));
    }

    @Test
    fun testGetOne() {
        this.mockMvc.perform(get("/saved-ads/1/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.userId", Is.`is`(1)))
                .andExpect(jsonPath("$.folderId", Is.`is`(1)))
                .andExpect(jsonPath("$.folderName", Is.`is`("name1")));
    }

    @Test
    fun createNewList() {

        this.mockMvc.perform(post("/saved-ads/1")
                .content(CreateFolderDto("testfolder").toJson())
                .header("Content-Type","application/json")
        )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.userId", Is.`is`(1)))
                .andExpect(jsonPath("$.folderName", Is.`is`("testfolder")))
    }

    @Test
    fun createNewListItem() {

        this.mockMvc.perform(post("/saved-ads/1/1")
                .content(CreateAdvertFolderItemDto(123454,"title 12","desc 34", 999,"Wien","http://bla").toJson())
                .header("Content-Type","application/json")
        )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.adId", Is.`is`(123454)))
                .andExpect(jsonPath("$.price", Is.`is`(999)))
                .andExpect(jsonPath("$.folderId", Is.`is`(1)))
    }

    fun CreateFolderDto.toJson():String {
        return mapper.writer().writeValueAsString(this)
    }

    fun CreateAdvertFolderItemDto.toJson():String {
        return mapper.writer().writeValueAsString(this)
    }

}
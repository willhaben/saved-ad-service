package at.willhaben.test

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories

@SpringBootApplication
@EnableJdbcRepositories
open class Main

fun main(args: Array<String>) {
    runApplication<Main>(*args)
}



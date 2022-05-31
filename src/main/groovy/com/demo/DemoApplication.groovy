package com.demo

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class DemoApplication {
	
	static void main(String[] args) {
		
		
		SpringApplication.run(DemoApplication, args)
		
		println "Hey Application Started !!"
	
	}

}









/*
 * 1. make a boot project with groov language
 * 2. add dependencies spring web, jpa, my-sql
 * 3. set properties file (update) and xml file
 * 4. set config build path and add groovy in source
 * 4. convert to groovy project (project > configure > 3rd last)
 * 5. make a Dao interface that implements JPARepository<Entity, primaryKey_datatype>
 * 6. All other steps are remain same
 * 7. make service, controller, entities package and their classes
 * 8. Use Rest Services according the mapping
 * 9. Use HttpSession for fectching data from URL
 * 10. Use Groovy database connection for database related tasks
 * 11. For Pagination take care of import statement
 * 12. Pagination use Pageable, PageRequest.of(offset, pageSize) and return statement  
 * 
 * 
 * - Authentication use Queries or JPA Repository
 */

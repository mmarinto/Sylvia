package cat.passerine.sylvia;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;

//import io.restassured.RestAssured;
//import io.restassured.response.Response;

import cat.passerine.sylvia.model.Food;
/**
 * Test class
 * @author mmarin
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = { SylviaApplication.class }, webEnvironment 
= WebEnvironment.DEFINED_PORT)
public class SylviaApplicationTests {
	
    private static final String API_ROOT = "http://localhost:8081/api/food";

	@Test
	public void contextLoads() {
	}

	
    private Food createRandomBook() {
    	Food food = new Food();
    	food.setName("Enciam Iceberg");
    	food.setKcal(new Double(13.9));
        return food;
    }
    
//    private String createBookAsUri(Food food) {
//        Response response = RestAssured.given()
//          .contentType(MediaType.APPLICATION_JSON_VALUE)
//          .body(food)
//          .post(API_ROOT);
//        return API_ROOT + "/" + response.jsonPath().get("id");
//    }
}

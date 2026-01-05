package RestAssuredTestCases;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class PetstoreTests {

    private static final String BASE_URL = "https://petstore.swagger.io/v2";
    private static long petId=33333;

    @BeforeClass
    public void setup() {
        RestAssured.baseURI = BASE_URL;
    }

    @Test(priority = 1)
    public void addPet() {
        String petJson = "{\r\n"
        		+ "  \"id\"" + ":" + petId + ","
        		+ "  \"category\": {\r\n"
        		+ "    \"id\" : 1,\r\n"
        		+ "    \"name\": \"Cat\"\r\n"
        		+ "  },\r\n"
        		+ "  \"name\": \"Feline\",\r\n"
        		+ "  \"photoUrls\": [\r\n"
        		+ "    \"string\"\r\n"
        		+ "  ],\r\n"
        		+ "  \"tags\": [\r\n"
        		+ "    {\r\n"
        		+ "      \"id\": 0,\r\n"
        		+ "      \"name\": \"string\"\r\n"
        		+ "    }\r\n"
        		+ "  ],\r\n"
        		+ "  \"status\": \"available\"\r\n"
        		+ "}";
        System.out.println(petJson);
        given()
            .contentType(ContentType.JSON)
            .body(petJson)
        .when()
            .post("/pet")
        .then() //This is a validation step
            .statusCode(200)
            .body("id", equalTo((int) petId))
            .body("name", equalTo("Feline"))
            .body("status", equalTo("available"));
    }

    @Test(priority = 2)
    public void getPet() {
        given()
            .pathParam("petId", petId)
        .when()
            .get("/pet/{petId}")
        .then()
            .statusCode(200)
            .body("id", equalTo((int) petId))
            .body("name", equalTo("Feline"));
        System.out.println("Pet with ID " + petId + " retrieved successfully.");
    }
    
    /*
    @Test
    public void updatePet() {

        	String payload = """
    	    {
    	      "id": 7777,
    	      "name": "TommyUpdated",
    	      "status": "sold"
    	    }
    	    """;

        given()
            .contentType("application/json")
            .body(payload)
        .when()
            .put("/pet")
        .then()
            .statusCode(200)
            .body("name", equalTo("TommyUpdated"))
            .body("status", equalTo("sold"))
            .log().all();
    } 
    */   
/*
    @Test(priority = 3)
    public void deletePet() {
        given()
            .pathParam("petId", petId)
        .when()
            .delete("/pet/{petId}")
        .then()
            .statusCode(200)
            .body("message", equalTo(String.valueOf(petId)));
    }

    
      @Test(priority = 4)
     
    public void verifyPetDeleted() {
        given()
            .pathParam("petId", petId)
        .when()
            .get("/pet/{petId}")
        .then()
            .statusCode(404);
    }
    */
}

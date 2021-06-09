package trainingxyz;

import io.restassured.response.ValidatableResponse;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class ApiTests {

    @Test
    public void getCategories(){
        String endpoint = "http://localhost:80/api_testing/product/read.php";
        ValidatableResponse response = given().when().get(endpoint).then();
        response.log().body();
    }

    @Test
    public void getProduct(){
        String endpoint = "http://localhost:80/api_testing/product/read_one.php";
        ValidatableResponse response =
                given()
                .queryParam("id", 1000)
                .when()
                .get(endpoint)
                .then();
        response.log().body();
    }

    // POST request
    @Test
    public void createProduct(){
        String endpoint = "http://localhost:80/api_testing/product/create.php";
        String body = "{\"name\":\"Water Bottle\"\"name\":\"Water Bottle\",\"price\":12,\"description\":\"The Product is really great\",\"category_id\":3}";

        ValidatableResponse response =
                given()
                .body(body)
                .when()
                .post(endpoint)
                .then();

        response.log().body();

    }

    // PUT request
    @Test
    public void updateProduct(){
        String endpoint = "http://localhost:80/api_testing/product/update.php";
        String body = "{\"id\": 1000,\"name\":\"Water Bottle\",\"price\":15,\"description\":\"Blue Water Bottle\",\"category_id\":3}";

        ValidatableResponse response =
                given()
                        .body(body)
                        .when()
                        .put(endpoint)
                        .then();

        response.log().body();
    }

    // DELETE Request
    @Test
    public void deleteProduct(){
        String endpoint = "http://localhost:80/api_testing/product/delete.php";
        String body = "{\"id\": 1000}";

        ValidatableResponse response =
                given()
                        .body(body)
                        .when()
                        .delete(endpoint)
                        .then();

        response.log().body();
    }
}

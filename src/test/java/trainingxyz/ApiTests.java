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

    @Test
    public void createProduct(){
        String endpoint = "http://localhost:80/api_testing/product/create.php";
        String body = "{\"name\":\"Water Bottle\",\"price\":12,\"description\":\"The Product is really great\",\"category_id\":3}";

        ValidatableResponse response =
                given()
                .body(body)
                .when()
                .post(endpoint)
                .then();

        response.log().body();

    }
}

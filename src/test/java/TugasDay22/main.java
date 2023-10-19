package TugasDay22;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class main {
    @BeforeClass
    public void setup() {

        RestAssured.baseURI = "https://api.themoviedb.org/3";
    }
    @Test
    public void testGetNowPlayingMovies() {
        Response response = RestAssured.given()
                .queryParam("api_key", "26e31aa03b74995b1452ffe6e8daf585")
                .when()
                .get("/movie/now_playing");
        response.then().statusCode(200);
    }
    @Test
    public void testGetPopularMovies() {
        Response response = RestAssured.given()
                .queryParam("api_key", "26e31aa03b74995b1452ffe6e8daf585") // Ganti dengan API key Anda
                .when()
                .get("/movie/popular");
        response.then().statusCode(200);
    }
    @Test
    public void testPostMovieRating() {
        String requestBody = "{\"value\": 8.5}";
        Response response = RestAssured.given()
                .queryParam("api_key", "26e31aa03b74995b1452ffe6e8daf585")
                .body(requestBody)
                .when()
                .post("/movie/{movie_id}/rating", "968051");
        response.then().statusCode(201);
    }
}


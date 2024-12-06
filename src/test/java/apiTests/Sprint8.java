package apiTests;
import static io.restassured.RestAssured.given;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class Sprint8 {

    RequestSpecification requestSpec;

    @BeforeClass
    public void AuthSetup() {
        Response response = given()
                .params("email", "chelsea.laurenson@testpro.io", "password", "Koelapp1!!")
                .post("https://qa.koel.app/api/me").then().statusCode(200).extract().response();
        String accessToken = response.path("token");
        String Authorization = "Bearer " + accessToken;
        RequestSpecBuilder builder = new RequestSpecBuilder();
        builder.addHeader("Authorization", Authorization);
        requestSpec = builder.build();

    }

    @Test
    public void getRecentlyPlayed() {
        Response response = given()
                .spec(requestSpec).log().all()
                .when()
                .get("https://qa.koel.app/api/interaction/recently-played/1")
                .then().statusCode(200).extract().response();
        String responseBody = response.getBody().asString();
        System.out.println("Response body " + responseBody);
    }

    @Test
    public void playASong() {
        String songId = "0aedf0c1c02188e8b73483d1bf2eacab";
        Response response = given()
                .spec(requestSpec).log().all()
                .when()
                .get("https://qa.koel.app/play/" + songId)
                .then().statusCode(200).extract().response();
        byte[] responseBody = response.getBody().asByteArray(); //.asString();
        System.out.println("Response body " + responseBody);
    }

    @Test
    public void increasePlayCount() {
        Response response = given()
                .spec(requestSpec).log().all()
                .params("song", "0aedf0c1c02188e8b73483d1bf2eacab")
                .when()
                .post("https://qa.koel.app/api/interaction/play")
                .then().statusCode(200).extract().response();
        String responseBody = response.getBody().asString();
        System.out.println("Response body: " + responseBody);
    }



}

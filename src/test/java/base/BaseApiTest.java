package base;

import io.restassured.response.Response;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class BaseApiTest {
    public static final String ServicesUrlCollectionFilePath = "src/test/java/api_helpers/files/services_url_collection.txt";
    public static final String UrlCollectionFilePath = "src/test/java/api_helpers/files/url_collection.txt";
    public static final String EndpointsFilePath = "src/test/java/api_helpers/files/endpoints.txt";
    public static final String BaseUrlFilePath = "src/test/java/api_helpers/files/base_url.json";

    public static String getResourceAsString(String path) {
        try {
            File file = new File(path);
            return Files.readString(file.toPath(), StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Response baseRequest(String method, String body, String file, String key){
        Response response = given()
                .when()
                .body(body)
                .request(method, FileReader.getProperty(file,key))
                .then().log().all()
                .extract().response();
        return response;
    }
}

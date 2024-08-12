package tests.api.cleanuri_tests;

import api_helpers.Specifications;
import base.BaseApiTest;
import base.FileReader;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

@Tag("CleanuriNegativeTests")
public class CleanuriNegativeApiTests extends BaseApiTest {

    @Test
    @DisplayName("Вызов POST метода с пустым телом")
    public void SendingEmptyBodyUncorrectRequestTest(){
        String URL = FileReader.getProperty(ServicesUrlCollectionFilePath,"cleanUri_url");
        Specifications.installSpecification(Specifications.requestSpec(URL));
        String body = "";

        Response response = baseRequest("POST", body, EndpointsFilePath, "cleanUri_endpoint");

        JsonPath jsonPath = response.jsonPath();
        String responseText = jsonPath.getString("error");

        response.then().assertThat().body(matchesJsonSchemaInClasspath("negative_cleanuri_api_schema.json"));
        Assertions.assertEquals("API Error: URL is empty", responseText);
        response.then().assertThat().statusCode(400);
    }

    @Test
    @DisplayName("Вызов неверного метода")
    public void SendingUncorrectMethodRequestTest(){
        String URL = FileReader.getProperty(ServicesUrlCollectionFilePath,"cleanUri_url");
        Specifications.installSpecification(Specifications.requestSpec(URL));

        String body = getResourceAsString(BaseUrlFilePath)
                .replace("base_url", FileReader.getProperty(UrlCollectionFilePath, "base_url_1"));
        List<String> list = List.of("GET", "PUT", "DELETE", "PATCH", "HEAD");

        for (String i : list) {
            Response response = baseRequest(i, body, EndpointsFilePath, "cleanUri_endpoint");

            response.then().assertThat().statusCode(405);
        }
    }

    @Test
    @DisplayName("Вызов POST метода с передачей url в параметрах ")
    public void SendingUrlInParamRequestTest(){
        String URL = FileReader.getProperty(ServicesUrlCollectionFilePath,"cleanUri_url");
        Specifications.installSpecification(Specifications.requestSpec(URL));

        String param = getResourceAsString(BaseUrlFilePath)
                .replace("base_url", FileReader.getProperty(UrlCollectionFilePath, "base_url_1"));

        Response response = given()
                .param(param)
                .when()
                .request("POST", FileReader.getProperty(EndpointsFilePath, "cleanUri_endpoint"))
                .then().log().all()
                .extract().response();

        response.then().assertThat().statusCode(400);
    }

    @Test
    @DisplayName("Вызов POST метода с неверным endpoint")
    public void SendingUncorrectEndpointRequestTest(){
        String URL = FileReader.getProperty(ServicesUrlCollectionFilePath,"cleanUri_url");
        Specifications.installSpecification(Specifications.requestSpec(URL));
        String body = getResourceAsString(BaseUrlFilePath)
                .replace("base_url", FileReader.getProperty(UrlCollectionFilePath, "base_url_1"));
        Response response = baseRequest("POST", body, EndpointsFilePath, "cleanUri_uncorrect_endpoint");

        response.then().assertThat().statusCode(404);
    }
}

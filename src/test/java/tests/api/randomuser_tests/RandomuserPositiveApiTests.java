package tests.api.randomuser_tests;

import api_helpers.Specifications;
import base.BaseApiTest;
import base.FileReader;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedHashMap;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class RandomuserPositiveApiTests extends BaseApiTest {

    @Test
    @DisplayName("Вызов GET метода без параметров")
    public void SendingGetMethodWithoutParams(){
        String URL = FileReader.getProperty(ServicesUrlCollectionFilePath,"randomuser_url");
        Specifications.installSpecification(Specifications.requestSpec(URL));
        Response response = given()
                .when()
                .request("GET", FileReader.getProperty(EndpointsFilePath, "randomuser_endpoint"))
                .then().log().all()
                .extract().response();

        //response.then().assertThat().body(matchesJsonSchemaInClasspath("positive_randomuser_api_schema.json"));
        response.then().assertThat().statusCode(200);
    }

    @Test
    @DisplayName("Вызов GET метода с параметрами")
    public void SendingGetMethodWithParams(){
        String URL = FileReader.getProperty(ServicesUrlCollectionFilePath,"randomuser_url");
        Specifications.installSpecification(Specifications.requestSpec(URL));
        LinkedHashMap <String, Object> params = new LinkedHashMap<>();
        params.put("gender", "female");
        params.put("nat", "CH");
        Response response = given()
                .params(params)
                .when()
                .request("GET", FileReader.getProperty(EndpointsFilePath, "randomuser_endpoint"))
                .then().log().all()
                .extract().response();
        JsonPath jsonPath = response.jsonPath();
        ArrayList<String> result_gender = jsonPath.get("results.gender");
        ArrayList<String> result_nat = jsonPath.get("results.nat");

        //response.then().assertThat().body(matchesJsonSchemaInClasspath("positive_randomuser_api_schema.json"));
        Assertions.assertEquals("female", result_gender.get(0));
        Assertions.assertEquals("CH", result_nat.get(0));
    }
}

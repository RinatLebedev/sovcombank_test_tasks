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
import java.util.List;

import static io.restassured.RestAssured.given;

public class RandomuserNegativeApiTests extends BaseApiTest {

    @Test
    @DisplayName("Вызов неверного метода")
    public void SendingUncorrectMethodRequestTest(){
        String URL = FileReader.getProperty(ServicesUrlCollectionFilePath,"randomuser_url");
        Specifications.installSpecification(Specifications.requestSpec(URL));
        List<String> list = List.of("POST", "PUT", "DELETE", "PATCH");
        for (String i : list) {
            Response response = given()
                    .when()
                    .request(i, FileReader.getProperty(EndpointsFilePath, "randomuser_endpoint"))
                    .then().log().all()
                    .extract().response();
            response.then().assertThat().statusCode(404);
        }
    }

    @Test
    @DisplayName("Вызов GET метода в неверным значением параметра")
    public void SendingUncorrectParamValueRequestTest(){
        String URL = FileReader.getProperty(ServicesUrlCollectionFilePath,"randomuser_url");
        Specifications.installSpecification(Specifications.requestSpec(URL));
        LinkedHashMap<String, Object> params = new LinkedHashMap<>();
        params.put("gender", "femaleee");
        Response response = given()
                .params(params)
                .when()
                .request("GET", FileReader.getProperty(EndpointsFilePath, "randomuser_endpoint"))
                .then().log().all()
                .extract().response();
        JsonPath jsonPath = response.jsonPath();
        ArrayList<String> result_gender = jsonPath.get("results.gender");
        Assertions.assertTrue(result_gender.get(0).equals("male") || result_gender.get(0).equals("female"));
    }

    @Test
    @DisplayName("Проверить граничные значения для выбора длинны пароля (0, 1, 64, 65)")
    public void CheckingBoundaryValuesRequestTest(){
        String URL = FileReader.getProperty(ServicesUrlCollectionFilePath,"randomuser_url");
        Specifications.installSpecification(Specifications.requestSpec(URL));

        LinkedHashMap<String, String> params = new LinkedHashMap<>();
        params.put("password", "upper, 0");
        params.put("password", "upper, 1");
        params.put("password", "upper, 64");
        params.put("password", "upper, 65");

        for (int i = 1; i < params.size(); i++) {
            Response response = given()
                    .param(params.get(i))
                    .when()
                    .request("GET", FileReader.getProperty(EndpointsFilePath, "randomuser_endpoint"))
                    .then().log().all()
                    .extract().response();
            JsonPath jsonPath = response.jsonPath();
            ArrayList<String> pass1 = jsonPath.get("results.login.password");
            Assertions.assertTrue(1 == pass1.get(0).length() || 64 == pass1.get(0).length());
        }

        for (int i = 0; i <= params.size(); i+=3) {
            Response response = given()
                    .param(params.get(i))
                    .when()
                    .request("GET", FileReader.getProperty(EndpointsFilePath, "randomuser_endpoint"))
                    .then().log().all()
                    .extract().response();
            JsonPath jsonPath = response.jsonPath();
            ArrayList<String> pass2 = jsonPath.get("results.login.password");
            Assertions.assertTrue(0 != pass2.get(0).length() || 65 != pass2.get(0).length());
        }
    }

    @Test
    @DisplayName("Вызов GET метода с неверным endpoint")
    public void SendingUncorrectEndpointRequestTest(){
        String URL = FileReader.getProperty(ServicesUrlCollectionFilePath,"randomuser_url");
        Specifications.installSpecification(Specifications.requestSpec(URL));

        Response response = given()
                .when()
                .request("GET", FileReader.getProperty(EndpointsFilePath, "randomuser_uncorrect_endpoint"))
                .then().log().all()
                .extract().response();
        response.then().assertThat().statusCode(404);
    }
}

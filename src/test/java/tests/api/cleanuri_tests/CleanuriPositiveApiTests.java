package tests.api.cleanuri_tests;

import api_helpers.Specifications;
import base.BaseApiTest;
import base.FileReader;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

@Tag("CleanuriPositiveTests")
public class CleanuriPositiveApiTests extends BaseApiTest {

    @Test
    @DisplayName("Вызов POST метода с корретно переданными в теле запроса url")
    public void SendingCorrectRequestTest(){
        String URL = FileReader.getProperty(ServicesUrlCollectionFilePath,"cleanUri_url");
        Specifications.installSpecification(Specifications.requestSpec(URL));

        ArrayList<String> list = new ArrayList<>();
        list.add("base_url_1");
        list.add("base_url_2");
        list.add("base_url_3");

        for (String i : list) {
            String body = getResourceAsString(BaseUrlFilePath)
                    .replace("base_url", FileReader.getProperty(UrlCollectionFilePath, i));
        Response response = baseRequest("POST", body, EndpointsFilePath, "cleanUri_endpoint");

        response.then().assertThat().body(matchesJsonSchemaInClasspath("positive_cleanuri_api_schema.json"));
        response.then().assertThat().statusCode(200);
        }
    }


}

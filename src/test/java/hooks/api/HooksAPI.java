package hooks.api;

import io.cucumber.java.Before;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import utilities.Authentication;
import utilities.ConfigReader;

public class HooksAPI {

    public static RequestSpecification spec;
    public static String token;

    public static JSONObject reqBody;

    @Before (order = 0)
    public void setUpApi(){
        spec = new RequestSpecBuilder().setBaseUri(ConfigReader.getProperty("base_url")).build();
    }





}

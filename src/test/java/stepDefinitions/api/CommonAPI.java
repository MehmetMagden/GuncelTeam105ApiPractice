package stepDefinitions.api;

import hooks.api.HooksAPI;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.junit.Assert;
import pojos.CouponDetail;
import pojos.CouponDetailsPojo;
import utilities.ConfigReader;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class CommonAPI {


    public static String fullPath;
    Response response;

    public static String exceptionMessage;

    public static CouponDetailsPojo expPojo;
    public static CouponDetailsPojo actPojo;



    @Given("Api kullanicisi {string} path parametreleri set eder")
    public void api_kullanicisi_path_parametreleri_set_eder(String rawPaths) {
        
      //  spec.pathParams("pp1","api","pp2","login");
      //  Response response = given().when().get("{pp1}/{pp2}");
        
        String [] paths = rawPaths.split(",");
        StringBuilder tempPath = new StringBuilder("{");

        for (int i = 0; i < paths.length; i++) {
            String key = "pp" + i;
            String value = paths[i].trim();
            HooksAPI.spec.pathParam(key,value);
            
            tempPath.append(key + "}/{");
        }
        tempPath.deleteCharAt(tempPath.lastIndexOf("{"));
        tempPath.deleteCharAt(tempPath.lastIndexOf("/"));

        System.out.println("tempPath = " + tempPath);

        fullPath = tempPath.toString();
    }



    @Given("Api kullanicisi email ve password girer.")
    public void api_kullanicisi_email_ve_password_girer() {

        String email = ConfigReader.getProperty("email");
        String password = ConfigReader.getProperty("password");

        /*
        {
             "email": "admin@gmail.com",
              "password": "123123123"
        }
         */

        JSONObject reqBody = new JSONObject();

        reqBody.put("email",email);
        reqBody.put("password",password);

        response = given()
                .contentType(ContentType.JSON)
                .spec(HooksAPI.spec)
                .when()
                .body(reqBody.toString())
                .post(fullPath);

        response.prettyPrint();

    }

    @Given("Api kullanicisi response kaydeder")
    public void api_kullanicisi_response_kaydeder() {

        response = given()  // response alma başlangıcı
                .headers("Authorization","Bearer " + HooksAPI.token)  //Authentication classındaki method ile token alınıp hook classına kaydediliyor
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .spec(HooksAPI.spec) // postmane ana link girişi gibi
                .when()
                .log().all()//  pesindekiler oldugu zaman
                .get(fullPath);  // /api/profile/allAddressList parametreleri ile get yapılır

        response.prettyPrint();

    }

    @Given("Api kullanicisi status kodun {int} oldugunu test eder")
    public void api_kullanicisi_status_kodun_oldugunu_test_eder(Integer statuseCode) {
     if (statuseCode==404){
         Assert.assertTrue(exceptionMessage.contains("status code: 404"));
     }else {
         response.then().assertThat().statusCode(statuseCode);
     }
    }

    @Given("Api kullanici {string} bilgisinin {string} oldugunu test eder")
    public void api_kullanici_bilgisinin_oldugunu_test_eder(String msg, String sccs) {



        JSONObject expBody = new JSONObject();
        expBody.put(msg,sccs); // "message", "success"

        JsonPath actualBody = response.jsonPath();

        Assert.assertEquals(expBody.get(msg),actualBody.get(msg));

    }

    @Given("Api kullanicisi addressUpdate PATCH yapmak icin valid body hazirlar")
    public void api_kullanicisi_address_update_patch_yapmak_icin_valid_body_hazirlar() {

        /*
          "customer_id":602,
  "name": "eos",
  "email": "d@d.com",
  "address": "11",
  "phone": "ullam",
  "city": "labore",
  "state": "omnis",
  "country": "unde",
  "postal_code": "saepe",
  "address_type":"11"
         */
        HooksAPI.reqBody = new JSONObject();

        HooksAPI.reqBody.put("customer_id",602);
        HooksAPI.reqBody.put("name","eos");
        HooksAPI.reqBody.put("email","d@d.com");
        HooksAPI.reqBody.put("address","11");
        HooksAPI.reqBody.put("phone","ullam");
        HooksAPI.reqBody.put("city","labore");
        HooksAPI.reqBody.put("state","omnis");
        HooksAPI.reqBody.put("country","unde");
        HooksAPI.reqBody.put("postal_code","saepe");
        HooksAPI.reqBody.put("address_type","11");

    }

    @Given("Api kullanicisi PATCH yaparak response kaydeder")
    public void api_kullanicisi_patch_yaparak_response_kaydeder() {

        try {


            response = given()  // response alma başlangıcı
                    .headers("Authorization","Bearer " + HooksAPI.token)  //Authentication classındaki method ile token alınıp hook classına kaydediliyor
                    .contentType(ContentType.JSON)
                    .accept(ContentType.JSON)
                    .spec(HooksAPI.spec) // postmane ana link girişi gibi
                    .when()
                    .body(HooksAPI.reqBody.toString())
                    .log().all()//  pesindekiler oldugu zaman
                    .patch(fullPath);  // /api/profile/allAddressList parametreleri ile get yapılır

            response.prettyPrint();

        } catch (Exception e) {
            exceptionMessage= e.getMessage();
        }


    }


    @Given("Api kullanicisi customerAddressUpdate PATCH yapmak icin valid body hazirlar")
    public void api_kullanicisi_customer_address_update_patch_yapmak_icin_valid_body_hazirlar() {

        /*
          "name": "eos",
  "email": "d@d.com",
  "address": "11",
  "phone": "ullam",
  "city": "labore",
  "state": "omnis",
  "country": "unde",
  "postal_code": "saepe",
  "address_type":"11"
         */
        HooksAPI.reqBody= new JSONObject();

        HooksAPI.reqBody.put("name","eos");
        HooksAPI.reqBody.put("email","d@d.com");
        HooksAPI.reqBody.put("address","11");
        HooksAPI.reqBody.put("phone","ullam");
        HooksAPI.reqBody.put("city","labore");
        HooksAPI.reqBody.put("state","omnis");
        HooksAPI.reqBody.put("country","unde");
        HooksAPI.reqBody.put("postal_code","saepe");
        HooksAPI.reqBody.put("address_type","11");

        System.out.println(HooksAPI.reqBody.toString());

    }

    @Given("Api kullanicisi addressUpdate PATCH yapmak icin invalid body hazirlar")
    public void api_kullanicisi_address_update_patch_yapmak_icin_invalid_body_hazirlar() {

        HooksAPI.reqBody = new JSONObject();

        HooksAPI.reqBody.put("customer_id",602);
        HooksAPI.reqBody.put("name","eos");
        HooksAPI.reqBody.put("email","d@d.com");
        HooksAPI.reqBody.put("address","11");
        HooksAPI.reqBody.put("phone","ullam");
        HooksAPI.reqBody.put("city","labore");
        HooksAPI.reqBody.put("state","omnis");
        HooksAPI.reqBody.put("country","unde");
        HooksAPI.reqBody.put("postal_code","saepe");
        HooksAPI.reqBody.put("address_type","11");

    }

    @Given("Api kullanici message bilgisinin {string} oldugunu test eder")
    public void api_kullanici_message_bilgisinin_oldugunu_test_eder(String hataMesaji) {

        Assert.assertTrue(exceptionMessage.contains(hataMesaji));

    }

    @Given("Api kullanicisi {string} olarak sisteme giris yapar")
    public void api_kullanicisi_olarak_sisteme_giris_yapar(String user) {

        if(user.equals("admin")) {
            RequestSpecification spec = new RequestSpecBuilder().setBaseUri(ConfigReader.getProperty("base_url")).build();

            spec.pathParams("pp1", "api", "pp2", "login");

            Map<String, Object> dataCredentials = new HashMap<>();

            dataCredentials.put("email", ConfigReader.getProperty("adminEmail"));
            dataCredentials.put("password", ConfigReader.getProperty("password"));

            Response response = given()
                    .contentType(ContentType.JSON)
                    .spec(spec)
                    .when()
                    .body(dataCredentials)
                    .post("{pp1}/{pp2}");

            response.prettyPrint();
            JsonPath jsonResponse = response.jsonPath();

            String token = jsonResponse.getString("token");

            HooksAPI.token = token;

        }else {

            RequestSpecification spec = new RequestSpecBuilder().setBaseUri(ConfigReader.getProperty("base_url")).build();

            spec.pathParams("pp1", "api", "pp2", "login");

            Map<String, Object> dataCredentials = new HashMap<>();

            dataCredentials.put("email", ConfigReader.getProperty("customerEmail"));
            dataCredentials.put("password", ConfigReader.getProperty("password"));

            Response response = given()
                    .contentType(ContentType.JSON)
                    .spec(spec)
                    .when()
                    .body(dataCredentials)
                    .post("{pp1}/{pp2}");

            response.prettyPrint();
            JsonPath jsonResponse = response.jsonPath();

            String token = jsonResponse.getString("token");

            HooksAPI.token = token;


        }
    }

    @Given("Api kullanicisi couponDetails GET yapmak icin idsi {int} olan body olusturur")
    public void api_kullanicisi_coupon_details_get_yapmak_icin_idsi_olan_body_olusturur(Integer id) {

        HooksAPI.reqBody=new JSONObject();
        HooksAPI.reqBody.put("id",id);

    }

    @Given("Api kullanicisi couponDetails icin body ile GET yaparak response kaydeder")
    public void api_kullanicisi_coupon_details_icin_body_ile_get_yaparak_response_kaydeder() {

        response = given()  // response alma başlangıcı
                .headers("Authorization","Bearer " + HooksAPI.token)  //Authentication classındaki method ile token alınıp hook classına kaydediliyor
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .spec(HooksAPI.spec) // postmane ana link girişi gibi
                .when()
                .body(HooksAPI.reqBody.toString())
                .log().all()//  pesindekiler oldugu zaman
                .get(fullPath);  // /api/profile/allAddressList parametreleri ile get yapılır

        response.prettyPrint();

    }

    @Given("Api kullanicisi beklenen degerler ile CouponDetailsPojo olusturur")
    public void api_kullanicisi_beklenen_degerler_ile_coupon_details_pojo_olusturur() {

        expPojo = new CouponDetailsPojo();
        CouponDetail couponDetail = new CouponDetail();
        /*
        {
    "couponDetails": [
        {
            "id": 2,
            "title": "Orderder",
            "coupon_code": "ordered",
            "coupon_type": 2,
            "start_date": "2021-02-26",
            "end_date": "2025-03-30",
            "discount": 10,
            "discount_type": 0,
            "minimum_shopping": 1,
            "maximum_discount": null,
            "created_by": 870,
            "updated_by": 870,
            "is_expire": 0,
            "is_multiple_buy": 1,
            "created_at": "2021-11-16T18:59:20.000000Z",
            "updated_at": "2023-04-01T18:44:13.000000Z"
        }
    ],
    "message": "success"
}
         */
        couponDetail.setId(2);
        couponDetail.setTitle("Orderder");
        couponDetail.setCouponCode("ordered");
        couponDetail.setCouponType(2);
        couponDetail.setStartDate("2021-02-26");
        couponDetail.setEndDate("2025-03-30");
        couponDetail.setDiscount(10);
        couponDetail.setDiscountType(0);
        couponDetail.setMinimumShopping(1);
        couponDetail.setMaximumDiscount(null);
        couponDetail.setCreatedBy(739);
        couponDetail.setUpdatedBy(739);
        couponDetail.setIsExpire(0);
        couponDetail.setIsMultipleBuy(1);
        couponDetail.setCreatedAt("2021-11-16T18:59:20.000000Z");
        couponDetail.setUpdatedAt("2023-04-01T21:02:49.000000Z");

        expPojo.setMessage("success");

        List<CouponDetail> couponDetails  = new ArrayList<>();
        couponDetails.add(couponDetail);

        expPojo.setCouponDetails(couponDetails);


        System.out.println(expPojo);







    }

    @Given("Api kullanici response icindeki degerlerin beklenen degerler ile ayni oldugunu test eder")
    public void api_kullanici_response_icindeki_degerlerin_beklenen_degerler_ile_ayni_oldugunu_test_eder() {

        actPojo = response.as(CouponDetailsPojo.class); // gelen responsı hazırladığımız Coupon details pojo şekline sokor

        Assert.assertEquals(expPojo.getMessage(),actPojo.getMessage());
        Assert.assertEquals(expPojo.getCouponDetails().get(0).getTitle(),actPojo.getCouponDetails().get(0).getTitle());
        Assert.assertEquals(expPojo.getCouponDetails().get(0).getCouponCode(),actPojo.getCouponDetails().get(0).getCouponCode());
        Assert.assertEquals(expPojo.getCouponDetails().get(0).getCouponType(),actPojo.getCouponDetails().get(0).getCouponType());
        Assert.assertEquals(expPojo.getCouponDetails().get(0).getStartDate(),actPojo.getCouponDetails().get(0).getStartDate());
        Assert.assertEquals(expPojo.getCouponDetails().get(0).getEndDate(),actPojo.getCouponDetails().get(0).getEndDate());
        Assert.assertEquals(expPojo.getCouponDetails().get(0).getDiscount(),actPojo.getCouponDetails().get(0).getDiscount());
        Assert.assertEquals(expPojo.getCouponDetails().get(0).getMinimumShopping(),actPojo.getCouponDetails().get(0).getMinimumShopping());
        Assert.assertEquals(expPojo.getCouponDetails().get(0).getMaximumDiscount(),actPojo.getCouponDetails().get(0).getMaximumDiscount());
        Assert.assertEquals(expPojo.getCouponDetails().get(0).getCreatedBy(),actPojo.getCouponDetails().get(0).getCreatedBy());
        Assert.assertEquals(expPojo.getCouponDetails().get(0).getUpdatedBy(),actPojo.getCouponDetails().get(0).getUpdatedBy());
        Assert.assertEquals(expPojo.getCouponDetails().get(0).getIsExpire(),actPojo.getCouponDetails().get(0).getIsExpire());
        Assert.assertEquals(expPojo.getCouponDetails().get(0).getIsMultipleBuy(),actPojo.getCouponDetails().get(0).getIsMultipleBuy());
        Assert.assertEquals(expPojo.getCouponDetails().get(0).getCreatedAt(),actPojo.getCouponDetails().get(0).getCreatedAt());
        Assert.assertEquals(expPojo.getCouponDetails().get(0).getUpdatedAt(),actPojo.getCouponDetails().get(0).getUpdatedAt());

/*
            "id": 2,
            "title": "Orderder",
            "coupon_code": "ordered",
            "coupon_type": 2,
            "start_date": "2021-02-26",
            "end_date": "2025-03-30",
            "discount": 10,
            "discount_type": 0,
            "minimum_shopping": 1,
            "maximum_discount": null,
            "created_by": 870,
            "updated_by": 870,
            "is_expire": 0,
            "is_multiple_buy": 1,
            "created_at": "2021-11-16T18:59:20.000000Z",
            "updated_at": "2023-04-01T18:44:13.000000Z"
 */
    }



}

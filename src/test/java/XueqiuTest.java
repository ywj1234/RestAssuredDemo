

import io.restassured.http.ContentType;
import org.junit.Test;

import java.util.Date;
import java.util.HashMap;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class XueqiuTest {

    @Test
    public void testSearch(){
        useRelaxedHTTPSValidation();
        given().log().all()
                .queryParam("code","sougou").queryParam("size","3").queryParam("page","1")
                .header("cookie","device_id=24700f9f1986800ab4fcc880530dd0ed; aliyungf_tc=AQAAAOqssS4QbQ0A8aWctHrCHWgx5LyH; acw_tc=2760820715894434248902262e8070e201d04004272d19c32389627539f980; xq_a_token=328f8bbf7903261db206d83de7b85c58e4486dda; xqat=328f8bbf7903261db206d83de7b85c58e4486dda; xq_r_token=22ab4927b9acb2a02a4efefe14ccbbc589e007cb; xq_id_token=eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJ1aWQiOi0xLCJpc3MiOiJ1YyIsImV4cCI6MTU5MTg0Mjc0NiwiY3RtIjoxNTg5NDQzMzY2MTI1LCJjaWQiOiJkOWQwbjRBWnVwIn0.GhGtBEmlX1AkmqyA85NTtkg3STpiplIqLHaufu4M4M70EA4Qo0NBP8230wT_mgNVe4RHC5Ttl7qG5rm4UHJfjP3lWW3YnVRKbTh63xFkg7QdRl_15jn0cXC0ZZD88XZVuEkbqyQXf4izLVHiboG8Zcf9GaSEpVdJJSw2aUEEGYNewsGk716ZspbLZMeuiTAfet51igzaJXy2c2SMaWmueZlz90uMuqFdNC6XOO3scXDIjpc7hgvwrGpVJQeI3yKK0QCCcykA5TIa8i04zs_3EVFKq9TFqmex_atq7qZsoTZ9i7J-bGUeTnZhW5AkNZU7_EdLK555Dw5GTNgPPVLuGA; u=631589443424910; Hm_lvt_1db88642e346389874251b5a1eded6e3=1589202325,1589209308,1589443426; Hm_lpvt_1db88642e346389874251b5a1eded6e3=1589443435")
                .when().get("https://xueqiu.com/stock/search.json")
                .then().log().all()
                .statusCode(200).
                body("stocks[0].code",equalTo("SOGO"))
                .body("stocks.name",hasItems("搜狗"));
    }

    @Test
    public void testSearchCode(){
        useRelaxedHTTPSValidation();
        Integer code = given().log().all()
                .queryParam("code","sougou").queryParam("size","3").queryParam("page","1")
                .header("cookie","device_id=24700f9f1986800ab4fcc880530dd0ed; aliyungf_tc=AQAAAOqssS4QbQ0A8aWctHrCHWgx5LyH; acw_tc=2760820715894434248902262e8070e201d04004272d19c32389627539f980; xq_a_token=328f8bbf7903261db206d83de7b85c58e4486dda; xqat=328f8bbf7903261db206d83de7b85c58e4486dda; xq_r_token=22ab4927b9acb2a02a4efefe14ccbbc589e007cb; xq_id_token=eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJ1aWQiOi0xLCJpc3MiOiJ1YyIsImV4cCI6MTU5MTg0Mjc0NiwiY3RtIjoxNTg5NDQzMzY2MTI1LCJjaWQiOiJkOWQwbjRBWnVwIn0.GhGtBEmlX1AkmqyA85NTtkg3STpiplIqLHaufu4M4M70EA4Qo0NBP8230wT_mgNVe4RHC5Ttl7qG5rm4UHJfjP3lWW3YnVRKbTh63xFkg7QdRl_15jn0cXC0ZZD88XZVuEkbqyQXf4izLVHiboG8Zcf9GaSEpVdJJSw2aUEEGYNewsGk716ZspbLZMeuiTAfet51igzaJXy2c2SMaWmueZlz90uMuqFdNC6XOO3scXDIjpc7hgvwrGpVJQeI3yKK0QCCcykA5TIa8i04zs_3EVFKq9TFqmex_atq7qZsoTZ9i7J-bGUeTnZhW5AkNZU7_EdLK555Dw5GTNgPPVLuGA; u=631589443424910; Hm_lvt_1db88642e346389874251b5a1eded6e3=1589202325,1589209308,1589443426; Hm_lpvt_1db88642e346389874251b5a1eded6e3=1589443435")
                .when().get("https://xueqiu.com/stock/search.json")
                .then().log().all()
                .statusCode(200).
                body("stocks[0].code",equalTo("SOGO"))
                .body("stocks.name",hasItems("搜狗"))
                .extract().path("size");
        System.out.println(code);
    }

    @Test
    public void testPostJson(){
        HashMap<String,Object> map = new HashMap<String, Object>();
        map.put("a",1);
        map.put("b","testerhome");
        given()
                .contentType(ContentType.JSON)
                .body(map)
                .when().post("https://www.baidu.com")
                .then().log().all().statusCode(200);
    }

    @Test
    public String sayHello(){
        //修改返回的字符串的内容
        return "abcdefg. Hello jenkins, " + new Date()+"ywj"+"2019";
    }
}

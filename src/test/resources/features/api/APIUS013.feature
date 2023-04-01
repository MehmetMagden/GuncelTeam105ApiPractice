
@APIUS013 @API
Feature: As an administrator, I want to be able to access and update coupon details via API link.

  @APIUS13_TC002
  Scenario: When a GET request body containing valid authorization information and required data (coupon id) is sent to the /api/coupon/couponDetails endpoint, the data in the response body

    * Api kullanicisi "admin" olarak sisteme giris yapar
    * Api kullanicisi "api,coupon,couponDetails" path parametreleri set eder
    * Api kullanicisi couponDetails GET yapmak icin idsi 2 olan body olusturur
    * Api kullanicisi couponDetails icin body ile GET yaparak response kaydeder
    * Api kullanicisi beklenen degerler ile CouponDetailsPojo olusturur
    * Api kullanici response icindeki degerlerin beklenen degerler ile ayni oldugunu test eder
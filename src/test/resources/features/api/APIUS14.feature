@APIUS14 @API
Feature: Bir kullanici olarak API baglantisi üzerinden profilime adres kayit etmek, adreslerimi görüntülemek, güncelelmek ve silebilmek istiyorum.

  @APIUS14_TC005
  Scenario: /api/profile/customerAddressUpdate/(x) endpoint'ine gecerli authorization bilgileri ve gerekli verileri iceren bir PATCH request body  gönderildiginde dönen status code'in 202 ve response body'deki message bilgisinin  "address updated successfully" oldugu dogrulanmali.

    * Api kullanicisi "customer" olarak sisteme giris yapar
    * Api kullanicisi "api,profile,customerAddressUpdate,384" path parametreleri set eder
    * Api kullanicisi customerAddressUpdate PATCH yapmak icin valid body hazirlar
    * Api kullanicisi PATCH yaparak response kaydeder
    * Api kullanicisi status kodun 202 oldugunu test eder
    * Api kullanici "message" bilgisinin "address updated successfully" oldugunu test eder
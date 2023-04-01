@APIUS015 @API
Feature: Bir yönetici olarak API baglantisi üzerinden sisteme kayitli customer adreslerine erisebilmek, yeni adres ekleyebilmek  ve mevcut adresleri güncelleyebilmek istiyorum.

  @APIUS015_TC001
  Scenario: api/profile/allAddressList endpoint'ine gecerli authorization bilgileri iceren bir GET request body  gönderildiginde dönen status code'in 200 ve message bilgisinin "success" oldugu dogrulanmali.

    * Api kullanicisi "admin" olarak sisteme giris yapar
    * Api kullanicisi "api,profile,allAddressList" path parametreleri set eder
    * Api kullanicisi response kaydeder
    * Api kullanicisi status kodun 200 oldugunu test eder
    * Api kullanici "message" bilgisinin "success" oldugunu test eder

  @APIUS015_TC005
  Scenario: /api/profile/addressUpdate/(x) endpoint'ine gecerli authorization bilgileri ve gerekli verileri iceren bir PATCH request body  gönderildiginde dönen status code'in 202 ve response body'deki message bilgisinin  "address updated successfully" oldugu dogrulanmali.

    * Api kullanicisi "admin" olarak sisteme giris yapar
    * Api kullanicisi "api,profile,addressUpdate,84" path parametreleri set eder
    * Api kullanicisi addressUpdate PATCH yapmak icin valid body hazirlar
    * Api kullanicisi PATCH yaparak response kaydeder
    * Api kullanicisi status kodun 202 oldugunu test eder
    * Api kullanici "message" bilgisinin "address updated successfully" oldugunu test eder

    @APIUS015_TC006
    Scenario: When a PATCH request body containing valid authorization information and incorrect data is sent to the /api/profile/addressUpdate/(x) endpoint, it should be verified that the status code returned is 404 and the message information in the response body is "address not found".

      * Api kullanicisi "admin" olarak sisteme giris yapar
      * Api kullanicisi "api,profile,addressUpdate,75" path parametreleri set eder
      * Api kullanicisi addressUpdate PATCH yapmak icin invalid body hazirlar
      * Api kullanicisi PATCH yaparak response kaydeder
      * Api kullanicisi status kodun 404 oldugunu test eder
      * Api kullanici message bilgisinin "Not Found" oldugunu test eder
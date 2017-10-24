package com.kidslox.helpers;

import io.restassured.response.Response;
import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Test;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Timestamp;

import static io.restassured.RestAssured.given;

public class TempMailApi {
    public static String mail;
    public static String mail_id;
    public static String userEmail;
    public static String url;
    static String md5 = DigestUtils.md5Hex(getUserEmail());

    public static void generateAndSaveUserEmail(){
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("src/test/resources/email"));
            writer.write(email());
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static String email(){
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        mail = timestamp.toString().replaceAll("[^A-Za-zА-Яа-я0-9]", "");
        mail = "testmail"+mail.substring(mail.length()-4, mail.length())+getMailDomain();
        System.out.println(mail);
        return mail;
    }
    public static String getUserEmail(){
        try {
            userEmail = new String ( Files.readAllBytes( Paths.get("src/test/resources/email") ) );
        } catch (IOException e) {
            e.printStackTrace();
        }
        return userEmail;
    }
    public static String getMailDomain(){
        Response response = given()
                .when()
                .get("http://api.temp-mail.ru/request/domains/format/json/")
                .then()
                .statusCode(200)
                .extract()
                .response();
        String res = response.asString();
        String domain = res.substring(2,res.length()-2);
        return domain;
    }
    public static String getResetUrl(){
        Response response = given()
                .when()
                .get("http://api.temp-mail.ru/request/mail/id/"+md5+"/format/php/")
                .then()
                .statusCode(200)
                .extract()
                .response();
        String a, b,f;
        a = response.asString();
        b = "https://admin";
        f = a.substring(a.lastIndexOf(b),a.lastIndexOf(b)+130);
        url = f.substring(0,f.indexOf("</span>"));
        return  url;
    }
    public  String getMailId(){
        Response response = given()
                .when()
                .get("http://api.temp-mail.ru/request/mail/id/"+md5+"/format/json/")
                .then()
                .statusCode(200)
                .extract()
                .response();
        mail_id = response.path("mail_id").toString();
        mail_id = mail_id.substring(1,mail_id.length()-1);
        return mail_id;
    }
    @Test
    public void deleteMail(){
        Response response = given()
                .when()
                .get("http://api.temp-mail.ru/request/delete/id/"+getMailId()+"/")
                .then()
                .extract()
                .response();
    }
}

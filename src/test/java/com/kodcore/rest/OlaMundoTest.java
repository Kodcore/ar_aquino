package com.kodcore.rest;

import static org.junit.Assert.*;
import static io.restassured.RestAssured.*;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.junit.Test;

public class OlaMundoTest {
   // @Test
    public void testOlaMundo(){
        Response reposta = request(Method.GET, "http://restapi.wcaquino.me/ola");
        assertTrue(reposta.getBody().asString().equals("Ola Mundo!"));
        assertTrue(reposta.statusCode()== 200);
        //assertTrue("O status code deveria ser 200",reposta.statusCode()== 201);

        //validando com equals
        assertEquals(201, reposta.statusCode());

        //throw new RuntimeException();
        ValidatableResponse validacao = reposta.then();
        validacao.statusCode(200);
    }
   // @Test
    public void devoConhecerOutrasFormasRestAssured(){
        Response resposta = request(Method.GET, "http://restapi.wcaquino.me/ola");
        ValidatableResponse validacao = resposta.then();
        validacao.statusCode(200);

        get("http://restapi.wcaquino.me/ola").then().statusCode(201);
    }

    //metodo utiizando estrutura given when then : dado que, quando, então
    @Test
    public void utilizandoBDDcomRestAssured(){
        Response resposta = request(Method.GET, "http://restapi.wcaquino.me/ola");
        ValidatableResponse validacao = resposta.then();
        validacao.statusCode(200);

        given().//pre condição
                when() //ação
                    .get("http://restapi.wcaquino.me/ola")
                .then() //resultado
                    .statusCode(200);
    }

    @Test
    public void devoConhecerMatchersComHamcrest(){
    }
}

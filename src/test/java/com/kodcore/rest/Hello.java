package com.kodcore.rest;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
/*
acessando o servidor e imprimindo em tela o status retornado
sem junit
 */

public class Hello {
    public static void main(String[] args) {
        Response reposta = RestAssured.request(Method.GET, "http://restapi.wcaquino.me/ola");
        System.out.println(reposta.getBody().asString().equals("Ola Mundo!"));
        System.out.println(reposta.statusCode()== 200);

        //validação explicita
        ValidatableResponse validacao = reposta.then();
        validacao.statusCode(201);
    }
}

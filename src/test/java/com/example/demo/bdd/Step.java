package com.example.demo.bdd;

import com.example.demo.ClienteCommon;
import com.example.demo.adapter.controller.response.cliente.ClienteResponse;
import com.example.demo.core.domain.Cliente;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import io.restassured.response.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import static io.restassured.RestAssured.given;

public class Step {

    private Response response;
    private ClienteResponse clienteResponse;
    private final String ENDPOINT = "http://localhost:8080";
    private String cpf;


    @Quando("submeter o registro de um novo cliente")
    public void submeterNovoCliente() {
        cpf = ClienteCommon.gerarCPF();

        final var clienteRequest = ClienteCommon.factoryClienteRequest();
        clienteRequest.setCpf(cpf);

        response = given()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(clienteRequest)
                .when().post(ENDPOINT.concat("/v1/clientes"));
    }

    @Então("o cliente deve ser registrado com sucesso")
    public void clienteComSucesso() {
        response.then()
                .statusCode(HttpStatus.CREATED.value());
    }

    @Quando("submeter uma consulta por um cpf ja cadastrado")
    public void submeterConsultaCategoriaInvalidaOuInexistente() {

        response = given()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .when().get(ENDPOINT.concat("/v1/clientes/48265391854"));

    }

    @Então("deve conseguir localizar o cliente")
    public void deveConseguirLocalizarCliente() {
        response.then()
                .statusCode(HttpStatus.OK.value());
    }

}

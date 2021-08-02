package br.com.zup.edu

import io.grpc.ManagedChannelBuilder

fun main() {

    val channel = ManagedChannelBuilder
        .forAddress("localhost", 50051)
        .usePlaintext()
        .build()

    val client = FuncionarioServiceGrpc.newBlockingStub(channel)

    val request = FuncionarioRequest.newBuilder()
        .setNome("Joao")
        .setCpf("000.000.000-00")
        .setIdade(24)
        .setSalario(2030.0)
        .setAtivo(true)
        .setCargo(Cargo.QA)
        .addEnderecos(FuncionarioRequest.Endereco.newBuilder()
            .setCep("00000-000")
            .setLogradouro("Avenida whatever")
            .setComplemento("Em frente ao bar whatever")
            .build()
        )
        .build()

    val response = client.cadastrar(request)

    println(response)
}
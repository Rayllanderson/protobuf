package br.com.zup.edu

import br.com.zup.edu.Cargo.*
import java.io.FileInputStream
import java.io.FileOutputStream

fun main() {
    val request = FuncionarioRequest.newBuilder()
        .setNome("Joao")
        .setCpf("000.000.000-00")
        .setSalario(2030.0)
        .setAtivo(true)
        .setCargo(QA)
        .addEnderecos(FuncionarioRequest.Endereco.newBuilder()
            .setCep("00000-000")
            .setLogradouro("Avenida whatever")
            .setComplemento("Em frente ao bar whatever")
            .build()
        )
        .build()
    println(request)

    val nomeDoArquivo = "funcionario-request.bin"

    // escrevendo o objeto em disco
    request.writeTo(FileOutputStream(nomeDoArquivo))

    //buscamos o objeto em disco
    val request2 = FuncionarioRequest.newBuilder().mergeFrom(FileInputStream(nomeDoArquivo))
    request2.cargo = GERENTE
    request2.salario = 3500.1
    println(request2)
}
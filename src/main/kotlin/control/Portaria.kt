package control

import Business.ConvidadoBusiness
import entity.Convidado

class Portaria {

    private val convidadoBusiness = ConvidadoBusiness()

    init {
        println("Portaria do evento aberta!")
        println(controle())
    }

    private fun controle(): String {

        val idade = Console.readInt("qual a sua idade? ")
        val convidado = Convidado(idade = idade)
        if (!convidadoBusiness.maiorDeIdade(convidado.idade)) {
            return "Negado. Menores de idade não são permitidos"
        }

        convidado.tipo = Console.readString("Qual é o tipo de convite?")
        if (!convidadoBusiness.tipoValido(convidado.tipo)) {
            return "Negado. Convite inválido!"
        }
        convidado.codigo = Console.readString("Qual é o código do convite?")
        if (!convidadoBusiness.convidadoValido(convidado)) {
            return "Negado. Convite inválido!"
        }

        return "Bem vindo :) ! "
    }
}


package com.galvezsh.mvvm_1.model

class AdviceProvider {
    companion object {
        private val adviceList = listOf(
            AdviceModel(
                advice = "La programación orientada a objetos es fascinate",
                author = "Galvezsh"
            ),
            AdviceModel(
                advice = "La IA nos devorara a todos",
                author = "Galvezsh"
            ),
            AdviceModel(
                advice = "La IA es el futuro",
                author = "Galvezsh"
            ),
            AdviceModel(
                advice = "Si has visto la saga Terminator, puede que nos espere un futuro incierto",
                author = "Anonimo"
            ),
            AdviceModel(
                advice = "La arquitectura 'Modelo vista vista-modelo' no es complicado",
                author = "Galvezsh"
            ),
            AdviceModel(
                advice = "El autodidactismo es posible si uno se esfuerza lo suficiente",
                author = "Galvezsh"
            )
        )

        fun getRandomAdvice(): AdviceModel {
            val position = (0..5).random()
            return adviceList[position]
        }
    }
}
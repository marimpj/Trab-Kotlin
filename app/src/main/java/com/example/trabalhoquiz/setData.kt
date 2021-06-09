package com.example.trabalhoquiz

object setData {

    const val nome:String="nome"
    const val pontos:String="pontos"

    fun getQuestao():ArrayList<Data>{
        var quest:ArrayList<Data> = arrayListOf()
        var qst1 = Data(
            "Quanto a Paris Hilton calça?",
            0,
            "34",
            "37",
            "43",
            "40",
            3
        )
        var qst2 = Data(
            "Quanto tempo dura um sonho?",
            1,
            "40 a 45 minutos",
            "2 a 3 minutos",
            "5 a 7 minutos",
            "2 a 3 horas",
            2
        )
        var qst3 = Data(
            "Quantos quilômetros você consegue escrever com um lápis?",
            2,
            "56 km",
            "15 km",
            "83 km",
            "27 km",
            1
        )
        var qst4 = Data(
            "Qual animal não sente o gosto de doce?",
            3,
            "Vaca",
            "Golfinho",
            "Gato",
            "Rato",
            3
        )
        var qst5 = Data(
            "Qual a velocidade de rotação da terra?",
            4,
            "3567.7 km/h",
            "754.8 km/h",
            "1000.5 km/h",
            "1674.4 km/h",
            4
        )
        var qst6 = Data(
            "Quantos dentes tem um mosquito?",
            1,
            "Nenhum",
            "70",
            "45",
            "16",
            3
        )
        var qst7 = Data(
            "Onde fica o menor osso do corpo humano?",
            6,
            "Dedo do pé",
            "Orelha",
            "Dedo da mão",
            "Joelho",
            2
        )
        var qst8 = Data(
            "Albert Einstein foi convidado para assumir a presidência de qual país?",
            7,
            "Suíça",
            "Israel",
            "Canadá",
            "Alemanha",
            2
        )
        var qst9 = Data(
            "Qual o nome inteiro da Barbie?",
            8,
            "Barbara Millicent Roberts",
            "Barbara Mia Graham",
            "Barbara Jones",
            "Barbara Davis Moore",
            1
        )
        var qst10 = Data(
            "Quantos rounds durou a luta mais longa de boxe?",
            9,
            "39 rounds",
            "55 rounds",
            "130 rounds",
            "110 rounds",
            4
        )
        quest.add(qst1)
        quest.add(qst2)
        quest.add(qst3)
        quest.add(qst4)
        quest.add(qst5)
        quest.add(qst6)
        quest.add(qst7)
        quest.add(qst8)
        quest.add(qst9)
        quest.add(qst10)
        return quest
    }
}
fun main() {

    val purchaseAmount: Int = (0..20_000).random()
    val summOfBuy: Int = (0..10_000).random()
    val melomaniacStatus: Int = (0..2).random()
    val melomanoacDiscount: Double = 0.01

    fun checkRegularDiscount(purchaseAmount: Int, summOfBuy: Int): Double {
        if (purchaseAmount <= 1_000) {
            val discount: Double = 0.0
                return discount
        }
        else if (purchaseAmount <= 10_000) {
            val discount: Double = 100.0
            return discount
        }
        else {
            val discount: Double = 0.05
                return summOfBuy.toDouble() * discount
        }
    }

    fun summWithRegularDiscount(summOfBuy: Int): Double {
        return summOfBuy - checkRegularDiscount(purchaseAmount, summOfBuy)
    }

    fun checkMelomaniacDiscount(summOfBuy: Int, melomaniacStatus: Int, melomaniacDiscount: Double): Double {
        if (melomaniacStatus == 0) {
            return 0.0
        } else {
            return summWithRegularDiscount(summOfBuy) * melomaniacDiscount
        }
    }

    fun summWithMelomaniacDiscount(summOfBuy: Int, melomaniacDiscount: Double): Double {
        return summWithRegularDiscount(summOfBuy) -
                summWithRegularDiscount(summOfBuy) * melomaniacDiscount
    }

    println("Сумма вашей покупки составила $summOfBuy руб.")
    println("Сумма вашей скидки составляет ${checkRegularDiscount(purchaseAmount, summOfBuy)} "
            + "руб.")
    if (melomaniacStatus == 0) {
        println("Итоговая стоимость покупки - " +
                "${summWithRegularDiscount(summOfBuy)} руб.")
    } else {
        println("+ за регулярные покупки вы выполучаете дополнительную скидку 1% - ${checkMelomaniacDiscount(summOfBuy, 
        melomaniacStatus, melomanoacDiscount)} руб.")
        println("Итоговая стоимость покупки - " +
                "${summWithMelomaniacDiscount(summOfBuy, melomanoacDiscount)} руб.")
    }
}
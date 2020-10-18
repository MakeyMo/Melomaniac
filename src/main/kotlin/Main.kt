fun main() {

    val purchaseAmount: Int = (0..20_000).random()
    val songsToBuy: Int = (0..100).random()
    val melomaniacStatus: Int = (0..2).random()
    val melomanoacDiscount: Double = 0.01
    val songPrice: Int = 100
    val summOfBuy: Int = songsToBuy * songPrice

    fun checkDiscount(purchaseAmount: Int, songsToBuy: Int, songPrice: Int, melomaniacStatus: Int): Double {
        if (purchaseAmount <= 1_000) {
            val discount: Double = 0.0
            if (melomaniacStatus == 0) {
                return discount
            } else {
                return songsToBuy.toDouble() * songPrice.toDouble() * melomanoacDiscount
            }
        }
        else if (purchaseAmount <= 10_000) {
            val discount: Double = 100.0
            if (melomaniacStatus == 0) {
                return discount
            } else {
                return discount + (songsToBuy.toDouble() * songPrice.toDouble() - discount) * melomanoacDiscount
            }
        }
        else if (purchaseAmount >= 10_001) {
            val discount: Double = 0.05
            if (melomaniacStatus == 0) {
                return songsToBuy.toDouble() * songPrice.toDouble() * discount
            } else {
                return (songsToBuy.toDouble() * songPrice.toDouble() * discount) +
                        (songsToBuy.toDouble() * songPrice.toDouble() -
                                songsToBuy.toDouble() * songPrice.toDouble() * discount) * melomanoacDiscount
            }
        }
        return 0.0
    }

    fun countFinalSumm(summOfBuy: Int): Double {
        return summOfBuy - checkDiscount(purchaseAmount, songsToBuy, songPrice, melomaniacStatus)
    }

    println("Сумма вашей покупки составила $summOfBuy руб.")
    println("Сумма вашей скидки составляет ${checkDiscount(purchaseAmount, songsToBuy, songPrice, melomaniacStatus)} "
            + "руб.")
    println("Итоговая стоимость покупки - ${countFinalSumm(summOfBuy)} руб.")
}
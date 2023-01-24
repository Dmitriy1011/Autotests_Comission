fun main() {
    val result = calculateCommission(maestro, 10_000)
    println(result)
}

val maestro = "MAESTRO"
val mastercard = "MASTERCARD"
val visa = "VISA"
val mir = "MIR"
val vkPay = "VKPAY"
val maxTransferSumWithCardPerDay = 150_000
val maxTransferSumWithVkPayPerDay = 15_000
val maxTransferSumWithCardPerMonth = 600_000
val maxTransferSumWithVkPayPerMonth = 40_000

fun calculateCommission(cardAccountType: String, thisTransferSum: Int, previousTransfersSum: Int = 0): Int {

    val commissionSum: Int = (thisTransferSum * 0.75 / 100).toInt()

    val result = when (cardAccountType) {
        maestro, mastercard -> when {
            previousTransfersSum > maxTransferSumWithCardPerMonth -> -1
            thisTransferSum > maxTransferSumWithCardPerDay -> -1
            else -> thisTransferSum
        }

        visa, mir -> when {
            previousTransfersSum > maxTransferSumWithCardPerMonth -> -1
            thisTransferSum > maxTransferSumWithCardPerDay -> -1
            else -> when {
                thisTransferSum >= 35 -> thisTransferSum + commissionSum
                else -> -1
            }
        }

        vkPay -> when {
            previousTransfersSum > maxTransferSumWithVkPayPerMonth -> -1
            thisTransferSum > maxTransferSumWithVkPayPerDay -> -1
            else -> thisTransferSum
        }

        else -> -1
    }

    return result
}
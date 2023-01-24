import org.junit.Test

import org.junit.Assert.*

class MainKtTest {

    @Test
    fun calculateCommission() {
        val maestro = "MAESTRO"
        val mastercard = "MASTERCARD"
        val visa = "VISA"
        val mir = "MIR"
        val vkPay = "VKPAY"
        val someType = "someType"

        val result = calculateCommission(maestro, 10_000)
        val result2 = calculateCommission(mastercard, 20_000)
        val result3 = calculateCommission(visa, 50_000)
        val result31 = calculateCommission(visa, 20)
        val result4 = calculateCommission(mir, 75_000)
        val result5 = calculateCommission(vkPay, 5_000)
        val result6 = calculateCommission(someType, 3_000)
        val inCorrectResult1 = calculateCommission(mastercard, 30_000, 1_000_000)
        val inCorrectResult2 = calculateCommission(maestro, 700_000)
        val inCorrectResult3 = calculateCommission(visa, 800_000)
        val inCorrectResult4 = calculateCommission(mir, 20_000, 700_000)
        val inCorrectResult5 = calculateCommission(vkPay, 50_000)
        val inCorrectResult6 = calculateCommission(vkPay, 50_000, 100_000)

        assertEquals(10_000, result)
        assertEquals(20_000, result2)
        assertEquals(50_375, result3)
        assertEquals(-1, result31)
        assertEquals(75_562, result4)
        assertEquals(5_000, result5)
        assertEquals(-1, result6)
        assertEquals(-1, inCorrectResult1)
        assertEquals(-1, inCorrectResult2)
        assertEquals(-1, inCorrectResult3)
        assertEquals(-1, inCorrectResult4)
        assertEquals(-1, inCorrectResult5)
        assertEquals(-1, inCorrectResult6)
    }
}
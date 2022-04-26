package hw211

import org.junit.Test

import org.junit.Assert.*

class MainKtTest {

    @Test
    fun transaction_VK_Pay() {
        val currentTrans = 10000
        val cardType = "VK Pay"
        val prevTransSum = 0

        val result = transaction(
            currentTrans = currentTrans,
            cardType = cardType,
            prevTransSum = prevTransSum
        )

        assertEquals(0,result)
    }

    @Test
    fun transaction_Maestro() {
        val currentTrans = 1000000
        val cardType = "Maestro"
        val prevTransSum = 1000000

        val result = transaction(
            currentTrans = currentTrans,
            cardType = cardType,
            prevTransSum = prevTransSum
        )

        assertEquals(0,result)
    }

    @Test
    fun transaction_Maestro_Overlimits() {
        val currentTrans = 10000000
        val cardType = "Maestro"
        val prevTransSum = 1000000

        val result = transaction(
            currentTrans = currentTrans,
            cardType = cardType,
            prevTransSum = prevTransSum
        )

        assertEquals(23000,result)
    }

    @Test
    fun transaction_Visa() {
        val currentTrans = 4000000
        val cardType = "Visa"
        val prevTransSum = 1000000

        val result = transaction(
            currentTrans = currentTrans,
            cardType = cardType,
            prevTransSum = prevTransSum
        )

        assertEquals(30000,result)
    }

    @Test
    fun transaction_MYR_MinimalComission() {
        val currentTrans = 40000
        val cardType = "МИР"
        val prevTransSum = 1000000

        val result = transaction(
            currentTrans = currentTrans,
            cardType = cardType,
            prevTransSum = prevTransSum
        )

        assertEquals(3500,result)
    }

    @Test
    fun transaction_Incorrect_Card() {
        val currentTrans = 40000
        val cardType = "incorrect"
        val prevTransSum = 1000000

        val result = transaction(
            currentTrans = currentTrans,
            cardType = cardType,
            prevTransSum = prevTransSum
        )

        assertEquals(-1,result)
    }

    @Test
    fun main() {
    }

    @Test
    fun calcComissionMM_Prev_Over7500000() {
        val prevTransSum = 7500001
        val currentTrans = 10000

        val result = calcComissionMM(
            prevTransSum = prevTransSum,
            currentTrans = currentTrans
        )

        assertEquals(2060,result)
    }

    @Test
    fun calcComissionMM_minimalcomissin_firstUplimit() {
        val prevTransSum = 1000000
        val currentTrans = 6500001

        val result = calcComissionMM(
            prevTransSum = prevTransSum,
            currentTrans = currentTrans
        )

        assertEquals(2000,result)
    }

    @Test
    fun calcComissionMM_no_comission() {
        val prevTransSum = 0
        val currentTrans= 10000

        val result = calcComissionMM(
            prevTransSum = prevTransSum,
            currentTrans = currentTrans
        )

        assertEquals(1,result)
    }
}
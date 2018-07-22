package com.kohttp.ext

import org.junit.Test
import kotlin.system.measureTimeMillis
import kotlin.test.assertEquals

/**
 * Created by sergey on 21/07/2018.
 */
class StringExtKtTest {

    @Test
    fun `single sync invoke of httpGet`() {
        val result = "https://www.yandex.ru/search/?text=qqq&lr=213".httpGet()
        assertEquals(200, result?.code())
    }

    @Test
    fun `many sync invokes of httpGet`() {
        measureTimeMillis {
            List(100) {
                "https://www.yandex.ru/search/?text=qqq&lr=213".httpGet()
            }.forEach {
                assertEquals(200, it?.code())
            }
        }.also { println("$it ms") }
    }

}
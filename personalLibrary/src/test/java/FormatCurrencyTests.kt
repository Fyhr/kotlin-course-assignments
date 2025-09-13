package dk.fyhr.kotlin.personalLibrary

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FormatCurrencyTests {
    @Test
    fun `format Integer as euro`() {
        assertEquals("€0.00", 0.formatCurrency('€'))
        assertEquals("€0.01", 1.formatCurrency('€'))
        assertEquals("€0.12", 12.formatCurrency('€'))
        assertEquals("€1.23", 123.formatCurrency('€'))
        assertEquals("€12.34", 1234.formatCurrency('€'))
        assertEquals("€123.45", 12345.formatCurrency('€'))
        assertEquals("€1,234.56", 123456.formatCurrency('€'))
    }

    @Test
    fun `format Integer as currency without symbol`() {
        assertEquals("0.00", 0.formatCurrency())
        assertEquals("0.01", 1.formatCurrency())
        assertEquals("0.12", 12.formatCurrency())
        assertEquals("1.23", 123.formatCurrency())
        assertEquals("12.34", 1234.formatCurrency())
        assertEquals("123.45", 12345.formatCurrency())
        assertEquals("1,234.56", 123456.formatCurrency())
    }
}
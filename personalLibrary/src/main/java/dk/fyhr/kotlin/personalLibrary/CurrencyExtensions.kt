package dk.fyhr.kotlin.personalLibrary

import java.text.DecimalFormat

private const val currencyPattern = "#,##0.00"
private const val prettyPattern = "#,###.##"

fun Int.formatCurrency(symbol: Char? = null): String {
    val inWholeUnits = this / 100.0

    return if (symbol == null)
        DecimalFormat(currencyPattern).format(inWholeUnits)
    else
        DecimalFormat("${symbol}${currencyPattern}").format(inWholeUnits)
}

fun Int.format(): String {
        return DecimalFormat(prettyPattern).format(this)
}
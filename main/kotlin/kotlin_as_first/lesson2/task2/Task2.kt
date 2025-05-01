package kotlin_as_first.lesson2.task2

import kotlin_as_first.lesson1.sqr
import kotlin.math.abs
import kotlin.math.pow
import kotlin.math.sqrt

fun main(){
    println(daysInMonth(2, 1900))
}
/**
 * Пример
 *
 * Лежит ли точка (x, y) внутри окружности с центром в (x0, y0) и радиусом r?
 */
fun pointInsideCircle(x: Double, y: Double, x0: Double, y0: Double, r: Double) =
    sqr(x - x0) + sqr(y - y0) <= sqr(r)

/**
 * Простая (2 балла)
 *
 * Четырехзначное число назовем счастливым, если сумма первых двух ее цифр равна сумме двух последних.
 * Определить, счастливое ли заданное число, вернуть true, если это так.
 */
fun isNumberHappy(number: Int): Boolean {
    // 1234 -> 4
    val last1 = number % 10
    // 1234 -> 123 -> 3
    val last2 = (number / 10) % 10
    // 1234 -> 12 -> 2
    val first2 = (number / 100) % 10
    val first1 = number / 1000
    return first1 + first2 == last1 + last2
}

/**
 * Простая (2 балла)
 *
 * На шахматной доске стоят два ферзя (ферзь бьет по вертикали, горизонтали и диагоналям).
 * Определить, угрожают ли они друг другу. Вернуть true, если угрожают.
 * Считать, что ферзи не могут загораживать друг друга.
 */
fun queenThreatens(x1: Int, y1: Int, x2: Int, y2: Int): Boolean =
        (x1 == x2) || (y1 == y2) || (abs(x1 - x2) == abs(y1 - y2))


/**
 * Простая (2 балла)
 *
 * Дан номер месяца (от 1 до 12 включительно) и год (положительный).
 * Вернуть число дней в этом месяце этого года по григорианскому календарю.
 */
fun daysInMonth(month: Int, year: Int): Int {
    if(month == 2){
        if(year % 100 == 0){
            if((year % 1000) % 400 == 0){
                return 29
            } else return 28
        }
        if(year % 4 == 0){
            return 29
        }
        else return 28
    }
    val isEvenMonth = month % 2 == 0
    return when{
        isEvenMonth && month <= 7 -> 30
        !isEvenMonth && month <= 7 -> 31
        isEvenMonth && month >= 8 -> 31
        else -> 30
    }
}
/**
 * Простая (2 балла)
 *
 * Проверить, лежит ли окружность с центром в (x1, y1) и радиусом r1 целиком внутри
 * окружности с центром в (x2, y2) и радиусом r2.
 * Вернуть true, если утверждение верно
 */
//(a1 - a2)^2 + (b1-b2)^2 < (r-r2)^2
fun circleInside(
    x1: Double, y1: Double, r1: Double,
    x2: Double, y2: Double, r2: Double
): Boolean = sqrt((x2 - x1).pow(2) + (y2 - y1).pow(2)) <= r2 - r1

/**
 * Средняя (3 балла)
 *
 * Определить, пройдет ли кирпич со сторонами а, b, c сквозь прямоугольное отверстие в стене со сторонами r и s.
 * Стороны отверстия должны быть параллельны граням кирпича.
 * Считать, что совпадения длин сторон достаточно для прохождения кирпича, т.е., например,
 * кирпич 4 х 4 х 4 пройдёт через отверстие 4 х 4.
 * Вернуть true, если кирпич пройдёт
 */
fun brickPasses(a: Int, b: Int, c: Int, r: Int, s: Int): Boolean{
    val minSide1 = minOf(a, b)
    val minSide2 = minOf(b, c)
    return ((minSide1 <= r) && (minSide2 <= s)) || ((minSide1 <= s) && (minSide2 <= r))
}
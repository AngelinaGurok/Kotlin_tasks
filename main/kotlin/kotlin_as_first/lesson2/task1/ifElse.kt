package kotlin_as_first.lesson2.task1


import kotlin_as_first.lesson1.discriminant
import kotlin.math.abs
import kotlin.math.max
import kotlin.math.pow
import kotlin.math.sqrt

// Урок 2: ветвления (здесь), логический тип (см. 2.2).
// Максимальное количество баллов = 6
// Рекомендуемое количество баллов = 5
// Вместе с предыдущими уроками = 9/12

fun main(){
    println(segmentLength(1, 15, 10, 14))
}

/**
 * Пример
 *
 * Найти число корней квадратного уравнения ax^2 + bx + c = 0
 */
fun quadraticRootNumber(a: Double, b: Double, c: Double): Int {
    val discriminant = discriminant(a, b, c)
    return when {
        discriminant > 0.0 -> 2
        discriminant == 0.0 -> 1
        else -> 0
    }
}

/**
 * Пример
 *
 * Получить строковую нотацию для оценки по пятибалльной системе
 */
fun gradeNotation(grade: Int): String = when (grade) {
    5 -> "отлично"
    4 -> "хорошо"
    3 -> "удовлетворительно"
    2 -> "неудовлетворительно"
    else -> "несуществующая оценка $grade"
}

/**
 * Пример
 *
 * Найти наименьший корень биквадратного уравнения ax^4 + bx^2 + c = 0
 */
fun minBiRoot(a: Double, b: Double, c: Double): Double {
    // 1: в главной ветке if выполняется НЕСКОЛЬКО операторов
    if (a == 0.0) {
        if (b == 0.0) return Double.NaN // ... и ничего больше не делать
        val bc = -c / b
        if (bc < 0.0) return Double.NaN // ... и ничего больше не делать
        return -sqrt(bc)
        // Дальше функция при a == 0.0 не идёт
    }
    val d = discriminant(a, b, c)   // 2
    if (d < 0.0) return Double.NaN  // 3
    // 4
    val y1 = (-b + sqrt(d)) / (2 * a)
    val y2 = (-b - sqrt(d)) / (2 * a)
    val y3 = max(y1, y2)       // 5
    if (y3 < 0.0) return Double.NaN // 6
    return -sqrt(y3)           // 7
}

/**
 * Простая (2 балла)
 *
 * Мой возраст. Для заданного 0 < n < 200, рассматриваемого как возраст человека,
 * вернуть строку вида: «21 год», «32 года», «12 лет».
 */
fun ageDescription(age: Int): String {
    var lastDigits = age % 100
    if(lastDigits == 0 || (lastDigits in 5..19)){
        return "$age лет"
    }
    else {
        lastDigits = age % 10
        if(lastDigits == 0 || (lastDigits in 5..9)){
            return "$age лет"
        }
        if(lastDigits in 2 .. 4){
            return "$age года"
        }
        else return "$age год"
    }
}
/**
 * Простая (2 балла)
 *
 * Путник двигался t1 часов со скоростью v1 км/час, затем t2 часов — со скоростью v2 км/час
 * и t3 часов — со скоростью v3 км/час.
 * Определить, за какое время он одолел первую половину пути?
 */
fun timeForHalfWay(
    t1: Double, v1: Double,
    t2: Double, v2: Double,
    t3: Double, v3: Double
): Double {
    val s1 = t1 * v1
    val s2 = t2 * v2
    val s3 = t3 * v3
    var half = (s1 + s2 + s3)/2
    if(half <= s1){
        return half / v1
    }else if(half > s1 && half <= (s2 + s1)){
        return t1 + (half - s1)/v2
    } else{
        return t1 + t2 + (half -  s1 - s2)/v3
    }
}

/**
 * Простая (2 балла)
 *
 * Нa шахматной доске стоят черный король и две белые ладьи (ладья бьет по горизонтали и вертикали).
 * Определить, не находится ли король под боем, а если есть угроза, то от кого именно.
 * Вернуть 0, если угрозы нет, 1, если угроза только от первой ладьи, 2, если только от второй ладьи,
 * и 3, если угроза от обеих ладей.
 * Считать, что ладьи не могут загораживать друг друга
 */
fun whichRookThreatens(
    kingX: Int, kingY: Int,
    rookX1: Int, rookY1: Int,
    rookX2: Int, rookY2: Int
): Int {
    val isRook1Attack = ((kingX == rookX1) || (kingY == rookY1))
    val isRook2Attack = ((kingX == rookX2) || (kingY == rookY2))
    return when{
        isRook1Attack && isRook2Attack -> 3
        isRook2Attack -> 2
        isRook1Attack -> 1
        else -> 0
    }
}

/**
 * Простая (2 балла)
 *
 * На шахматной доске стоят черный король и белые ладья и слон
 * (ладья бьет по горизонтали и вертикали, слон — по диагоналям).
 * Проверить, есть ли угроза королю и если есть, то от кого именно.
 * Вернуть 0, если угрозы нет, 1, если угроза только от ладьи, 2, если только от слона,
 * и 3, если угроза есть и от ладьи и от слона.
 * Считать, что ладья и слон не могут загораживать друг друга.
 */
fun rookOrBishopThreatens(
    kingX: Int, kingY: Int,
    rookX: Int, rookY: Int,
    bishopX: Int, bishopY: Int
): Int {
    val isRookAttack = ((kingX == rookX) || (kingY == rookY))
    val xDifference = abs(bishopX - kingX)
    val yDifference = abs(bishopY - kingY)
    val isBishopAttack = xDifference == yDifference

    return when{
        isRookAttack && isBishopAttack -> 3
        isBishopAttack -> 2
        isRookAttack -> 1
        else -> 0
    }
}
/**
 * Простая (2 балла)
 *
 * Треугольник задан длинами своих сторон a, b, c.
 * Проверить, является ли данный треугольник остроугольным (вернуть 0),
 * прямоугольным (вернуть 1) или тупоугольным (вернуть 2).
 * Если такой треугольник не существует, вернуть -1.
 */
fun triangleKind(a: Double, b: Double, c: Double): Int {
    val isExisting = ((a + b > c) && (b + c > a) && (a + c > b))

    if(isExisting){

        val aSquared = a.pow(2)
        val bSquared = b.pow(2)
        val cSquared = c.pow(2)

        val isRight = ((aSquared == bSquared + cSquared) ||
                (bSquared == aSquared + cSquared) ||
                (cSquared == aSquared + bSquared))


        val isObtuse = ((aSquared > bSquared + cSquared) ||
                (bSquared > aSquared + cSquared) ||
                (cSquared > aSquared + bSquared))

        return when {
            isRight -> 1
            isObtuse -> 2
            else -> 0
        }
    } else return -1
}

/**
 * Средняя (3 балла)
 *
 * Даны четыре точки на одной прямой: A, B, C и D.
 * Координаты точек a, b, c, d соответственно, b >= a, d >= c.
 * Найти длину пересечения отрезков AB и CD.
 * Если пересечения нет, вернуть -1.
 */
fun segmentLength(a: Int, b: Int, c: Int, d: Int): Int {
    if ((b < c) || d < a) {
        return -1
    }

    val intersectionStart = maxOf(a, c)
    val intersectionEnd = minOf(b, d)

    return intersectionEnd - intersectionStart
}
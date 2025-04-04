package first_hometask

import kotlin.math.abs
import kotlin.math.hypot
import kotlin.math.max
import kotlin.math.pow
import kotlin.math.sqrt

/**
 * Простая (2 балла)
 *
 * Рассчитать расстояние между двумя окружностями.
 * Расстояние между непересекающимися окружностями рассчитывается как
 * расстояние между их центрами минус сумма их радиусов.
 * Расстояние между пересекающимися окружностями считать равным 0.0.
 */

fun main(){
    val circle1 = Circle(Point(2.0,1.0), 3.0)
    val circle2 = Circle(Point(17.0, 10.0), 2.0)
    println("Distance between circles: %.4f".format(distance(circle1, circle2)))
}

fun distance(c1: Circle, c2: Circle) : Double{

    val centerDistance = centerDistance(c1.center, c2.center)
    val radiusSum = c1.radius + c2.radius
    return max(0.0, centerDistance - radiusSum)
}

fun centerDistance(center1: Point, center2: Point): Double{
    val x = abs(center1.x - center2.x)
    val y = abs(center1.y - center2.y)
    return hypot(x, y)
}
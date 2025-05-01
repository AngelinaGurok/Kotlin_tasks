package tests

import first_hometask.Circle
import first_hometask.Point
import first_hometask.distance
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import kotlin.math.sqrt

class CircleTest {
    @Test
    fun testCircle(){
        assertEquals(0.0,
            distance(Circle(Point(0.0, 0.0),1.0), Circle(Point(1.0, 0.0), 1.0)),
            1e-5)

        assertEquals(0.0,
            distance(Circle(Point(0.0, 0.0), 1.0), Circle(Point(0.0, 2.0), 1.0)),
            1e-5)

        assertEquals(1.0,
            distance(Circle(Point(0.0, 0.0), 1.0), Circle(Point(-4.0, 0.0), 2.0)),
            1e-5)

        assertEquals(2.0 * sqrt(2.0) - 2.0,
            distance(Circle(Point(0.0, 0.0), 1.0),Circle(Point(2.0, 2.0), 1.0)),
            1e-5)
    }

}
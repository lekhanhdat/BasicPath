package test;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AverageCalculatorTest {

    @Test
    public void testValidValuesWithinRange() {
        // Test Case 1: Các giá trị hợp lệ trong khoảng (10 → 50)
        AverageCalculator calculator = new AverageCalculator();
        int[] values = {10, 20, 30, 40, -999};
        int minimum = 10;
        int maximum = 50;
        int expectedAverage = 25; // Tính trung bình của 10, 20, 30, và 40
        assertEquals(expectedAverage, calculator.average(values, minimum, maximum));
    }

    @Test
    public void testNoValidValues() {
        // Test Case 2: Không có giá trị hợp lệ (giá trị ngoài khoảng hoặc không có số hợp lệ)
        AverageCalculator calculator = new AverageCalculator();
        int[] values = {5, 60, 70, -999}; // Giá trị ngoài khoảng
        int minimum = 10;
        int maximum = 50;
        int expectedAverage = -999; // Không có giá trị nào trong khoảng
        assertEquals(expectedAverage, calculator.average(values, minimum, maximum));
    }

    @Test
    public void testEmptyArray() {
        // Test Case 3: Mảng rỗng
        AverageCalculator calculator = new AverageCalculator();
        int[] values = {}; // Không có giá trị nào
        int minimum = 10;
        int maximum = 50;
        int expectedAverage = -999; // Không có giá trị nào
        assertEquals(expectedAverage, calculator.average(values, minimum, maximum));
    }

    @Test
    public void testValuesUpToSentinel() {
        // Test Case 4: Mảng có các giá trị hợp lệ và dừng lại ở giá trị sentinel -999
        AverageCalculator calculator = new AverageCalculator();
        int[] values = {15, 25, -999, 35, 45}; // Dừng lại khi gặp -999
        int minimum = 10;
        int maximum = 50;
        int expectedAverage = 20; // Tính trung bình của 15 và 25
        assertEquals(expectedAverage, calculator.average(values, minimum, maximum));
    }

    @Test
    public void testValuesWithLimitOf100Inputs() {
        // Test Case 5: Mảng vượt quá 100 phần tử
        AverageCalculator calculator = new AverageCalculator();
        int[] values = new int[101];
        for (int i = 0; i < 101; i++) {
            values[i] = 20;
        }
        int minimum = 10;
        int maximum = 30;
        int expectedAverage = 20; // Tính trung bình của 100 phần tử đầu tiên là 20
        assertEquals(expectedAverage, calculator.average(values, minimum, maximum));
    }
}

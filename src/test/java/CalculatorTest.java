import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {

    @TestFactory
    Stream<DynamicTest> dynamicTestsFromStreamInJava8() {
        Calculator calculator = new Calculator();
        List<Integer> inputs = IntStream.range(0, 1000).boxed().collect(Collectors.toList());
        List<Integer> results = IntStream.range(0, 1000).map(n -> n * 2).boxed().collect(Collectors.toList());

        return inputs.stream()
                .map(number -> DynamicTest.dynamicTest("multiplying: " + number,
                        () -> {
                            assertEquals(calculator.multiply(number, 2), results.get(number));
                        }));

    }
}

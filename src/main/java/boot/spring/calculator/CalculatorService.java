package boot.spring.calculator;
public interface CalculatorService {
    String calculator();

    Integer sum(Integer num1, Integer num2);

    Integer minus(Integer num1, Integer num2);

    Integer multiply(Integer num1, Integer num2);

    Integer divide(Integer num1, Integer num2);

}

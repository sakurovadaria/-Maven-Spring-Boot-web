import boot.spring.calculator.CalculatorService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculator")
public class CalculatorController {
    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    public String calculator() {
        return calculatorService.calculator();
    }

    public String sum(@RequestParam Integer num1, @RequestParam Integer num2) {
        Integer result = calculatorService.sum(num1, num2);
        return generateMassage(num1, num2, '+', result);
    }

    public String minus(@RequestParam Integer num1, @RequestParam Integer num2) {
        Integer result = calculatorService.minus(num1, num2);
        return generateMassage(num1, num2, '-', result);
    }

    public String multiply(@RequestParam Integer num1, @RequestParam Integer num2) {
        Integer result = calculatorService.multiply(num1, num2);
        return generateMassage(num1, num2, '*', result);
    }

    public String divide(@RequestParam Integer num1, @RequestParam Integer num2) {
        if (num2 == 0) {
            throw  new IllegalArgumentException("mistake");
        }
        Integer result = calculatorService.divide(num1, num2);
        return generateMassage(num1, num2, '/', result);
    }

    private String generateMassage(Integer num1, Integer num2, char action, int result) {
        return String.format("<h1>%d %c %d = %d</h1>", num1, action, num2, result);
    }
}

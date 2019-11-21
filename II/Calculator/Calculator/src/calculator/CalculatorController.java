package calculator;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;
import javax.swing.JTextField;

/**
 *
 * @author Rafael da Silva Ferreira <rafael@swift-yah.io>
 */
public class CalculatorController {
    private Calculator calculator;
    private final DecimalFormat decimalFormat;
    private final JTextField resultTextField;


    public CalculatorController(JTextField resultTextField) {
        this.calculator = new Calculator();
        this.decimalFormat = new DecimalFormat("#.###################");
        this.resultTextField = resultTextField;
    }

    public void updateTextField(ActionEvent evt) {
        String newText;

        if (calculator.getShouldGetNewValue()) {
            newText = evt.getActionCommand();
        } else {
            newText = resultTextField.getText() + evt.getActionCommand();
        }

        Long newNumber = Long.parseLong(newText);

        resultTextField.setText(newNumber.toString());

        calculator.disableGetNewValue();
    }

    public void handleKeyTyped(KeyEvent evt) {
        char keyTyped = evt.getKeyChar();
        String keyTypedAsString = Character.toString(keyTyped);
        ActionEvent action = new ActionEvent(evt, 0, keyTypedAsString);

        switch (keyTyped) {
            case '0':
            case '1':
            case '2':
            case '3':
            case '4':
            case '5':
            case '6':
            case '7':
            case '8':
            case '9':
                updateTextField(action);
                break;

            case '+':
            case '-':
            case '/':
            case '*':
            case '=':
                updateOperation(action);
                break;

            case '\n':
                action = new ActionEvent('=', 0, "=");
                updateOperation(action);
                break;

            case '\b':
                deleteCharFromTextField();
                break;

            default:
                if (evt.getExtendedKeyCode() == 27) {
                    clear();
                }
        }
    }

    private void updateNumbersForOperations() {
        String resultText = resultTextField.getText();
        Double value = Double.parseDouble(resultText);

        if (!calculator.hasFirstOperand()) {
            calculator.setFirstOperand(value);
        } else if (!calculator.hasSecondOperand()) {
            calculator.setSecondOperand(value);
        }
    }

    public void updateOperation(ActionEvent evt) {
        boolean isEqualOperation = evt.getActionCommand().equals("=");
        boolean isDifferentOperation = !evt.getActionCommand().equals(calculator.getOperation());

        if (isDifferentOperation && !isEqualOperation && calculator.hasFirstOperand() && calculator.hasBothOperands()) {
            calculator.setOperation(evt.getActionCommand());
            calculator.enableGetNewValue();
            calculator.clearSecondOperand();

            return;
        }

        updateNumbersForOperations();

        if (!calculator.hasOperation() && !isEqualOperation) {
            calculator.setOperation(evt.getActionCommand());
        }

        if (!calculator.getShouldGetNewValue() || isEqualOperation) {
            makeCalculation();
        }

        if (!isEqualOperation) {
            calculator.clearSecondOperand();
        }

        if (!isEqualOperation) {
            calculator.setOperation(evt.getActionCommand());
            calculator.enableGetNewValue();
        }
    }

    private void makeCalculation() {
        if (!calculator.hasBothOperands()) {
            return;
        }

        double result;

        switch (calculator.getOperation()) {
            case "+":
                result = calculator.sum();
                break;

            case "-":
                result = calculator.subtract();
                break;

            case "*":
                result = calculator.multiply();
                break;

            case "/":
                result = calculator.divide();
                break;

            default:
                result = 0;
                break;
        }

        calculator.setFirstOperand(result);

        String newText = decimalFormat.format(result);
        resultTextField.setText(newText);
    }

    private void deleteCharFromTextField() {
        String resultText = resultTextField.getText();

        if (!resultText.isEmpty() && !"0".equals(resultText)) {
            resultText = resultText.substring(0, resultText.length() - 1);

            if (resultText.isEmpty()) {
                resultText = "0";
            }

            resultTextField.setText(resultText);
        }
    }

    public void clear() {
        calculator = new Calculator();
        resultTextField.setText("0");
    }
}

package calculator;

public class Calculator {
    private Double lhsNumber = null;
    private Double rhsNumber = null;
    private boolean shouldGetNewValue = true;
    private String operation = "";

    public boolean getShouldGetNewValue() {
        return shouldGetNewValue;
    }

    public void disableGetNewValue() {
        shouldGetNewValue = false;
    }

    public void enableGetNewValue() {
        shouldGetNewValue = true;
    }

    public boolean hasFirstOperand() {
        return lhsNumber != null;
    }

    public boolean hasSecondOperand() {
        return rhsNumber != null;
    }

    public boolean hasBothOperands() {
        return hasFirstOperand() && hasSecondOperand();
    }

    public void setFirstOperand(Double value) {
        lhsNumber = value;
    }

    public void setSecondOperand(Double value) {
        rhsNumber = value;
    }

    public void clearSecondOperand() {
        rhsNumber = null;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String value) {
        operation = value;
    }

    public boolean hasOperation() {
        return !operation.isEmpty();
    }

    public double sum() {
        return lhsNumber + rhsNumber;
    }

    public double subtract() {
        return lhsNumber - rhsNumber;
    }

    public double multiply() {
        return lhsNumber * rhsNumber;
    }

    public double divide() {
        return lhsNumber / rhsNumber;
    }
}

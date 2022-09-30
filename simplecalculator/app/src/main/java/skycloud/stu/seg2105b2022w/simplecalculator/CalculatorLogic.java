package skycloud.stu.seg2105b2022w.simplecalculator;

public class CalculatorLogic {
    private int number;
    private int lastNumber;
    private String currentOperation;
    private final CalculatorLayout layout;
    public CalculatorLogic(CalculatorLayout layout)
    {
        number=0;
        lastNumber=0;
        currentOperation="";
        this.layout=layout;
    }
    public void onNumberClick(int number)
    {
        this.number *=10;
        this.number += number;
        layout.updateDisplay(String.valueOf(this.number));
    }
    public void onOperationClick(String operation)
    {
        calculate();
        currentOperation=operation;
    }
    private int calculate()
    {
        switch (currentOperation)
        {
            case "+":
                lastNumber=lastNumber+number;
                break;
            case "-":
                lastNumber=lastNumber-number;
                break;
            case "*":
                lastNumber=lastNumber*number;
                break;
            case "/":
                lastNumber=lastNumber/number;
                break;
            case "":
                lastNumber=number;
                break;
        }
        number=0;
        currentOperation="";
        return lastNumber;
    }
    public void onEqualClick()
    {
        calculate();
        layout.updateDisplay(String.valueOf(lastNumber));
    }
    public void onClearClick()
    {
        number=0;
        lastNumber=0;
        currentOperation="";
        layout.updateDisplay(String.valueOf(number));
    }
}

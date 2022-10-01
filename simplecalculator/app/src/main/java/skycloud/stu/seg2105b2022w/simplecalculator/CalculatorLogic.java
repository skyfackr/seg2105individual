package skycloud.stu.seg2105b2022w.simplecalculator;

public class CalculatorLogic {
    private int number;
    private int numberAfterPoint;
    private double lastNumber;
    private String currentOperation;
    private final CalculatorLayout layout;
    private boolean pointClicked;
    public CalculatorLogic(CalculatorLayout layout)
    {
        number=0;
        lastNumber=0;
        currentOperation="";
        this.layout=layout;
        pointClicked=false;
    }
    public void onNumberClick(int number)
    {
        if (!pointClicked) {
            this.number *= 10;
            this.number += number;
            layout.updateDisplay(String.valueOf(this.number));
        }
        else
        {
            numberAfterPoint*=10;
            numberAfterPoint+=number;
            layout.updateDisplay(String.valueOf(0.1*(String.valueOf(numberAfterPoint).length()-2)+number));
        }

    }
    public void onOperationClick(String operation)
    {
        calculate();
        currentOperation=operation;
    }
    private double  calculate()
    {
        double actualNumber=0.1*(String.valueOf(numberAfterPoint).length()-2)+number;
        switch (currentOperation)
        {
            case "+":
                lastNumber=lastNumber+actualNumber;
                break;
            case "-":
                lastNumber=lastNumber-actualNumber;
                break;
            case "*":
                lastNumber=lastNumber*actualNumber;
                break;
            case "/":
                lastNumber=lastNumber/actualNumber;
                break;
            case "":
                lastNumber=actualNumber;
                break;
        }
        number=0;
        numberAfterPoint=0;
        currentOperation="";
        pointClicked=false;
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
        numberAfterPoint=0;
        pointClicked=false;
        currentOperation="";
        layout.updateDisplay(String.valueOf(number));
    }
    public void onPointClick()
    {
        pointClicked=true;
    }
}

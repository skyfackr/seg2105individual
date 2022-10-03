package skycloud.stu.seg2105b2022w.simplecalculator;

public class CalculatorLogic {
    private int number;
    private int numberAfterPoint;
    private double lastNumber;
    private String currentOperation;
    private final MainActivity layout;
    private boolean pointClicked;
    public CalculatorLogic(MainActivity layout)
    {
        number=0;
        lastNumber=0;
        currentOperation="";
        this.layout=layout;
        pointClicked=false;
    }
    public void onNumberClick(int number)
    {
        System.out.println("Number Clicked: "+number);
        if (!pointClicked) {
            this.number *= 10;
            this.number += number;
            layout.updateDisplay(String.valueOf(this.number));
        }
        else
        {
            numberAfterPoint*=10;
            numberAfterPoint+=number;
            layout.updateDisplay(String.valueOf(0.1*(String.valueOf(numberAfterPoint).length())*numberAfterPoint+number));
        }
        log();
    }
    public void onOperationClick(String operation)
    {
        System.out.println("Operation Clicked: "+operation);
        if (currentOperation.isEmpty()||number!=0)
            calculate();
        else
        {
            System.out.println("Operation already exist and will be overwritten since number is 0");
        }
        currentOperation=operation;
        log();
    }
    private double  calculate()
    {
        double actualNumber=0.1*(String.valueOf(numberAfterPoint).length())*numberAfterPoint+number;
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
                if (actualNumber!=0)
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
        System.out.println("Equal Clicked");
        calculate();
        layout.updateDisplay(String.valueOf(lastNumber));
        log();
    }
    public void onClearClick()
    {
        System.out.println("Clear Clicked");
        number=0;
        lastNumber=0;
        numberAfterPoint=0;
        pointClicked=false;
        currentOperation="";
        layout.updateDisplay(String.valueOf(number));
        log();
    }
    public void onPointClick()
    {
        System.out.println("Point Clicked");
        pointClicked=true;
        log();
    }
    private void log()
    {
        System.out.println("Number: "+number);
        System.out.println("Last Number: "+lastNumber);
        System.out.println("Current Operation: "+(currentOperation.isEmpty()? "None":currentOperation));
        System.out.println("numberAfterPoint = " + numberAfterPoint);
        System.out.println("pointClicked = " + pointClicked);
    }
}

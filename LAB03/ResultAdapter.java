package LAB03;

import java.beans.Expression;


public class ResultAdapter extends ExpressionBuilder {
    private Expression expression;
    public ResultAdapter(Expression expression) {
        this.expression = expression;
    }

    @Override
    public double build() {
        double result1 = result;
        String finalresult;
        boolean b = result < 10;
        if(b == true){
            finalresult = result + "10 ^(0)";
        }
        else{
            double i=0;
            double significand=0;
            boolean countinue = true;
            while (countinue) {
                significand=result/10;
                if (significand>=10) {
                    i = i + 1;
                }
                else {
                    countinue = false;
                }
            }
            finalresult = significand + "10^(" + i + ")";

        }

        result = Double.parseDouble(finalresult);
        return result;
    }
}
import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;
import java.util.function.*;


public class App {
    public static void main(String[] args) throws Exception {
        String s= "pow(x,2)-4";
        double a=0;
        double b=10;
        double epsilon=1.0e-15;
        Expression e0 = new ExpressionBuilder(s).variables("x").build();
        Function<Double, Double> f = x -> e0.setVariable("x", x).evaluate();
        // method chain

        Bisezione b1 = new Bisezione(-5, 5, 0.0001);

        System.out.println(b1.calcoloEpsilonFunzine());
        System.out.println(b1);
    }
}

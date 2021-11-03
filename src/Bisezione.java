import java.util.*;

public class Bisezione {
    /******************** attributi ********************/
    private double a;
    private double b;
    private double epsilon = 0.0001; // valore di approssimazione

    /******************** costruttori ********************/
    public Bisezione() {

    }

    public Bisezione(double a, double b, double epsilon) {
        this.a = a;
        this.b = b;
        this.epsilon = epsilon;
    }

    /******************** getter & setter ********************/
    public double getA() {
        return this.a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return this.b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public double getEpsilon() {
        return this.epsilon;
    }

    public void setEpsilon(double epsilon) {
        this.epsilon = epsilon;
    }

    /******************** metodi ********************/
    public double funzione(double x) {
        return x * x - 4;
    }

    public double calcolo() {
        double c;
        double fc;
        double fa = funzione(a);
      

        do {
            c = (a + b) / 2;
            fc = funzione(c);

            if (fa * fc > 0 && b > a) { // condizione che ci permette di determinare se "a" e "b" comprendono "c"  
                a = c;

                if (fc == 0) {
                    break;
                }
                
            } else if (fc * fa < 0) {
                b = c;
            }

        } while (Math.abs(a - b) > epsilon);

        return c;
    }

    public double calcoloEpsilonFunzine() {
        double c = 0;
        double fa = funzione(a);
        double fc;

        do {
            c = (a + b) / 2;
            fc = funzione(c);

            if (fa * fc > 0 && b > a) { // condizione che ci permette di determinare se "a" e "b" comprendono "c"  
                a = c;
            } else if (fc * fa < 0) {
                b = c;
            }
        } while (Math.abs(funzione(a) - funzione(b)) > epsilon);

        return c;
    }

    public Bisezione a(double a) {
        setA(a);
        return this;
    }

    public Bisezione b(double b) {
        setB(b);
        return this;
    }

    public Bisezione epsilon(double epsilon) {
        setEpsilon(epsilon);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Bisezione)) {
            return false;
        }
        Bisezione bisezione = (Bisezione) o;
        return a == bisezione.a && b == bisezione.b && epsilon == bisezione.epsilon;
    }

    @Override
    public int hashCode() {
        return Objects.hash(a, b, epsilon);
    }

    @Override
    public String toString() {
        return "{" +
            " a='" + getA() + "'" +
            ", b='" + getB() + "'" +
            ", epsilon='" + getEpsilon() + "'" +
            "}";
    }
}
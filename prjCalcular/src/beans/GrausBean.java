package beans;
import javax.ejb.Local;
import javax.ejb.Stateless;

@Stateless
@Local
public class GrausBean {
    
    public double converterParaFahrenheit(double c) {
     return c * 1.8 + 32;
    }
}

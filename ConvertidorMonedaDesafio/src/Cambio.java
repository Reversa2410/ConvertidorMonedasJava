import java.util.Map;

public class  Cambio {
//(String results, base_code, Double conversion_rates)
    private String base_code;
    private Map<String, Double> conversion_rates;

    public String getBase_code()
    {
        return base_code;
    }

    public Map<String, Double> getConversion_rates()
    {
        return conversion_rates;
    }


}

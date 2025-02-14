public class Individual extends TaxPayer {

    private Double healthExpenditures;

    public Individual(){

    }

    public Individual(String name, Double anualIncome, Double healthExpenditures) {
        super(anualIncome, name);
        this.healthExpenditures = healthExpenditures;
    }

    public Double getHealthExpenditures() {
        return healthExpenditures;
    }

    public void setHealthExpenditures(Double healthExpenditures) {
        this.healthExpenditures = healthExpenditures;
    }

    @Override
    public double tax() {
        double TaxI = 0;
        if(getAnualIncome() < 20000.00){
           TaxI += getAnualIncome() * 0.15;
        }else {
            TaxI += getAnualIncome() * 0.25;
        }
        if(getHealthExpenditures() > 0){
            TaxI -= getHealthExpenditures() * 0.50;
        }
        return TaxI;
    }
}

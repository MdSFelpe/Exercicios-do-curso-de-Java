public class Company extends TaxPayer {

    private int numberOfEmployees;

    public Company(String name, Double anualIncome, int numberOfEmployees) {
        super(anualIncome, name);
        this.numberOfEmployees = numberOfEmployees;
    }

    public int getNumberOfEmployees() {
        return numberOfEmployees;
    }

    public void setNumberOfEmployees(int numberOfEmployees) {
        this.numberOfEmployees = numberOfEmployees;
    }

    @Override
    public double tax() {
        double Taxj = 0;
        if (numberOfEmployees > 10){
           Taxj += getAnualIncome() * 0.14;
        }else {
            Taxj += getAnualIncome() * 0.16;
        }
        return Taxj;
    }
}

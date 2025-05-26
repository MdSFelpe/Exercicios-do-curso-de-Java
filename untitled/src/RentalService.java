import java.time.Duration;

public class RentalService {

    private Double pricePerHour;
    private Double pricePerDay;

    private TaxService taxService;

    public RentalService(Double pricePerHour, Double pricePerDay, TaxService taxService) {
        this.pricePerHour = pricePerHour;
        this.pricePerDay = pricePerDay;
        this.taxService = taxService;
    }

    public void processInvoice(CarRental carRental) {

        // Calcular a diferença em minutos
        double minutes = Duration.between(carRental.getStart(), carRental.getFinish()).toMinutes();
        // Calcular as horas totais, arredondando para cima
        double hours = Math.ceil(minutes / 60.0);

        double basicPayment;

        // Se a quantidade de horas for <= 12, usamos o valor por hora
        if (hours <= 12.0) {
            basicPayment = pricePerHour * hours;
        }
        // Caso contrário, usamos o valor diário
        else {
            basicPayment = pricePerDay * Math.ceil(hours / 24.0);  // Caso de mais de um dia
        }

        double tax = taxService.tax(basicPayment);

        carRental.setInvoice(new Invoice(basicPayment, tax));
    }
}

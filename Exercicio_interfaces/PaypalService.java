public class PaypalService implements OnlinePaymentService{


    private static final double FEE_PERCENTAGE = 0.02; //cria uma varíavel imutavel para taxa de pagamento online
    private static final double MONTHLY_INTEREST = 0.01; // e os juros por cima de cada parcela

    @Override
    public double paymentFee(double amount) {
        return amount * FEE_PERCENTAGE;
    }


    @Override
    public double Interest(double amount, int months) {
        return amount * MONTHLY_INTEREST * months;
    }
}

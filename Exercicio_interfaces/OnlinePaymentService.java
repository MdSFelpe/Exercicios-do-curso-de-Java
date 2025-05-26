
//Interface serve como um modelo para outros,caso alguma classe vá implementar essa interface
//ela precisa ter os metodos paymentFee e Interest
public interface OnlinePaymentService {

    double paymentFee(double amount);

    double Interest(double amount, int months);

}



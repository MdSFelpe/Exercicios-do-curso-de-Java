class WithdrawLimitException extends RuntimeException {
    public WithdrawLimitException(String message) {
        super(message);
    }
}
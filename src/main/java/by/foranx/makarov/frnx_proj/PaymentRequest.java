package by.foranx.makarov.frnx_proj;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class PaymentRequest {

    @NotBlank(message = "Request ID is required")
    private String request_id;

    @NotBlank(message = "Loan ID is required")
    private String loan_id;

    @NotBlank(message = "Terminal ID is required")
    private String terminal_id;

    @NotBlank(message = "Merchant ID is required")
    private String merchant_id;

    @NotBlank(message = "NSPC Trans ID is required")
    private String nspc_trans_id;

    @NotNull(message = "Amount is required")
    @Pattern(regexp = "\\d+", message = "Amount must be a number")
    private String amount;

    @NotNull(message = "Commission Amount is required")
    @Pattern(regexp = "\\d+", message = "Commission Amount must be a number")
    private String commission_amount;

    @NotBlank(message = "Payment Type is required")
    private String payment_type;

    @NotBlank(message = "Card Type is required")
    private String card_type;

    @NotBlank(message = "Authorization Code is required")
    private String authorization_code;

    @NotBlank(message = "Payment Date is required")
    private String payment_date;

    @NotBlank(message = "Operation Number is required")
    private String operation_number;

    // Getters and setters
    public String getRequest_id() {
        return request_id;
    }

    public void setRequest_id(String request_id) {
        this.request_id = request_id;
    }

    public String getLoan_id() {
        return loan_id;
    }

    public void setLoan_id(String loan_id) {
        this.loan_id = loan_id;
    }

    public String getTerminal_id() {
        return terminal_id;
    }

    public void setTerminal_id(String terminal_id) {
        this.terminal_id = terminal_id;
    }

    public String getMerchant_id() {
        return merchant_id;
    }

    public void setMerchant_id(String merchant_id) {
        this.merchant_id = merchant_id;
    }

    public String getNspc_trans_id() {
        return nspc_trans_id;
    }

    public void setNspc_trans_id(String nspc_trans_id) {
        this.nspc_trans_id = nspc_trans_id;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getCommission_amount() {
        return commission_amount;
    }

    public void setCommission_amount(String commission_amount) {
        this.commission_amount = commission_amount;
    }

    public String getPayment_type() {
        return payment_type;
    }

    public void setPayment_type(String payment_type) {
        this.payment_type = payment_type;
    }

    public String getCard_type() {
        return card_type;
    }

    public void setCard_type(String card_type) {
        this.card_type = card_type;
    }

    public String getAuthorization_code() {
        return authorization_code;
    }

    public void setAuthorization_code(String authorization_code) {
        this.authorization_code = authorization_code;
    }

    public String getPayment_date() {
        return payment_date;
    }

    public void setPayment_date(String payment_date) {
        this.payment_date = payment_date;
    }

    public String getOperation_number() {
        return operation_number;
    }

    public void setOperation_number(String operation_number) {
        this.operation_number = operation_number;
    }
}

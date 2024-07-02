package by.foranx.makarov.frnx_proj;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name = "payment_requests")
public class PaymentRequest {

    @Id
    @NotBlank(message = "Request ID is required")
    @Column(name = "request_id")
    private String requestId;

    @NotBlank(message = "Loan ID is required")
    @Column(name = "loan_id")
    private String loanId;

    @NotBlank(message = "Terminal ID is required")
    @Column(name = "terminal_id")
    private String terminalId;

    @NotBlank(message = "Merchant ID is required")
    @Column(name = "merchant_id")
    private String merchantId;

    @NotBlank(message = "NSPC Trans ID is required")
    @Column(name = "nspc_trans_id")
    private String nspcTransId;

    @NotNull(message = "Amount is required")
    @Pattern(regexp = "\\d+", message = "Amount must be a number")
    @Column(name = "amount")
    private String amount;

    @NotNull(message = "Commission Amount is required")
    @Pattern(regexp = "\\d+", message = "Commission Amount must be a number")
    @Column(name = "commission_amount")
    private String commissionAmount;

    @NotBlank(message = "Payment Type is required")
    @Column(name = "payment_type")
    private String paymentType;

    @NotBlank(message = "Card Type is required")
    @Column(name = "card_type")
    private String cardType;

    @Pattern(regexp = "^[0-9A-Fa-f]{8}-[0-9A-Fa-f]{4}-[0-9A-Fa-f]{4}-[0-9A-Fa-f]{4}-[0-9A-Fa-f]{12}$", message = "Authorization Code must be a valid UUID")
    @NotBlank(message = "Authorization Code cannot be empty")
    @Column(name = "authorization_code")
    private String authorizationCode;

    @NotBlank(message = "Payment Date is required")
    @Column(name = "payment_date")
    private String paymentDate;

    @NotBlank(message = "Operation Number is required")
    @Column(name = "operation_number")
    private String operationNumber;

    // Getters and setters
    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getLoanId() {
        return loanId;
    }

    public void setLoanId(String loanId) {
        this.loanId = loanId;
    }

    public String getTerminalId() {
        return terminalId;
    }

    public void setTerminalId(String terminalId) {
        this.terminalId = terminalId;
    }

    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    public String getNspcTransId() {
        return nspcTransId;
    }

    public void setNspcTransId(String nspcTransId) {
        this.nspcTransId = nspcTransId;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getCommissionAmount() {
        return commissionAmount;
    }

    public void setCommissionAmount(String commissionAmount) {
        this.commissionAmount = commissionAmount;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public String getAuthorizationCode() {
        return authorizationCode;
    }

    public void setAuthorizationCode(String authorizationCode) {
        this.authorizationCode = authorizationCode;
    }

    public String getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(String paymentDate) {
        this.paymentDate = paymentDate;
    }

    public String getOperationNumber() {
        return operationNumber;
    }

    public void setOperationNumber(String operationNumber) {
        this.operationNumber = operationNumber;
    }
}

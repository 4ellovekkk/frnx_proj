package by.foranx.makarov.frnx_proj;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.NotNull;

public class PaymentRequest {

    @NotBlank(message = "fields request_id is empty")
    private String request_id;

    @NotBlank(message = "fields loan_id is empty")
    private String loan_id;

    @NotBlank(message = "fields terminal_id is empty")
    private String terminal_id;

    @NotBlank(message = "fields merchant_id is empty")
    private String merchant_id;

    @NotBlank(message = "fields nspc_trans_id is empty")
    private String nspc_trans_id;

    @NotBlank(message = "fields amount is empty")
    @Pattern(regexp = "\\d+", message = "fields amount should contain only digits")
    private String amount;

    @NotBlank(message = "fields commission_amount is empty")
    private String commission_amount;

    @NotBlank(message = "fields payment_type is empty")
    private String payment_type;

    @NotBlank(message = "fields card_type is empty")
    private String card_type;

    @NotBlank(message = "fields authorization_code is empty")
    private String authorization_code;

    @NotBlank(message = "fields payment_date is empty")
    private String payment_date;

    @NotBlank(message = "fields operation_number is empty")
    private String operation_number;

    // Getters and setters
}

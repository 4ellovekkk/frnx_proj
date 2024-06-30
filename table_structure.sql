use frnx_proj
CREATE TABLE payment_requests (
                                  request_id BIGINT PRIMARY KEY,
                                  loan_id BIGINT NOT NULL,
                                  terminal_id BIGINT NOT NULL,
                                  merchant_id BIGINT NOT NULL,
                                  nspc_trans_id BIGINT NOT NULL,
                                  amount DECIMAL(15, 2) NOT NULL,
                                  commission_amount DECIMAL(15, 2) NOT NULL,
                                  payment_type INT NOT NULL,
                                  card_type VARCHAR(255) NOT NULL,
                                  authorization_code VARCHAR(255) NOT NULL,
                                  payment_date DATE NOT NULL,
                                  operation_number BIGINT NOT NULL
);
go

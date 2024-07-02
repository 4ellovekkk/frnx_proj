package by.foranx.makarov.frnx_proj;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@Stateless
public class PaymentRequestRepository {

    private static final Logger logger = LoggerFactory.getLogger(PaymentRequestRepository.class);

    @PersistenceContext
    private EntityManager entityManager;
    @Transactional
    public void save(PaymentRequest paymentRequest) {
        logger.info("Saving PaymentRequest: {}", paymentRequest);
        try {
            String sql = "INSERT INTO payment_requests (request_id, loan_id, terminal_id, merchant_id, nspc_trans_id, amount, commission_amount, payment_type, card_type, authorization_code, payment_date, operation_number) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            entityManager.createNativeQuery(sql)
                    .setParameter(1, paymentRequest.getRequestId())
                    .setParameter(2, paymentRequest.getLoanId())
                    .setParameter(3, paymentRequest.getTerminalId())
                    .setParameter(4, paymentRequest.getMerchantId())
                    .setParameter(5, paymentRequest.getNspcTransId())
                    .setParameter(6, paymentRequest.getAmount())
                    .setParameter(7, paymentRequest.getCommissionAmount())
                    .setParameter(8, paymentRequest.getPaymentType())
                    .setParameter(9, paymentRequest.getCardType())
                    .setParameter(10, paymentRequest.getAuthorizationCode())
                    .setParameter(11, paymentRequest.getPaymentDate())
                    .setParameter(12, paymentRequest.getOperationNumber())
                    .executeUpdate();
            logger.info("Successfully saved PaymentRequest: {}", paymentRequest);
        } catch (Exception e) {
            logger.error("Error saving PaymentRequest: {}", paymentRequest, e);
            throw e;
        }
    }

    public PaymentRequest findById(String requestId) {
        logger.info("Finding PaymentRequest by ID: {}", requestId);
        PaymentRequest paymentRequest = entityManager.find(PaymentRequest.class, requestId);
        if (paymentRequest != null) {
            logger.info("Found PaymentRequest: {}", paymentRequest);
        } else {
            logger.warn("No PaymentRequest found with ID: {}", requestId);
        }
        return paymentRequest;
    }

    @Transactional
    public void update(PaymentRequest paymentRequest) {
        logger.info("Updating PaymentRequest: {}", paymentRequest);
        try {
            entityManager.merge(paymentRequest);
            logger.info("Successfully updated PaymentRequest: {}", paymentRequest);
        } catch (Exception e) {
            logger.error("Error updating PaymentRequest: {}", paymentRequest, e);
            throw e;
        }
    }

    @Transactional
    public void delete(String requestId) {
        logger.info("Deleting PaymentRequest with ID: {}", requestId);
        try {
            PaymentRequest paymentRequest = findById(requestId);
            if (paymentRequest != null) {
                entityManager.remove(paymentRequest);
                logger.info("Successfully deleted PaymentRequest with ID: {}", requestId);
            } else {
                logger.warn("No PaymentRequest found with ID: {}", requestId);
            }
        } catch (Exception e) {
            logger.error("Error deleting PaymentRequest with ID: {}", requestId, e);
            throw e;
        }
    }

    public List<PaymentRequest> findAll() {
        logger.info("Finding all PaymentRequests");
        List<PaymentRequest> paymentRequests = entityManager.createQuery("SELECT p FROM PaymentRequest p", PaymentRequest.class).getResultList();
        logger.info("Found {} PaymentRequests", paymentRequests.size());
        return paymentRequests;
    }
}

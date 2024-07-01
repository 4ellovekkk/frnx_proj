package by.foranx.makarov.frnx_proj;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
@ApplicationScoped
public class PaymentRequestDAO {

    @PersistenceContext
    private EntityManager em;

    @Transactional
    public void save(PaymentRequest paymentRequest) {
        em.persist(paymentRequest);
    }
}

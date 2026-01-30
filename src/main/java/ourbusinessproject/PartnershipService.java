package ourbusinessproject;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class PartnershipService {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public Partnership newPartnership(Project project, Enterprise partnerEnterprise) {
        Partnership partnership = new Partnership(new Date(), project, partnerEnterprise);

        this.entityManager.persist(partnership);
        this.entityManager.flush();
        return partnership;
    }

    public Partnership findPartnershipById(Long id) {
        return this.entityManager.find(Partnership.class, id);
    }

    @Transactional
    public void remove(Partnership partnership) {
        this.entityManager.remove(partnership);
        this.entityManager.flush();
    }
}

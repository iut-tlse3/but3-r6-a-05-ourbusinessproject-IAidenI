package ourbusinessproject;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityResult;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class EnterpriseProjectService {

    @PersistenceContext
    private EntityManager entityManager;

    EnterpriseProjectService(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public Project newProject(String title, String description, Enterprise enterprise) {
        Project project = new Project(title, description, enterprise);

        this.entityManager.persist(project);
        this.entityManager.flush();

        return project;
    }

    public Enterprise newEnterprise(String name, String description, String contactName, String contactEmail) {
        Enterprise enterprise = new Enterprise(name, description, contactName, contactEmail);

        this.entityManager.persist(enterprise);
        this.entityManager.flush();

        return enterprise;
    }

    public Project findProjectById(Long id) {
        return this.entityManager.find(Project.class, id);
    }

    public Enterprise findEnterpriseById(Long id) {
        return this.entityManager.find(Enterprise.class, id);
    }
}

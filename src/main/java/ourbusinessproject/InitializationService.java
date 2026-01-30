package ourbusinessproject;

import org.springframework.stereotype.Service;

@Service
public class InitializationService {
    private final EnterpriseProjectService enterpriseProjectService;

    private Project project1E1;
    private Project project1E2;
    private Project project2E1;

    private Enterprise enterprise1;
    private Enterprise enterprise2;

    InitializationService(EnterpriseProjectService enterpriseProjectService) {
        this.enterpriseProjectService = enterpriseProjectService;
    }

    public void initProjects() {
        /*
         * Les créations des objets sont faites dans la phase de bootstrap.
         * Quand on a volontairement rendu le dernier projet invalide,
         * une exception a été levée pendant initProjects().
         * Comme l’initialisation s’exécute dans un contexte transactionnel,
         * l’échec d’une seule insertion provoque un rollback de la transaction entière.
         */
        this.enterprise1 = enterpriseProjectService.newEnterprise("entreprise1", "description1", "contactName1", "Contact1@gmail.com");
        this.enterprise2 = enterpriseProjectService.newEnterprise("entreprise2", "description2", "contactName2", "Contact2@gmail.com");

        this.project1E1 = enterpriseProjectService.newProject("projet1E1", "description1E1", this.enterprise1);
        this.project1E2 = enterpriseProjectService.newProject("projet1E2", "description1E2", this.enterprise2);
        this.project2E1 = enterpriseProjectService.newProject("projet2E1", "description2E1", this.enterprise1);
    }

    public Project getProject1E1() {
        return this.project1E1;
    }

    public Project getProject1E2() {
        return this.project1E2;
    }

    public Project getProject2E1() {
        return this.project2E1;
    }

    public Enterprise getEnterprise1() {
        return this.enterprise1;
    }

    public Enterprise getEnterprise2() {
        return this.enterprise2;
    }
}

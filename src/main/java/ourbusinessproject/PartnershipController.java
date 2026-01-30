package ourbusinessproject;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/partnerships")
public class PartnershipController {
    private final EnterpriseProjectService enterpriseProjectService;
    private final PartnershipService partnershipService;

    PartnershipController(EnterpriseProjectService enterpriseProjectService, PartnershipService partnershipService) {
        this.enterpriseProjectService = enterpriseProjectService;
        this.partnershipService = partnershipService;
    }

    @PostMapping
    public Partnership addPartnership(@RequestParam("project_id") Long projectId, @RequestParam("enterprise_id") Long enterpriseId) {
        Project project = this.enterpriseProjectService.findProjectById(projectId);
        Enterprise enterprise = this.enterpriseProjectService.findEnterpriseById(enterpriseId);
        return this.partnershipService.newPartnership(project, enterprise);
    }

    @DeleteMapping("/{id}")
    public void removePartnership(@PathVariable("id") Long partnershipId) {
        Partnership partnership = this.partnershipService.findPartnershipById(partnershipId);
        this.partnershipService.remove(partnership);
    }
}

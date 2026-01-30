package ourbusinessproject;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProjectController {
    private final EnterpriseProjectService enterpriseProjectService;

    ProjectController(EnterpriseProjectService enterpriseProjectService) {
        this.enterpriseProjectService = enterpriseProjectService;
    }

    @GetMapping("/api/projects")
    public List<Project> findAllProjectsWithEnterprises() {
        return this.enterpriseProjectService.findAllProjects();
    }
}

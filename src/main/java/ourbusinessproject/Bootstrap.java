package ourbusinessproject;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

@Service
public class Bootstrap {
    private final InitializationService initializationService;

    Bootstrap(InitializationService initializationService) {
        this.initializationService = initializationService;
    }

    @PostConstruct
    public void init() {
        try {
            initializationService.initProjects();
            initializationService.initPartnerships();
        } catch (RuntimeException ignored) {}
    }


    public InitializationService getInitializationService() {
        return this.initializationService;
    }
}

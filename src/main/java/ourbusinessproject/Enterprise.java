package ourbusinessproject;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

import java.util.Collection;
import java.util.HashSet;

@Entity
@Table(name = "enterprises")
public class Enterprise {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty
    private String name;

    @Size(min=10)
    private String description;

    @NotEmpty
    private String contactName;

    @NotEmpty
    @Email
    private String contactEmail;

    @OneToMany(mappedBy = "enterprise")
    @JsonIgnore
    private Collection<Project> projects;

    Enterprise() {}

    Enterprise(String name, String description, String contactName, String contactEmail) {
        this.name = name;
        this.description = description;
        this.contactName = contactName;
        this.contactEmail = contactEmail;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public Collection<Project> getProjects() {
        return this.projects;
    }

    public Long getId() {
        return id;
    }

    public void addProject(Project project) {
        if (this.projects == null) this.projects = new HashSet<>();
        this.projects.add(project);
    }

    public String getName() {
        return this.name;
    }
}

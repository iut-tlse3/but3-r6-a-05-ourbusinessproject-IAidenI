package ourbusinessproject;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "enterprises")
public class Enterprise {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty
    @Column(name = "name", nullable = false)
    private String name;

    @Size(min=10)
    @Column(name = "description")
    private String description;

    @NotEmpty
    @Column(name = "contact_name", nullable = false)
    private String contactName;

    @NotEmpty
    @Email
    @Column(name = "contact_email", nullable = false)
    private String contactEmail;

    Enterprise() {

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
}

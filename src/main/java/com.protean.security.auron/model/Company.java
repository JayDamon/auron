package com.protean.security.auron.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(
        name = "company", uniqueConstraints = {
                @UniqueConstraint(columnNames = {
                        "company_name"
                })
})
public class Company extends DateAuditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max=40)
    @Column(name = "company_name")
    private String companyName;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "company", orphanRemoval = true)
    private Set<User> users = new HashSet<>();

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name="company_feature",
            joinColumns = { @JoinColumn(name = "company_id") },
            inverseJoinColumns = { @JoinColumn(name = "feature_id") }
    )
    private Set<Feature> features = new HashSet<>();

    public Company() {
    }

    public Company(Long id, @NotBlank @Size(max = 40) String companyName) {
        this.companyName = companyName;
    }

    public Company(@NotBlank @Size(max = 40) String companyName, Set<User> users, Set<Feature> features) {
        this.companyName = companyName;
        this.users = users;
        this.features = features;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public Set<Feature> getFeatures() {
        return features;
    }

    public void setFeatures(Set<Feature> features) {
        this.features = features;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Company company = (Company) o;
        return Objects.equals(id, company.id) &&
                Objects.equals(companyName, company.companyName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, companyName);
    }

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", companyName='" + companyName + '\'' +
                '}';
    }
}

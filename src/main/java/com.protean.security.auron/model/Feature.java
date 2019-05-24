package com.protean.security.auron.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "feature")
public class Feature {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "feature_name")
    private String name;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "feature_type_id")
    private FeatureType featureType;

    @ManyToOne
    @JoinColumn(name = "application_id", nullable = false)
    private Application application;

    @ManyToMany(mappedBy = "features",
            cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Set<Company> companies = new HashSet<>();

    @ManyToMany(mappedBy = "features",
        cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Set<User> users = new HashSet<>();

    public Feature() {
    }

    public Feature(String name, FeatureType featureType, Application application, Set<Company> companies, Set<User> users) {
        this.name = name;
        this.featureType = featureType;
        this.application = application;
        this.companies = companies;
        this.users = users;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public FeatureType getFeatureType() {
        return featureType;
    }

    public void setFeatureType(FeatureType featureType) {
        this.featureType = featureType;
    }

    public Application getApplication() {
        return application;
    }

    public void setApplication(Application application) {
        this.application = application;
    }

    public Set<Company> getCompanies() {
        return companies;
    }

    public void setCompanies(Set<Company> companies) {
        this.companies = companies;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Feature feature = (Feature) o;
        return Objects.equals(id, feature.id) &&
                Objects.equals(name, feature.name) &&
                Objects.equals(featureType, feature.featureType) &&
                Objects.equals(application, feature.application);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, featureType, application);
    }

    @Override
    public String toString() {
        return "Feature{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", featureType=" + featureType +
                ", application=" + application +
                '}';
    }
}

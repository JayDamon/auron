package com.protean.security.auron.model;

import org.hibernate.annotations.NaturalId;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "application")
public class Application {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Enumerated(EnumType.STRING)
    @NaturalId
    @Column(name = "application_name", length = 20)
    private ApplicationName applicationName;

    @OneToMany(mappedBy = "application", fetch = FetchType.LAZY)
    private Set<Feature> features;

    public Application() {
    }

    public Application(ApplicationName applicationName, Set<Feature> features) {
        this.applicationName = applicationName;
        this.features = features;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ApplicationName getApplicationName() {
        return applicationName;
    }

    public void setApplicationName(ApplicationName applicationName) {
        this.applicationName = applicationName;
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
        Application that = (Application) o;
        return Objects.equals(id, that.id) &&
                applicationName == that.applicationName;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, applicationName);
    }

    @Override
    public String toString() {
        return "Application{" +
                "id=" + id +
                ", applicationName=" + applicationName +
                '}';
    }
}

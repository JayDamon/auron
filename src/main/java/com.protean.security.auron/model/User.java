package com.protean.security.auron.model;

import org.hibernate.annotations.NaturalId;

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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "app_user", uniqueConstraints = {
        @UniqueConstraint(columnNames = {
                "username"
        }),
        @UniqueConstraint(columnNames = {
                "email"
        })
})
public class User extends DateAuditable {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @NotBlank
        @Size(max = 40)
        @Column(name = "first_name")
        private String firstName;

        @NotBlank
        @Size(max = 40)
        @Column(name = "middle_name")
        private String middleName;

        @NotBlank
        @Size(max = 40)
        @Column(name = "last_name")
        private String lastName;

        @NotBlank
        @Size(max = 15)
        @Column(name = "username")
        private String username;

        @NaturalId
        @NotBlank
        @Size(max = 40)
        @Email
        @Column(name = "email")
        private String email;

        @NotBlank
        @Size(max = 100)
        @Column(name = "password")
        private String password;

        @ManyToOne
        @JoinColumn(name="company_id")
        private Company company;

        @ManyToMany(fetch = FetchType.LAZY, cascade =
                {CascadeType.PERSIST, CascadeType.MERGE})
        @JoinTable(name = "user_feature",
                joinColumns = @JoinColumn(name = "user_id"),
                inverseJoinColumns = @JoinColumn(name = "feature_id"))
        private Set<Feature> features = new HashSet<>();

        public User() {}

        public User(@NotBlank @Size(max = 40) String firstName, @NotBlank @Size(max = 40) String middleName, @NotBlank @Size(max = 40) String lastName, @NotBlank @Size(max = 15) String username, @NotBlank @Size(max = 40) @Email String email, @NotBlank @Size(max = 100) String password, @NotBlank Company company) {
                this.firstName = firstName;
                this.middleName = middleName;
                this.lastName = lastName;
                this.username = username;
                this.email = email;
                this.password = password;
                this.company = company;
        }

        public Long getId() {
                return id;
        }

        public void setId(Long id) {
                this.id = id;
        }

        public String getFirstName() {
                return firstName;
        }

        public void setFirstName(String firstName) {
                this.firstName = firstName;
        }

        public String getMiddleName() {
                return middleName;
        }

        public void setMiddleName(String middleName) {
                this.middleName = middleName;
        }

        public String getLastName() {
                return lastName;
        }

        public void setLastName(String lastName) {
                this.lastName = lastName;
        }

        public String getUsername() {
                return username;
        }

        public void setUsername(String username) {
                this.username = username;
        }

        public String getEmail() {
                return email;
        }

        public void setEmail(String email) {
                this.email = email;
        }

        public String getPassword() {
                return password;
        }

        public void setPassword(String password) {
                this.password = password;
        }

        public Company getCompany() {
                return company;
        }

        public void setCompany(Company company) {
                this.company = company;
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
                User user = (User) o;
                return Objects.equals(id, user.id) &&
                        Objects.equals(firstName, user.firstName) &&
                        Objects.equals(middleName, user.middleName) &&
                        Objects.equals(lastName, user.lastName) &&
                        Objects.equals(username, user.username) &&
                        Objects.equals(email, user.email) &&
                        Objects.equals(password, user.password) &&
                        Objects.equals(company.getId(), user.company.getId());
        }

        @Override
        public int hashCode() {
                return Objects.hash(id, firstName, middleName, lastName, username, email, password, company.getId());
        }

        @Override
        public String toString() {
                return "User{" +
                        "id=" + id +
                        ", firstName='" + firstName + '\'' +
                        ", middleName='" + middleName + '\'' +
                        ", lastName='" + lastName + '\'' +
                        ", username='" + username + '\'' +
                        ", email='" + email + '\'' +
                        ", password='" + password + '\'' +
                        ", company=" + company.getId() +
                        '}';
        }
}

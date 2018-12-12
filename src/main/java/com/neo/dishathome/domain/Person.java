package com.neo.dishathome.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;
import java.util.Objects;

/**
 * [OK] The Person entity yes.
 */
@ApiModel(description = "[OK] The Person entity yes.")
@Entity
@Table(name = "person")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Person implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "birthday")
    private Instant birthday;

    @Column(name = "address")
    private String address;

    @OneToOne    @JoinColumn(unique = true)
    private Kitchen cooker;

    @OneToMany(mappedBy = "person")
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<OrderPreparation> orders = new HashSet<>();
    @OneToMany(mappedBy = "person")
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<Comment> comments = new HashSet<>();
    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public Person firstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Person lastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public Person email(String email) {
        this.email = email;
        return this;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Person phoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Instant getBirthday() {
        return birthday;
    }

    public Person birthday(Instant birthday) {
        this.birthday = birthday;
        return this;
    }

    public void setBirthday(Instant birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public Person address(String address) {
        this.address = address;
        return this;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Kitchen getCooker() {
        return cooker;
    }

    public Person cooker(Kitchen kitchen) {
        this.cooker = kitchen;
        return this;
    }

    public void setCooker(Kitchen kitchen) {
        this.cooker = kitchen;
    }

    public Set<OrderPreparation> getOrders() {
        return orders;
    }

    public Person orders(Set<OrderPreparation> orderPreparations) {
        this.orders = orderPreparations;
        return this;
    }

    public Person addOrder(OrderPreparation orderPreparation) {
        this.orders.add(orderPreparation);
        orderPreparation.setPerson(this);
        return this;
    }

    public Person removeOrder(OrderPreparation orderPreparation) {
        this.orders.remove(orderPreparation);
        orderPreparation.setPerson(null);
        return this;
    }

    public void setOrders(Set<OrderPreparation> orderPreparations) {
        this.orders = orderPreparations;
    }

    public Set<Comment> getComments() {
        return comments;
    }

    public Person comments(Set<Comment> comments) {
        this.comments = comments;
        return this;
    }

    public Person addComment(Comment comment) {
        this.comments.add(comment);
        comment.setPerson(this);
        return this;
    }

    public Person removeComment(Comment comment) {
        this.comments.remove(comment);
        comment.setPerson(null);
        return this;
    }

    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Person person = (Person) o;
        if (person.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), person.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Person{" +
            "id=" + getId() +
            ", firstName='" + getFirstName() + "'" +
            ", lastName='" + getLastName() + "'" +
            ", email='" + getEmail() + "'" +
            ", phoneNumber='" + getPhoneNumber() + "'" +
            ", birthday='" + getBirthday() + "'" +
            ", address='" + getAddress() + "'" +
            "}";
    }
}

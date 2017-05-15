package org.jazzteam.model.table;

import javax.persistence.*;

import java.io.Serializable;

import static javax.persistence.GenerationType.*;

@Entity
@Table(name = "story")
public class Story implements Serializable {
    private Integer idStory;
    private Apartment apartment;
    private User user;

    public Story() {

    }

    public Story(Apartment apartment, User user) {
        this.apartment = apartment;
        this.user = user;
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "idstory")
    public Integer getIdStory() {
        return idStory;
    }

    public void setIdStory(Integer idStory) {
        this.idStory = idStory;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idapartment")
    public Apartment getApartment() {
        return apartment;
    }

    public void setApartment(Apartment apartment) {
        this.apartment = apartment;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "iduser")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

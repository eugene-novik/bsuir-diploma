package org.jazzteam.model.table;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.GenerationType.*;

@Entity
@Table(name = "apartment")
public class Apartment implements Serializable {
    private Integer idApartment;
    private String document;
    private int price;
    private String status;
    private int rating;
    private String description;
    private User user;
    private List<Image> images = new ArrayList<Image>();
    private List<Story> stories=new ArrayList<Story>();

    public Apartment() {

    }

    public Apartment(String document, int price, String status, int rating, String description) {
        this.document = document;
        this.price = price;
        this.status = status;
        this.rating = rating;
        this.description = description;

    }

    public Apartment(String document, int price, String status, int rating, User user) {
        this.document = document;
        this.price = price;
        this.status = status;
        this.rating = rating;
        this.user = user;

    }

    public Apartment(String document, int price, String status, int rating, User user, List<Image> images) {
        this.document = document;
        this.price = price;
        this.status = status;
        this.rating = rating;
        this.user = user;
        this.images = images;
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "idapartment")
    public Integer getIdApartment() {
        return idApartment;
    }

    public void setIdApartment(Integer idApartment) {
        this.idApartment = idApartment;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "iduser")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "apartment")
    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "apartment")
    public List<Story> getStories() {
        return stories;
    }

    public void setStories(List<Story> stories) {
        this.stories = stories;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

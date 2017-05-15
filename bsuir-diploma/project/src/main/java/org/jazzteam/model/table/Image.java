package org.jazzteam.model.table;

import javax.persistence.*;
import java.io.Serializable;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "image")
public class Image implements Serializable {
    private Integer idImage;
    private String image;
    private String description;
    private Apartment apartment;

    public Image() {

    }

    public Image(String image, String description) {
        this.image = image;
        this.description = description;
    }

    public Image(String image, String description, Apartment apartment) {
        this.image = image;
        this.description = description;
        this.apartment = apartment;
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "idimage")
    public Integer getIdImage() {
        return idImage;
    }

    public void setIdImage(Integer idImage) {
        this.idImage = idImage;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idapartment")
    public Apartment getApartment() {
        return apartment;
    }

    public void setApartment(Apartment apartment) {
        this.apartment = apartment;
    }
}

package org.jazzteam.model.table;

import javax.persistence.*;
import java.io.Serializable;

import static javax.persistence.GenerationType.*;

@Entity
@Table(name = "likehouse")
public class LikeHouse implements Serializable {
    private Integer idLikeHouse;
    private User landlord;
    private User lessee;
    private int response;

    public LikeHouse() {

    }

    public LikeHouse(User landlord, User lessee, int response) {
        this.landlord = landlord;
        this.lessee = lessee;
        this.response = response;
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "idlikehouse")
    public Integer getIdLikeHouse() {
        return idLikeHouse;
    }

    public void setIdLikeHouse(Integer idLikeHouse) {
        this.idLikeHouse = idLikeHouse;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idlandlord")
    public User getLandlord() {
        return landlord;
    }

    public void setLandlord(User landlord) {
        this.landlord = landlord;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idlessee")
    public User getLessee() {
        return lessee;
    }

    public void setLessee(User lessee) {
        this.lessee = lessee;
    }

    public int getResponse() {
        return response;
    }

    public void setResponse(int response) {
        this.response = response;
    }
}

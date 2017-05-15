package org.jazzteam.model.table;

import javax.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.GenerationType.*;

@Entity
@Table(name = "user")
public class User implements Serializable {
    private Integer idUser;
    private String nikname;
    private String password;
    private String email;
    private String surname;
    private String name;
    private String city;
    private int mobile;
    private Control control;
    private Apartment apartment;
    private List<Story> stories = new ArrayList<Story>();
    private List<Comment> comments = new ArrayList<Comment>();
    private List<LikeHouse> proposals = new ArrayList<LikeHouse>();
    private List<LikeHouse> bids = new ArrayList<LikeHouse>();

    public User() {

    }

    public User(String nikname, String password, String email, String surname, String name, String city, int mobile) {
        this.nikname = nikname;
        this.password = password;
        this.email = email;
        this.surname = surname;
        this.name = name;
        this.city = city;
        this.mobile = mobile;
    }

    public User(String nikname, String password, String email, String surname, String name, String city, int mobile, Control control) {
        this.nikname = nikname;
        this.password = password;
        this.email = email;
        this.surname = surname;
        this.name = name;
        this.city = city;
        this.mobile = mobile;
        this.control = control;
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "iduser")
    public Integer getIduser() {
        return idUser;
    }

    public void setIduser(Integer idUser) {
        this.idUser = idUser;
    }

    @Column(unique = true)
    public String getNikname() {
        return nikname;
    }

    public void setNikname(String nikname) {
        this.nikname = nikname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getMobile() {
        return mobile;
    }

    public void setMobile(int mobile) {
        this.mobile = mobile;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idcontrol")
    public Control getControl() {
        return control;
    }

    public void setControl(Control control) {
        this.control = control;
    }

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "user")
    public Apartment getApartment() {
        return apartment;
    }

    public void setApartment(Apartment apartment) {
        this.apartment = apartment;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    public List<Story> getStories() {
        return stories;
    }

    public void setStories(List<Story> stories) {
        this.stories = stories;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "landlord")
    public List<LikeHouse> getProposals() {
        return proposals;
    }

    public void setProposals(List<LikeHouse> proposals) {
        this.proposals = proposals;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "lessee")
    public List<LikeHouse> getBids() {
        return bids;
    }

    public void setBids(List<LikeHouse> bids) {
        this.bids = bids;
    }
}

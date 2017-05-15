package org.jazzteam.model.table;

import javax.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.GenerationType.*;

@Entity
@Table(name = "control")
public class Control implements Serializable {
    private Integer idControl;
    private String type;
    private List<User> users = new ArrayList<User>();

    public Control() {

    }

    public Control(String type) {
        this.type = type;
    }

    public Control(String type, List<User> users) {
        this.type = type;
        this.users = users;
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "idcontrol")
    public Integer getIdControl() {
        return idControl;
    }

    public void setIdControl(Integer idControl) {
        this.idControl = idControl;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "control")
    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}


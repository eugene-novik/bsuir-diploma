package org.jazzteam.model.table;

import javax.persistence.*;

import static javax.persistence.GenerationType.*;

@Entity
@Table(name = "comment")
public class Comment {
    private Integer idComments;
    private String comment;
    private User commentator;
    private User user;

    public Comment() {

    }

    public Comment(String comment, User commentator, User user) {
        this.comment = comment;
        this.commentator = commentator;
        this.user = user;
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "idComments")
    public Integer getIdComments() {
        return idComments;
    }

    public void setIdComments(Integer idComments) {
        this.idComments = idComments;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idcommentator")
    public User getCommentator() {
        return commentator;
    }

    public void setCommentator(User commentator) {
        this.commentator = commentator;
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

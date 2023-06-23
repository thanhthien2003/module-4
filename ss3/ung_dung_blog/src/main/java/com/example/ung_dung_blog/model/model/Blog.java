package com.example.ung_dung_blog.model.model;

import javax.persistence.*;

@Entity
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String heading;
    private String dateSubmitted;
    @Column(nullable = false,columnDefinition = "LongText")
    private String content;

    public Blog() {
    }

    public Blog(Integer id, String title, String heading, String dateSubmitted, String content) {
        this.id = id;
        this.title = title;
        this.heading = heading;
        this.dateSubmitted = dateSubmitted;
        this.content = content;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getHeading() {
        return heading;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }

    public String getDateSubmitted() {
        return dateSubmitted;
    }

    public void setDateSubmitted(String dateSubmitted) {
        this.dateSubmitted = dateSubmitted;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}

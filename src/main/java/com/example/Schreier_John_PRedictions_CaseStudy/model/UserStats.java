package com.example.Schreier_John_PRedictions_CaseStudy.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table
public class UserStats {
    @Id
    private String email;
    @Column
    private String goals;
    @Column
    private String history;

    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
//    @JoinColumn(name = "id", referencedColumnName = "id")
    private Coach coach;

    @OneToOne
    private User user;


    public UserStats() {
    }

    public UserStats(String email, String goals, String history, Coach coach) {
        this.email = email;
        this.goals = goals;
        this.history = history;
        this.coach = coach;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGoals() {
        return goals;
    }

    public void setGoals(String goals) {
        this.goals = goals;
    }

    public String getHistory() {
        return history;
    }

    public void setHistory(String history) {
        this.history = history;
    }

    public Coach getCoach() {
        return coach;
    }

    public void setCoach(Coach coach) {
        this.coach = coach;
    }

    public User getUser() {
        return user;
    }

    @Override
    public String toString() {
        return "UserStats{" +
                "email='" + email + '\'' +
                ", goals='" + goals + '\'' +
                ", history='" + history + '\'' +
                ", coach=" + coach +
                ", user=" + user +
                '}';
    }
}


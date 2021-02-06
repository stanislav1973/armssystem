package com.example.armstest;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "demand")
public class Demand {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String demand_desc;
    private String status;
    private String office;
    private String user;
    private Date time;
    private String accepted;

    public Demand() {
    }
//        @OneToMany
//    @JoinColumn(name = "demand_list_id")
//    List<Demand> demandList = new ArrayList<>();
    @PrePersist
    void timedAt() {
        this.time = new Date();
    }

}


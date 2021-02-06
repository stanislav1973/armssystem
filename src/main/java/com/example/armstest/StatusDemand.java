package com.example.armstest;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Data
@Entity
@Table(name = "statusdemand")
public class StatusDemand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String master;
    private Date time;
    private Long demand_id;
    private Long demand_list_id;

    public StatusDemand() {
    }

    @PrePersist
    void timedAt() {
        this.time = new Date();
    }
}

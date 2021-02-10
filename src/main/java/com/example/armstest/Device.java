package com.example.armstest;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "device")
public class Device {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String namedevice;
}

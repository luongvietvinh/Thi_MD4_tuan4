package com.baithi_md4.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Data
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotNull(message = "ten ko duoc de trong")
    private String name;
    @NotNull(message = "dien tich ko duoc de trong")
    private String dientich;
    private String danso;
    private String GDP;
    private String description;

    @ManyToOne
    private QuocGia quocGia;

}

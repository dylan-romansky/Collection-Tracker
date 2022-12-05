package com.rigtrack.tracker.Entity;

import jakarta.annotation.Generated;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="eqp")
public class Equipment {
    @Id
    @Column(name="eqp_id")
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Getter @Setter
    private Long id;
    @Getter @Setter
    private String name;
    @Getter @Setter
    private String description;
    @JoinColumn(name="eqp_id_img", referencedColumnName="eqp_id")
    @Getter @Setter
    private String imageId;

    public Equipment(String name, String description)   {
        this.name = name;
        this.description = description;
    }
    public Equipment(String name, String description, String uuid)  {
        this.name = name;
        this.description = description;
        this.imageId = uuid;
    }
}

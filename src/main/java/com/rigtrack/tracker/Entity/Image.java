package com.rigtrack.tracker.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="images")
public class Image {
    @Id
    @Column(name="img_id")
    @GeneratedValue(generator="uuid")
    @GenericGenerator(name="uuid", strategy="uuid2")
    @Getter
    @Setter
    private String uuid;
    @Getter @Setter
    private String name;
    @Getter @Setter
    private String type;
    @Lob
    @Getter @Setter
    private byte[] data;

    public Image(String name, String type, byte[] data) {
        this.name = name;
        this.type = type;
        this.data = data;
    }
}

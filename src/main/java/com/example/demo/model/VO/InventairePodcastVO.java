package com.example.demo.model.VO;

import jakarta.persistence.*;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;


@Entity
@Table(name = "inventaires_podcasts")
public class InventairePodcastVO {

    @EmbeddedId
    private InventairePodcastPK id;

    public InventairePodcastPK getId() {
        return id;
    }

    public void setId(InventairePodcastPK id) {
        this.id = id;
    }
}

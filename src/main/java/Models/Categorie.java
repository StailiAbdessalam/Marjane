package Models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.Instant;

@Entity
@Table(name = "categorie")
@NoArgsConstructor @Data
public class Categorie implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tid", nullable = false)
    private Integer id;

    @Column(name = "tname", nullable = false)
    private String tname;

    @Column(name = "tcreatedat", nullable = false)
    private Instant tcreatedat;

    public Categorie(String tname, Instant tcreatedat) {
        this.tname = tname;
        this.tcreatedat = tcreatedat;
    }


}
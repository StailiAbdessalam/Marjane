package Models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.Instant;

@Entity
@Table(name = "promotion")
@Data
@NoArgsConstructor
public class Promotion implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "p_id", nullable = false)
    private Integer id;

    @Column(name = "p_createdat", nullable = false)
    private Instant pCreatedat;

    @Column(name = "p_point", nullable = false)
    private Integer pPoint;

    @Column(name = "p_status")
    private String pStatus;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "p_categorie", nullable = false)
    private Categorie pCategorie;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "p_idcenteradmin", nullable = false)
    private Centreadmin pIdcenteradmin;

    @Column(name = "date_debut", length = Integer.MAX_VALUE)
    private String dateDebut;

    @Column(name = "description", length = Integer.MAX_VALUE)
    private String description;

    @Column(name = "\"datExpire\"", length = Integer.MAX_VALUE)
    private String datExpire;

    public Promotion(Instant pCreatedat, Integer pPoint, String pStatus, Categorie pCategorie, Centreadmin pIdcenteradmin, String dateDebut, String description, String datExpire) {
        this.pCreatedat = pCreatedat;
        this.pPoint = pPoint;
        this.pStatus = pStatus;
        this.pCategorie = pCategorie;
        this.pIdcenteradmin = pIdcenteradmin;
        this.dateDebut = dateDebut;
        this.description = description;
        this.datExpire = datExpire;
    }
}
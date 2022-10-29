package Models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.Instant;

@Entity
@Table(name = "promotion")
@NoArgsConstructor
public class Promotion implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "p_id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "p_idcenteradmin", nullable = false)
    private Centreadmin pIdcenteradmin;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "p_categorie", nullable = false)
    private Categorie pCategorie;

    @Column(name = "p_point", nullable = false)
    private Integer pPoint;

    @Column(name = "p_status")
    private Boolean pStatus;

    @Column(name = "p_createdat", nullable = false)
    private Instant pCreatedat;

    public Promotion(Centreadmin pIdcenteradmin, Categorie pCategorie, Integer pPoint, Boolean pStatus, Instant pCreatedat) {
        this.pIdcenteradmin = pIdcenteradmin;
        this.pCategorie = pCategorie;
        this.pPoint = pPoint;
        this.pStatus = pStatus;
        this.pCreatedat = pCreatedat;
    }


}
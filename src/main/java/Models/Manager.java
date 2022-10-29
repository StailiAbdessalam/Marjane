package Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.Instant;

@Entity
@Table(name = "manager")
@NoArgsConstructor @Data
public class Manager implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mid", nullable = false)
    private Integer id;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "mcenteradmin", nullable = false)
    private Centreadmin mcenteradmin;

    @Column(name = "mfullname", nullable = false)
    private String mfullname;

    @Column(name = "memail", nullable = false)
    private String memail;

    @Column(name = "mpassword", nullable = false)
    private String mpassword;

    @Column(name = "mcreatedat", nullable = false)
    private Instant mcreatedat;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "midcategorie", nullable = false)
    private Categorie midcategorie;


    public Manager(Centreadmin mcenteradmin, String mfullname, String memail, String mpassword, Instant mcreatedat, Categorie midcategorie) {
        this.mcenteradmin = mcenteradmin;
        this.mfullname = mfullname;
        this.memail = memail;
        this.mpassword = mpassword;
        this.mcreatedat = mcreatedat;
        this.midcategorie = midcategorie;
    }
}
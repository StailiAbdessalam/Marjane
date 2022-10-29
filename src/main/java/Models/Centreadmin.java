package Models;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;

import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "centreadmin")
@NoArgsConstructor
@Data
public class Centreadmin implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "caid", nullable = false)
    private Integer id;
    @JoinColumn(name = "idcenter", nullable = false)
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private int idcenter;
    @Column(name = "cafullname", nullable = false)
    private String cafullname;
    @Column(name = "caemail", nullable = false)
    private String caemail;

    @Column(name = "capassword", nullable = false)
    private String capassword;
    @OneToMany(mappedBy = "pIdcenteradmin")
    private Set<Promotion> promotions = new LinkedHashSet<>();
    @OneToMany(mappedBy = "mcenteradmin")
    private Set<Manager> managers = new LinkedHashSet<>();
    public Set<Manager> getManagers() {
        return managers;
    }
    public void setManagers(Set<Manager> managers) {
        this.managers = managers;
    }
    public Set<Promotion> getPromotions() {
        return promotions;
    }
    public void setPromotions(Set<Promotion> promotions) {
        this.promotions = promotions;
    }
    public Centreadmin(int idcenter, String cafullname, String caemail, String capassword) {
        this.idcenter = idcenter;
        this.cafullname = cafullname;
        this.caemail = caemail;
        this.capassword = capassword;
    }
}
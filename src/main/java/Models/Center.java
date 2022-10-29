package Models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.Instant;

@Entity
@Table(name = "center")
@Data
@NoArgsConstructor
public class Center implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cid", nullable = false)
    private Integer id;
    @Column(name = "cname", nullable = false)
    private String cname;
    @Column(name = "cville", nullable = false)
    private String cville;
    @Column(name = "ccreatedat", nullable = false)
    private Instant ccreatedat;
    public Center(String cname, String cville, Instant ccreatedat) {
        this.cname = cname;
        this.cville = cville;
        this.ccreatedat = ccreatedat;
    }
}
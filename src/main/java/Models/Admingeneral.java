package Models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.io.Serializable;

@Entity
@Table(name = "admingeneral")
@Data
@NoArgsConstructor
public class Admingeneral implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "agid", nullable = false)
    private Integer id;

    @Column(name = "agfullname", nullable = false)
    private String agfullname;

    @Column(name = "agemail", nullable = false)
    private String agemail;

    @Column(name = "agpassword", nullable = false)
    private String agpassword;

    public Admingeneral(String agfullname, String agemail, String agpassword) {
        this.agfullname = agfullname;
        this.agemail = agemail;
        this.agpassword = agpassword;
    }
}
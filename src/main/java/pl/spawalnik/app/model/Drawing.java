package pl.spawalnik.app.model;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "DRAWINGS")
public class Drawing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String dwgNumber;

    @OneToMany(mappedBy = "drawing")
    private List<Weld> welds;

    @ManyToOne
    private PipingSys pipingSys;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDwgNumber() {
        return dwgNumber;
    }

    public void setDwgNumber(String dwgNumber) {
        this.dwgNumber = dwgNumber;
    }

    public List<Weld> getWelds() {
        return welds;
    }

    public void setWelds(List<Weld> welds) {
        this.welds = welds;
    }

    public PipingSys getPipingSys() {
        return pipingSys;
    }

    public void setPipingSys(PipingSys pipingSys) {
        this.pipingSys = pipingSys;
    }
}

package pl.spawalnik.app.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "SYSTEMS")
public class PipingSys {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private double rtPercentage;
    private double ptPercentage;
    private final double VTPercentage = 1.0;


    @Transient
    private double rtDone;

    @Transient
    private double ptDone;

    @OneToMany
    private List<Weld> welds;


    @OneToMany(mappedBy = "pipingSys")
    private List<Drawing> drawings;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getRtPercentage() {
        return rtPercentage;
    }

    public void setRtPercentage(double rtPercentage) {
        this.rtPercentage = rtPercentage;
    }

    public double getPtPercentage() {
        return ptPercentage;
    }

    public void setPtPercentage(double ptPercentage) {
        this.ptPercentage = ptPercentage;
    }

    public double getVTPercentage() {
        return VTPercentage;
    }

    public List<Drawing> getDrawings() {
        return drawings;
    }

    public void setDrawings(List<Drawing> drawings) {
        this.drawings = drawings;
    }

    public double getRtDone() {
        return rtDone;
    }

    public void setRtDone(double rtDone) {
        this.rtDone = rtDone;
    }

    public double getPtDone() {
        return ptDone;
    }

    public void setPtDone(double ptDone) {
        this.ptDone = ptDone;
    }

    public List<Weld> getWelds() {
        return welds;
    }

    public void setWelds(List<Weld> welds) {
        this.welds = welds;
    }
}

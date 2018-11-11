package pl.spawalnik.app.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "WELDS")
public class Weld {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String weldNo;
    private String typeJoint;
    private String typeWelding; // 111, 141 ...
    private double diameter;
    private double wallThickness;
    private String material;

    @Column(nullable = true)
    private String rtNdt = null;

    @Column(nullable = true)
    private String ptNdt = null;

    @ManyToOne
    private PipingSys pipingSys;

    @ManyToOne
    private Welder welder;

    @ManyToOne
    private Drawing drawing;

    @ManyToOne
    private Wps wps;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getWeldNo() {
        return weldNo;
    }

    public void setWeldNo(String weldNo) {
        this.weldNo = weldNo;
    }

    public String getTypeJoint() {
        return typeJoint;
    }

    public void setTypeJoint(String typeJoint) {
        this.typeJoint = typeJoint;
    }

    public String getTypeWelding() {
        return typeWelding;
    }

    public void setTypeWelding(String typeWelding) {
        this.typeWelding = typeWelding;
    }

    public double getDiameter() {
        return diameter;
    }

    public void setDiameter(double diameter) {
        this.diameter = diameter;
    }

    public double getWallThickness() {
        return wallThickness;
    }

    public void setWallThickness(double wallThickness) {
        this.wallThickness = wallThickness;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public Welder getWelder() {
        return welder;
    }

    public void setWelder(Welder welder) {
        this.welder = welder;
    }

    public Drawing getDrawing() {
        return drawing;
    }

    public void setDrawing(Drawing drawing) {
        this.drawing = drawing;
    }

    public Wps getWps() {
        return wps;
    }

    public void setWps(Wps wps) {
        this.wps = wps;
    }

    public String getRtNdt() {
        return rtNdt;
    }

    public void setRtNdt(String rtNdt) {
        this.rtNdt = rtNdt;
    }

    public String getPtNdt() {
        return ptNdt;
    }

    public void setPtNdt(String ptNdt) {
        this.ptNdt = ptNdt;
    }

    public PipingSys getPipingSys() {
        return pipingSys;
    }

    public void setPipingSys(PipingSys pipingSys) {
        this.pipingSys = pipingSys;
    }

    @Override
    public String toString() {
        return "Weld{" +
                "id=" + id +
                ", weldNo='" + weldNo + '\'' +
                ", typeJoint='" + typeJoint + '\'' +
                ", typeWelding='" + typeWelding + '\'' +
                ", diameter=" + diameter +
                ", wallThickness=" + wallThickness +
                ", material=" + material +
                ", welder=" + welder +
                ", drawing=" + drawing +
                ", wps=" + wps +
                '}';
    }


}

package pl.spawalnik.app.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "WPS")
public class Wps {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String wpsNumber;

    private String material;

    private String materialGr;

    private String weldingType;
    private String weldType;
    private double minDiameter;
    private double maxDiameter;
    private double minWallThickness;
    private double maxWallThickness;

    private String fillerMaterial;

    @OneToMany(mappedBy = "wps")
    private List<Weld> welds;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getWpsNumber() {
        return wpsNumber;
    }

    public void setWpsNumber(String wpsNumber) {
        this.wpsNumber = wpsNumber;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getMaterialGr() {
        return materialGr;
    }

    public void setMaterialGr(String materialGr) {
        this.materialGr = materialGr;
    }

    public String getWeldingType() {
        return weldingType;
    }

    public void setWeldingType(String weldingType) {
        this.weldingType = weldingType;
    }

    public String getWeldType() {
        return weldType;
    }

    public void setWeldType(String weldType) {
        this.weldType = weldType;
    }

    public double getMinDiameter() {
        return minDiameter;
    }

    public void setMinDiameter(double minDiameter) {
        this.minDiameter = minDiameter;
    }

    public double getMaxDiameter() {
        return maxDiameter;
    }

    public void setMaxDiameter(double maxDiameter) {
        this.maxDiameter = maxDiameter;
    }

    public double getMinWallThickness() {
        return minWallThickness;
    }

    public void setMinWallThickness(double minWallThickness) {
        this.minWallThickness = minWallThickness;
    }

    public double getMaxWallThickness() {
        return maxWallThickness;
    }

    public void setMaxWallThickness(double maxWallThickness) {
        this.maxWallThickness = maxWallThickness;
    }

    public String getFillerMaterial() {
        return fillerMaterial;
    }

    public void setFillerMaterial(String fillerMaterial) {
        this.fillerMaterial = fillerMaterial;
    }

    public List<Weld> getWelds() {
        return welds;
    }

    public void setWelds(List<Weld> welds) {
        this.welds = welds;
    }
}

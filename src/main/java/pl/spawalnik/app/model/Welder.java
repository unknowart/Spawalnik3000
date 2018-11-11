package pl.spawalnik.app.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "WELDERS")
public class Welder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String welderNo;
    private String firstName;
    private String lastName;

    private String certificateNo;
    private double minDiameter;
    private double maxDiameter;
    private double minWallThickness;
    private double maxWallThickness;

    @OneToMany(mappedBy = "welder")
    private List<Weld> welds;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getWelderNo() {
        return welderNo;
    }

    public void setWelderNo(String welderNo) {
        this.welderNo = welderNo;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCertificateNo() {
        return certificateNo;
    }

    public void setCertificateNo(String certificateNo) {
        this.certificateNo = certificateNo;
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

    public List<Weld> getWelds() {
        return welds;
    }

    public void setWelds(List<Weld> welds) {
        this.welds = welds;
    }
}

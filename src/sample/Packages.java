// Author - Jared Bellamy
package sample;

import java.math.BigDecimal;
import java.sql.Timestamp;


public class Packages {
    //gobal variables to create or edit packages
    private int packageID;
    private String pkgName;
    private Timestamp pkgStartDate;
    private Timestamp pkgEndDate;
    private String pkgDesc;
    private BigDecimal pkgBasePrice;
    private BigDecimal pkgAgencyCom;

// Method for building a full package
    public Packages(int packageID, String pkgName, Timestamp pkgStartDate, Timestamp pkgEndDate, String pkgDesc, BigDecimal pkgBasePrice, BigDecimal pkgAgencyCom) {
        this.packageID = packageID;
        this.pkgName = pkgName;
        this.pkgStartDate = pkgStartDate;
        this.pkgEndDate = pkgEndDate;
        this.pkgDesc = pkgDesc;
        this.pkgBasePrice = pkgBasePrice;
        this.pkgAgencyCom = pkgAgencyCom;

    }

//GETTERS AND SETTERS

    public int getPackageID() {
        return packageID;
    }

    public void setPackageID(int packageID) {
        this.packageID = packageID;
    }

    public String getPkgName() {
        return pkgName;
    }

    public void setPkgName(String pkgName) {
        this.pkgName = pkgName;
    }

    public Timestamp getPkgStartDate() {
        return pkgStartDate;
    }

    public void setPkgStartDate(Timestamp pkgStartDate) {
        this.pkgStartDate = pkgStartDate;
    }

    public Timestamp getPkgEndDate() {
        return pkgEndDate;
    }

    public void setPkgEndDate(Timestamp pkgEndDate) {
        this.pkgEndDate = pkgEndDate;
    }

    public String getPkgDesc() {
        return pkgDesc;
    }

    public void setPkgDesc(String pkgDesc) {
        this.pkgDesc = pkgDesc;
    }

    public BigDecimal getPkgBasePrice() {
        return pkgBasePrice;
    }

    public void setPkgBasePrice(BigDecimal pkgBasePrice) {
        this.pkgBasePrice = pkgBasePrice;
    }

    public BigDecimal getPkgAgencyCom() {
        return pkgAgencyCom;
    }

    public void setPkgAgencyCom(BigDecimal pkgAgencyCom) {
        this.pkgAgencyCom = pkgAgencyCom;
    }
}

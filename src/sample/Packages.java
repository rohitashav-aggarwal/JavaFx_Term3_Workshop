package sample;

import java.sql.Date;




public class Packages {
    private int packageID;
    private String pkgName;
    private Date pkgStartDate;
    private Date pkgEndDate;
    private String pkgDesc;
    private int pkgBasePrice;
    private int pkgAgencyCom;

    public Packages(int packageID, String pkgName, Date pkgStartDate, Date pkgEndDate, String pkgDesc, int pkgBasePrice, int pkgAgencyCom) {
        this.packageID = packageID;
        this.pkgName = pkgName;
        this.pkgStartDate = pkgStartDate;
        this.pkgEndDate = pkgEndDate;
        this.pkgDesc = pkgDesc;
        this.pkgBasePrice = pkgBasePrice;
        this.pkgAgencyCom = pkgAgencyCom;
    }

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

    public Date getPkgStartDate() {
        return pkgStartDate;
    }

    public void setPkgStartDate(Date pkgStartDate) {
        this.pkgStartDate = pkgStartDate;
    }

    public Date getPkgEndDate() {
        return pkgEndDate;
    }

    public void setPkgEndDate(Date pkgEndDate) {
        this.pkgEndDate = pkgEndDate;
    }

    public String getPkgDesc() {
        return pkgDesc;
    }

    public void setPkgDesc(String pkgDesc) {
        this.pkgDesc = pkgDesc;
    }

    public int getPkgBasePrice() {
        return pkgBasePrice;
    }

    public void setPkgBasePrice(int pkgBasePrice) {
        this.pkgBasePrice = pkgBasePrice;
    }

    public int getPkgAgencyCom() {
        return pkgAgencyCom;
    }

    public void setPkgAgencyCom(int pkgAgencyCom) {
        this.pkgAgencyCom = pkgAgencyCom;
    }
}

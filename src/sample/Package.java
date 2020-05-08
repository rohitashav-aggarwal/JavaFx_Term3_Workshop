package sample;

import java.math.BigDecimal;

public class Package {
    private int PackageId;
    private String PkgName;
    private String PkgStartDate;
    private String PkgEndDate;
    private String PkgDesc;
    private BigDecimal PkgBasePrice;
    private BigDecimal PkgAgencyCommission;

    public int getPackageId() {
        return PackageId;
    }

    public void setPackageId(int packageId) {
        PackageId = packageId;
    }

    public String getPkgName() {
        return PkgName;
    }

    public void setPkgName(String pkgName) {
        PkgName = pkgName;
    }

    public String getPkgStartDate() {
        return PkgStartDate;
    }

    public void setPkgStartDate(String pkgStartDate) {
        PkgStartDate = pkgStartDate;
    }

    public String getPkgEndDate() {
        return PkgEndDate;
    }

    public void setPkgEndDate(String pkgEndDate) {
        PkgEndDate = pkgEndDate;
    }

    public String getPkgDesc() {
        return PkgDesc;
    }

    public void setPkgDesc(String pkgDesc) {
        PkgDesc = pkgDesc;
    }

    public BigDecimal getPkgBasePrice() {
        return PkgBasePrice;
    }

    public void setPkgBasePrice(BigDecimal pkgBasePrice) {
        PkgBasePrice = pkgBasePrice;
    }

    public BigDecimal getPkgAgencyCommission() {
        return PkgAgencyCommission;
    }

    public void setPkgAgencyCommission(BigDecimal pkgAgencyCommission) {
        PkgAgencyCommission = pkgAgencyCommission;
    }

    public Package(int packageId, String pkgName, String pkgStartDate, String pkgEndDate, String pkgDesc, BigDecimal pkgBasePrice, BigDecimal pkgAgencyCommission) {
        PackageId = packageId;
        PkgName = pkgName;
        PkgStartDate = pkgStartDate;
        PkgEndDate = pkgEndDate;
        PkgDesc = pkgDesc;
        PkgBasePrice = pkgBasePrice;
        PkgAgencyCommission = pkgAgencyCommission;
    }

    public Package() {
    }
}

package shlm.canshu.com.canshu.LazyCatProgramUnt.CompanyPage;


/**
 * 解析XML的时候的USER的表格
 */
public class XMLUserAddr {

    private String USER_NAME, USER_TEL, USER_ADDR, PHYSICS_ADDR, ADDR_IN, USER_SEX, USER_YEAR,
            DEFAULT_ADDR = "";//缺省值


    public String getDEFAULT_ADDR() {
        return DEFAULT_ADDR;
    }

    public void setDEFAULT_ADDR(String DEFAULT_ADDR) {
        this.DEFAULT_ADDR = DEFAULT_ADDR;
    }

    public String getUSER_YEAR() {
        return USER_YEAR;
    }

    public void setUSER_YEAR(String USER_YEAR) {
        this.USER_YEAR = USER_YEAR;
    }

    public String getUSER_SEX() {
        return USER_SEX;
    }

    public void setUSER_SEX(String USER_SEX) {
        this.USER_SEX = USER_SEX;
    }

    public String getADDR_IN() {
        return ADDR_IN;
    }

    public void setADDR_IN(String ADDR_IN) {
        this.ADDR_IN = ADDR_IN;
    }

    public String getPHYSICS_ADDR() {
        return PHYSICS_ADDR;
    }

    public void setPHYSICS_ADDR(String PHYSICS_ADDR) {
        this.PHYSICS_ADDR = PHYSICS_ADDR;
    }

    public String getUSER_ADDR() {
        return USER_ADDR;
    }

    public void setUSER_ADDR(String USER_ADDR) {
        this.USER_ADDR = USER_ADDR;
    }

    public String getUSER_NAME() {
        return USER_NAME;
    }

    public void setUSER_NAME(String USER_NAME) {
        this.USER_NAME = USER_NAME;
    }

    public String getUSER_TEL() {
        return USER_TEL;
    }

    public void setUSER_TEL(String USER_TEL) {
        this.USER_TEL = USER_TEL;
    }
}

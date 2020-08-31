package local;

public class Canceled extends AbstractEvent {

    private Long hospitalId;
    private String chkDate;
    private String hospitalNm;
    private Long pCnt;

    public Long getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(Long hospitalId) {
        this.hospitalId = hospitalId;
    }
    public String getChkDate() {
        return chkDate;
    }

    public void setChkDate(String chkDate) {
        this.chkDate = chkDate;
    }

    public String getHospitalNm() {
        return hospitalNm;
    }

    public void setHospitalNm(String hospitalNm) {
        this.hospitalNm = hospitalNm;
    }

    public Long getpCnt() {
        return pCnt;
    }

    public void setpCnt(Long pCnt) {
        this.pCnt = pCnt;
    }

}
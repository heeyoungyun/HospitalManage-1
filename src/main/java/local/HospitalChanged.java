package local;

public class HospitalChanged extends AbstractEvent {

    private Long id;
    private String hospitalNm;
    private String chkDate;
    private Long pCnt;
    public Long getpCnt() {
        return pCnt;
    }

    public void setpCnt(Long pCnt) {
        this.pCnt = pCnt;
    }
    public HospitalChanged(){
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getHospitalNm() {
        return hospitalNm;
    }

    public void setHospitalNm(String hospitalNm) {
        this.hospitalNm = hospitalNm;
    }
    public String getChkDate() {
        return chkDate;
    }
    public void setChkDate(String chkDate) {
        this.chkDate = chkDate;
    }
}

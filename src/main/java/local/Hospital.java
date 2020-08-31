package local;

import javax.persistence.*;
import org.springframework.beans.BeanUtils;
import java.util.List;

@Entity
@Table(name="Hospital_table")
public class Hospital {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String hospitalNm;
    private Long pCnt;
    private String chkDate;

    @PostPersist
    public void onPostPersist(){
        HospitalRegistered hospitalRegistered = new HospitalRegistered();
        BeanUtils.copyProperties(this, hospitalRegistered);
        hospitalRegistered.publishAfterCommit();
    }

    @PostUpdate
    public void onPostUpdate(){
        HospitalChanged hospitalChanged = new HospitalChanged();
        BeanUtils.copyProperties(this, hospitalChanged);
        hospitalChanged.publishAfterCommit();


        ScreeningRequested screeningRequested = new ScreeningRequested();
        BeanUtils.copyProperties(this, screeningRequested);
        screeningRequested.publishAfterCommit();


        ScreeningCanceld screeningCanceld = new ScreeningCanceld();
        BeanUtils.copyProperties(this, screeningCanceld);
        screeningCanceld.publishAfterCommit();
    }


    @PreRemove
    public void onPreRemove(){
        HospitalDeleted hospitalDeleted = new HospitalDeleted();
        BeanUtils.copyProperties(this, hospitalDeleted);
        hospitalDeleted.publishAfterCommit();

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
    public Long getPCnt() {
        return pCnt;
    }

    public void setPCnt(Long pCnt) {
        this.pCnt = pCnt;
    }
    public String getChkDate() {
        return chkDate;
    }

    public void setChkDate(String chkDate) {
        this.chkDate = chkDate;
    }




}

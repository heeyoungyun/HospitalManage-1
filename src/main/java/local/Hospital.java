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

    @PreUpdate
    public  void onPreUpdate(){
        /*
        강제적 Delay
        try {
            Thread.currentThread().sleep((long)10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        */
    }

    @PostUpdate
    public void onPostUpdate(){

        HospitalChanged hospitalChanged = new HospitalChanged();
        BeanUtils.copyProperties(this, hospitalChanged);
        hospitalChanged.publishAfterCommit();

        /*
        검진 예약 요청 발행 제거
        ScreeningRequested screeningRequested = new ScreeningRequested();
        BeanUtils.copyProperties(this, screeningRequested);
        screeningRequested.publishAfterCommit();

        검진 취소됨 발행 제거
        ScreeningCanceld screeningCanceld = new ScreeningCanceld();
        BeanUtils.copyProperties(this, screeningCanceld);
        screeningCanceld.publishAfterCommit();
        

         */
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

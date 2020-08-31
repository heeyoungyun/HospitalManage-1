package local;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Optional;

@RestController
public class HospitalController {

    @Autowired
    HospitalRepository hospitalRepository;


    @PostMapping("/hospitals")
    void hospitalInsert(@RequestBody Hospital data) {
        hospitalRepository.save(data);
    }

    @PutMapping("/hospitals/{hospitalId}")
    void decreasePcnt(@PathVariable(value = "hospitalId") Long hospitalId) {

        Optional<Hospital> a = hospitalRepository.findById(hospitalId);
        if (a.isPresent()) {
            Hospital b = a.get();
            b.setPCnt(b.getPCnt() - 1);
            hospitalRepository.save(b);
        }
    }


    @GetMapping("/hospitals")
    Iterable<Hospital> getHospitalList() {
        Iterable<Hospital> result = hospitalRepository.findAll();
        return result;
    }

    @GetMapping("/hospitals/{hospitalId}")
    Hospital getHospitalById(@PathVariable(value = "hospitalId") Long hospitalId) {
        System.out.println("productStockCheck call");
        Optional<Hospital> a = hospitalRepository.findById(hospitalId);
        return a.get();
    }


    @DeleteMapping("/hospitals/{hospitalId}")
    void hospitalDelete(@PathVariable(value = "hospitalId") Long hospitalId) {
        hospitalRepository.deleteById(hospitalId);

    }

}

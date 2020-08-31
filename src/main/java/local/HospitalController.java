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

 @PutMapping("/hospitals/{hospitalId}")
 void decreasePcnt(@PathVariable(value = "hospitalId") Long hospitalId) {
  try {
   Thread.sleep(500);
  } catch (InterruptedException e) {
   e.printStackTrace();
  }
  Optional<Hospital> a = hospitalRepository.findById(hospitalId);

  if(a.isPresent()) {
   Hospital b = a.get();
   b.setPCnt(b.getPCnt()-1);
   hospitalRepository.save(b);

  }

 }

 @PostMapping("/hospitals")
 void hospitalInsert(@RequestBody Hospital data) {
  System.out.println(data);
  hospitalRepository.save(data);

 }


 @GetMapping("/hospitals/{hospitalId}")
 Hospital hospitalInfoCheck(@PathVariable(value = "hospitalId") Long hospitalId) {
  System.out.println("productStockCheck call");


  Optional<Hospital> a = hospitalRepository.findById(hospitalId);
  return a.get();
 }



 @DeleteMapping("/hospitals/{hospitalId}")
 void hospitalDelete(@PathVariable(value = "hospitalId") Long hospitalId) {
  hospitalRepository.deleteById(hospitalId);

 }

}

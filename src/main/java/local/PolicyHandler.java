package local;

import local.config.kafka.KafkaProcessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PolicyHandler{

    @Autowired
    HospitalRepository hospitalRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void onStringEventListener(@Payload String eventString){

    }

    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverCanceled_ScreeningCanceled(@Payload Canceled canceled){

        if(canceled.isMe()){
            System.out.println("##### 검진 취소 요청으로 인한 인원 변화 : " + canceled.toJson());
            Optional<Hospital> temp = hospitalRepository.findById(canceled.getHospitalId());

            if(temp.isPresent()){
                Hospital a = temp.get();
                a.setPCnt(a.getPCnt()+1);
                hospitalRepository.save(a);
            }
        }
    }

}

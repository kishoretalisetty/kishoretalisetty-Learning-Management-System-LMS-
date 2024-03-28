package org.example.EasterEggApiCallServiceLayer;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class EasterEggService {

    public ResponseEntity<String> easterEggApiCall(int number){
        RestTemplate restTemplate=new RestTemplate();
        String api="http://numbersapi.com/"+number;
        ResponseEntity<String> ans=restTemplate.getForEntity(api,String.class);
        return ans;
    }
}

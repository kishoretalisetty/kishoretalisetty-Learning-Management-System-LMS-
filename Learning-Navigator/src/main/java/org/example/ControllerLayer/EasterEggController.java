package org.example.ControllerLayer;

import org.example.EasterEggApiCallServiceLayer.EasterEggService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EasterEggController {

    @Autowired
    EasterEggService easterEggService;

    @GetMapping("/hidden-feature/")
    public ResponseEntity<String> getDataFromAPI(@RequestParam("number") Integer number){
        return easterEggService.easterEggApiCall(number);
    }
}

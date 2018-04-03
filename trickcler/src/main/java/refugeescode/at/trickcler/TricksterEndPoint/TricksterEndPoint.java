package refugeescode.at.trickcler.TricksterEndPoint;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;


import java.util.*;

@RequestMapping
@RestController
public class TricksterEndPoint {
    private List<String> urls = Arrays.asList("http://localhost:9000", "http://localhost:9000", "http://localhost:9000");

    @Autowired
    private RestTemplate restTemplate = new RestTemplate();

    @GetMapping("/play")
    public void play() {
        urls.stream().forEach(coin -> restTemplate.delete(coin));
        Collections.shuffle(urls);
        restTemplate.put(urls.get(0), true);

    }

    @GetMapping("/choose/{nummber}")
    public Boolean choose(@PathVariable int number) {
        ResponseEntity<Boolean> responseEntity = restTemplate.getForEntity(urls.get(number), Boolean.class);
        return responseEntity.getBody();
    }
}




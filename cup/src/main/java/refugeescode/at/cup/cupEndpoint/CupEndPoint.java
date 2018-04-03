package refugeescode.at.cup.cupEndpoint;


import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/coin")
public class CupEndPoint {

    private boolean coin;


    @GetMapping
    boolean getCupWithCoin() {

        return coin;
    }

    @DeleteMapping
    public void deletCoin() {
        coin = false;

    }

    @PutMapping
    void putCoin() {
        coin = true;
    }


}

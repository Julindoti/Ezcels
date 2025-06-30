import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

public class SpringController{
  @Component 
  @ConfigurationProperties(prefix= "google.api")
    public static void read(){

            WebClient webC= WebClient.create("https://sheets.googleapis.com/v4/spreadsheets/1pzqXr6bIsiZmVLI2F9pAhfSW8uecEjFXZX_rcLoCHKM/values/EZ?key=AIzaSyDcti4PcrrgE4BBc9MSSMHaeJ_v_qCRTgc");

            Mono<String> response= webC.get()
                  .uri("")
                  .retrieve()
                  .bodyToMono(String.class);
                  
            reponse.subscribe(System.out::println);
    }

}

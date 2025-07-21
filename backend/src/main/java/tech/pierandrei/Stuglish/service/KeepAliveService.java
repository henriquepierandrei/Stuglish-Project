package tech.pierandrei.Stuglish.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class KeepAliveService {

    @Value("${url.backend}")
    private String urlBackend;


//    @Scheduled(cron = "* * * * * *") // A cada segundo (SOMENTE PARA DEBUG)
    @Scheduled(cron = "0 */15 * * * *") // A cada 15 minutos
    public void keepAlive(){
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getForObject(urlBackend + "/health", String.class);
    }
}

package kea.momo.jpaonetomany.service;

import kea.momo.jpaonetomany.model.Kommune;
import kea.momo.jpaonetomany.repository.KommuneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
@Service
public class ApiServiceGetKommunerImpl implements ApiServiceGetKommuner {
    private final RestTemplate restTemplate;

    public ApiServiceGetKommunerImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    String kommuneUrl = "https://api.dataforsyningen.dk/kommuner";

    @Autowired
    KommuneRepository kommuneRepository;

    private void saveKommuneer(List<Kommune> kommuner){
        kommuneRepository.saveAll(kommuner);
    }

    @Override
    public List<Kommune> getKommuner(){
        ResponseEntity<List<Kommune>> kommuneResponse =
                restTemplate.exchange(kommuneUrl, HttpMethod.GET, null, new ParameterizedTypeReference<List<Kommune>>() {
                });
        List<Kommune> kommuner = kommuneResponse.getBody();
        saveKommuneer(kommuner);
        return kommuner;
    }
}

package kea.momo.jpaonetomany.service;

import kea.momo.jpaonetomany.model.Region;
import kea.momo.jpaonetomany.repository.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
@Service
public class ApiServiceGetRegionerImpl implements ApiServiceGetRegioner {
    private final RestTemplate restTemplate;

    public ApiServiceGetRegionerImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    String regionUrl = "https://api.dataforsyningen.dk/regioner";

    @Autowired
    RegionRepository regionRepository;

    private void saveRegioner(List<Region> regioner){
        regionRepository.saveAll(regioner);
    }
    @Override
    public List<Region> getRegioner(){
        ResponseEntity<List<Region>> regionResponse =
                restTemplate.exchange(regionUrl, HttpMethod.GET, null, new ParameterizedTypeReference<List<Region>>() {
                });
        List<Region> regioner = regionResponse.getBody();
        saveRegioner(regioner);
        return regioner;
    }

}

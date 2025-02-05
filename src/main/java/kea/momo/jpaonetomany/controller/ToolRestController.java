package kea.momo.jpaonetomany.controller;

import kea.momo.jpaonetomany.model.Kommune;
import kea.momo.jpaonetomany.model.Region;
import kea.momo.jpaonetomany.service.ApiServiceGetKommuner;
import kea.momo.jpaonetomany.service.ApiServiceGetRegioner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/tool")
public class ToolRestController {

    @Autowired
    ApiServiceGetRegioner apiServiceGetRegioner;

    @Autowired
    ApiServiceGetKommuner apiServiceGetKommuner;

    @GetMapping("/getregioner")
    public List<Region> getRegioner() {
        List<Region> lstRegioner = apiServiceGetRegioner.getRegioner();
        return lstRegioner;
    }


    @GetMapping("/getkommuner")
    public List<Kommune> getKommuner() {
        List<Kommune> lstKommune = apiServiceGetKommuner.getKommuner();
        return lstKommune;
    }
}

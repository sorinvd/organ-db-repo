package com.itschool.organdb.controller;

import com.itschool.organdb.model.OrganDTO;
import com.itschool.organdb.service.OrganService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("organs") //any endpoint/request will begin with the "path" organs --> ex GET + "http://localhost:8080/organs/1" (get entry with id 1)
public class OrganController {

    //injecting the service class
    private final OrganService OrganServiceAttribute;

    //initialize it with the constructor of this class:
    public OrganController(OrganService providedOrganService)
    {
        this.OrganServiceAttribute = providedOrganService;
    }

    @GetMapping("{providedId}") //signal this method as the one to call in case of a GET request
    public OrganDTO getOrganDTO(@PathVariable long providedId)
    {
        return OrganServiceAttribute.getOrganEntry(providedId);

    }

    @PostMapping
    public OrganDTO createOrganEntry(@RequestBody OrganDTO providedOrganDTO)
    {
        return OrganServiceAttribute.createOrganEntry(providedOrganDTO);
    }
}

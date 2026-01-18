package com.itschool.organdb.controller;

import com.itschool.organdb.model.OrganDTO;
import com.itschool.organdb.service.OrganService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Organs API", description = "An API that manages CRUD operations over a table of organs from a local database. ")
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

    //in case a GET request is being sent to our application without any parameter:
    @Operation(summary = "List all organs from the database", description = "Endpoint used to fetch all the organ entries from the database.")
    @GetMapping
    public List<OrganDTO> getAllOrganEntries()
    {
        return OrganServiceAttribute.getAllOrganEntries();
    }

    // the request to create a new entry in the table -- POST:
    @Operation(summary = "Create/insert a new entry in the database of organs", description = "Endpoint used to create/insert a new entry in the organ database.")
    @PostMapping
    public OrganDTO createOrganEntry(@RequestBody OrganDTO providedOrganDTO)
    {
        return OrganServiceAttribute.createOrganEntry(providedOrganDTO);
    }

    //the request to update an existing entry in the table -- PUT:
    @Operation(summary = "Update an existing organ entry from the database", description = "Endpoint used to update the information contained by a given already existing entry in the database.")
    @PutMapping("{providedId}")
    public OrganDTO updateOrganEntry(@PathVariable long providedId, @RequestBody OrganDTO providedOrganDTO)
    {
        return OrganServiceAttribute.updateOrganEntry(providedId, providedOrganDTO);
    }

    @DeleteMapping("{providedId}")
    public void deleteOrganEntry(@PathVariable long providedId)
    {
        OrganServiceAttribute.deleteOrganEntry(providedId);
    }
}

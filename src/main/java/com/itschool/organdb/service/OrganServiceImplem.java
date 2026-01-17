package com.itschool.organdb.service;

import com.itschool.organdb.entity.OrganEntry;
import com.itschool.organdb.model.OrganDTO;
import com.itschool.organdb.repository.OrganRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrganServiceImplem implements OrganService{

    private final OrganRepository localOrganRepository;

    public OrganServiceImplem(OrganRepository providedOrganRepository) {
        this.localOrganRepository = providedOrganRepository;
    }

// FOR IMPLEMENTATION OF THESE METHODS CHECK COURSE NOTES -- search for "TBD"

    @Override
    public OrganDTO getOrganEntry(long providedId) {
        OrganEntry extractedOrganEntry = localOrganRepository.findById(providedId) //method implemented by Hibernate -- through the classes extended by our OrganRepository
                .orElseThrow(); /*if Id not found --> throw exception: */

        //up to here, we have a result of type OrganEntry -- we need to convert to OrganDTO:

        OrganDTO resultOrganDTO = new OrganDTO(extractedOrganEntry.getEntry_id(), //calling constructor of OrganDTO class
                extractedOrganEntry.getManufacturer(),
                extractedOrganEntry.getGeogLocation(),
                extractedOrganEntry.getConstrYear());


        return resultOrganDTO;
    }

    @Override
    public List<OrganDTO> getAllOrganEntries() {

        List<OrganEntry> organEntryList = localOrganRepository.findAll();

        //converting list of OrganEntry entries to OrganEntry DTOs:
        //this time, from a list of certain type of objects to a list of another type of objects:
        List<OrganDTO> organDTOList = organEntryList.stream()
                .map(lambdaParam -> new OrganDTO(lambdaParam.getEntry_id(), //calling constructor of OrganDTO class
                        lambdaParam.getManufacturer(),
                        lambdaParam.getGeogLocation(),
                        lambdaParam.getConstrYear()))
                .toList();

        return organDTOList;
    }

    @Override
    public OrganDTO createOrganEntry(OrganDTO providedUserDTO) {

        //the save method of repository class needs a parameter of type entity, not entityDTO:
        OrganEntry localOrganEntry = new OrganEntry(providedUserDTO.manufacturer(), //call constructor of OrganEntry class
                providedUserDTO.geoLocation(), providedUserDTO.manufYear(), 0,0); //--> the OrganDTO does NOT have nr of registers and nr of manuals attributes

        //now the "save" method of the Repository class can be called:
        OrganEntry returnedCreatedOrganEntry = localOrganRepository.save(localOrganEntry);
        //now it will have also an ID (created by the DB)

        //convert back to OrganDTO:
        OrganDTO resultedOrganDTO = new OrganDTO(returnedCreatedOrganEntry.getEntry_id(), //calling constructor of OrganDTO class
                returnedCreatedOrganEntry.getManufacturer(),
                returnedCreatedOrganEntry.getGeogLocation(),
                returnedCreatedOrganEntry.getConstrYear());

        return resultedOrganDTO;
    }

    @Override
    public OrganDTO updateOrganEntry(long providedId, OrganDTO providedOrganDTO) {
        return null;
    }

    @Override
    public void deleteOrganEntry(long id) {

    }
}

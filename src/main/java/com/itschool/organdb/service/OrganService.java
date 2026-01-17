package com.itschool.organdb.service;

import com.itschool.organdb.model.OrganDTO;

import java.util.List;

public interface OrganService {

    OrganDTO getOrganEntry(long providedId);
    List<OrganDTO> getAllOrganEntries();
    OrganDTO createOrganEntry(OrganDTO providedUserDTO);
    OrganDTO updateOrganEntry(long providedId, OrganDTO providedOrganDTO);
    void deleteOrganEntry(long id);
}

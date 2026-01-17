package com.itschool.organdb.repository;

import com.itschool.organdb.entity.OrganEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrganRepository extends JpaRepository<OrganEntry, Long> {
}

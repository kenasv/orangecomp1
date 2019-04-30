package com.asuscomm.orangecomp1.repos;

import com.asuscomm.orangecomp1.allbd.Site;
import org.springframework.data.repository.CrudRepository;

import com.asuscomm.orangecomp1.allbd.Site;

import java.util.List;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface SiteRepo extends CrudRepository<Site, Long> {

    //List<Site> findById(String id);
    //List<Site> findByAdresIs(String adres);
    List<Site> findByAdresContaining(String adres);
}
package com.fsp.salepoint.repository;

import com.fsp.salepoint.model.SalePoint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface SalePointRepository extends JpaRepository<SalePoint, Long>{
    Optional<SalePoint> findBySalePointOwnerAndIsActive(Long userId, Character ch);
    Optional<SalePoint> findBySalePointOwner(Long userId);

    List<SalePoint> findByAddressCity(String city);

//    List<SalePoint> findByIsActive(Character ch);
//
//    SalePoint findByIdAndIsActive(Long id, Character ch);


    @Query("SELECT COUNT(sp) FROM SalePoint sp WHERE sp.isActive='y' or sp.isActive='Y'")
    int countActiveSalePoints();
}
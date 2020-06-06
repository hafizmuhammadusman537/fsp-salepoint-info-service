package com.fsp.salepoint.repository;

import com.fsp.salepoint.model.SalePoint;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SalePointRepository extends JpaRepository<SalePoint, Long>{
    SalePoint findBySalePointOwner(Long userId);

    List<SalePoint> findByAddressCity(String city);
}
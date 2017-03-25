/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arfan.adhib.repository;

import com.arfan.adhib.domain.Barang;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 *
 * @author emerio
 */
public interface BarangRepository extends PagingAndSortingRepository<Barang, String>{
    
}

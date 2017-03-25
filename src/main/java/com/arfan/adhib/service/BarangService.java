/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arfan.adhib.service;

import com.arfan.adhib.domain.Barang;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;

/**
 *
 * @author emerio
 */
public interface BarangService {

    void save(Barang barang);

    void update(Barang barang);

    void delete(String idBarang);

    Barang getBarang(String idBarang);

    Page<Barang> getBarangs(Pageable pageable);
}

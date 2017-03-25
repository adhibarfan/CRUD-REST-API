/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arfan.adhib.repository.impl;

import com.arfan.adhib.domain.Barang;
import com.arfan.adhib.repository.BarangRepository;
import com.arfan.adhib.service.BarangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author emerio
 */
@Service
@Transactional(readOnly = true)
public class BarangServiceImpl implements BarangService {

    @Autowired
    private BarangRepository barangRepository;

    @Transactional
    @Override
    public void save(Barang barang) {
        barangRepository.save(barang);
    }

    @Transactional
    @Override
    public void update(Barang barang) {
        barangRepository.save(barang);
    }

    @Transactional
    @Override
    public void delete(String idBarang) {
        barangRepository.delete(idBarang);
    }

    @Override
    public Barang getBarang(String idBarang) {
        return barangRepository.findOne(idBarang);
    }


    @Override
    public Page<Barang> getBarangs(Pageable pageable) {
         return barangRepository.findAll(pageable);
    }

}

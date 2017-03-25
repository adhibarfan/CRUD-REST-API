/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arfan.adhib.controller;

import com.arfan.adhib.domain.Barang;
import com.arfan.adhib.service.BarangService;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author emerio
 */
@RestController
@RequestMapping("/api")
public class BarangController {

    @Autowired
    private BarangService barangService;

    @GetMapping("/barang")
    public Page<Barang> getBarangs(Pageable pageable) {
        return barangService.getBarangs(pageable);
    }

    @PostMapping(value = "/barang")
    public Map<String, Object> saveBarang(@RequestBody Barang barang) {
        barangService.save(barang);

        Map<String, Object> map = new HashMap<>();
        map.put("Success", Boolean.TRUE);
        map.put("Info", "Data Berhasil Disimpan");
        return map;
    }

    @PutMapping(value = "/barang")
    public Map<String, Object> updateBarang(@RequestBody Barang barang) {
        barangService.update(barang);

        Map<String, Object> map = new HashMap<>();
        map.put("Success", Boolean.TRUE);
        map.put("Info", "Data Berhasil Diupdate");
        return map;
    }

    @DeleteMapping(value = "/barang/{idBarang}")
    public Map<String, Object> deleteBarang(@PathVariable("idBarang") String idBarang) {
        if (idBarang == null) {
            System.out.println("com.arfan.adhib.controller.BarangController.deleteBarang()");
        }
        barangService.delete(idBarang);

        Map<String, Object> map = new HashMap<>();
        map.put("Success", Boolean.TRUE);
        map.put("Info", "Data Berhasil Dihapus");
        return map;
    }

    @GetMapping("/barang/{idBarang}")
    public Barang getBarang(@PathVariable("idBarang") String idBarang) {
        System.out.println(idBarang);
        if (idBarang == null) {
            System.out.println("id kosong !!!");
        }
        return barangService.getBarang(idBarang);
    }

}

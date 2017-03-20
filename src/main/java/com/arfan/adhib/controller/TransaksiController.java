/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arfan.adhib.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author emerio
 */
@RestController
@RequestMapping("/api")
public class TransaksiController {
    
    @Secured(value = {"ROLE_USER"})
    @GetMapping("/transaksi")
    public List<Map<String, Object>> getTransaksi(){
        List<Map<String, Object>> dataList = new ArrayList<>();
        
        for (int i = 0; i < 10; i++) {
            Map<String, Object> map = new HashMap<>();
            map.put("angka", i);
            dataList.add(map);
        }
        return dataList;
    } 
    
   
    @GetMapping("/barang")
    public List<Map<String, Object>> getBarang(){
        List<Map<String, Object>> dataList = new ArrayList<>();
        
        for (int i = 0; i < 10; i++) {
            Map<String, Object> map = new HashMap<>();
            map.put("barang", i);
            dataList.add(map);
        }
        return dataList;
    } 
}

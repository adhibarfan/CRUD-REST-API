/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arfan.adhib.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author emerio
 */
@Entity
@Table(name = "tb_barang")
public class Barang implements Serializable{
    
    @Id
    @Column(name = "id_barang")
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    private String idBarang;
    
    @Column(name = "nama_barang", length = 50 , nullable = false)
    private String namaBarang;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "jenis_barang", length = 6, nullable = false)
    private JenisBarang jenisBarang;
    
    @Column(name = "jumlah_barang", length = 5, nullable = false)
    private Integer jumlahBarang;
    
    @Column(name = "harga_barang", nullable = false)
    private BigDecimal hargaBarang;
    
    @Column(name = "gambar_barang", length = 40, nullable = false)
    private String gambarBarang;

    public String getIdBarang() {
        return idBarang;
    }

    public void setIdBarang(String idBarang) {
        this.idBarang = idBarang;
    }

    public String getNamaBarang() {
        return namaBarang;
    }

    public void setNamaBarang(String namaBarang) {
        this.namaBarang = namaBarang;
    }

    public JenisBarang getJenisBarang() {
        return jenisBarang;
    }

    public void setJenisBarang(JenisBarang jenisBarang) {
        this.jenisBarang = jenisBarang;
    }

    public Integer getJumlahBarang() {
        return jumlahBarang;
    }

    public void setJumlahBarang(Integer jumlahBarang) {
        this.jumlahBarang = jumlahBarang;
    }

    public BigDecimal getHargaBarang() {
        return hargaBarang;
    }

    public void setHargaBarang(BigDecimal hargaBarang) {
        this.hargaBarang = hargaBarang;
    }

    public String getGambarBarang() {
        return gambarBarang;
    }

    public void setGambarBarang(String gambarBarang) {
        this.gambarBarang = gambarBarang;
    }
    
    
}

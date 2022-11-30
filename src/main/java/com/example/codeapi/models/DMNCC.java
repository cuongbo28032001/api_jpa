package com.example.codeapi.models;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "DM_NCC")
public class DMNCC {
    @Id
    private long ID;
    @Column(name = "TEN_NGAN", nullable = false)
    private String tenNgan;
    @Column(name = "TEN_DAY_DU", nullable = true)
    private String tenDayDu;
    @Column(name = "DIA_CHI_GD", nullable = false)
    private String diaChiGD;
    @Column(name = "DIA_CHI_TT", nullable = false)
    private String diaChiTT;
    @Column(name = "MA_SO_THUE", nullable = false)
    private String maSoThue;
    @Column(name = "LIEN_HE_AM", nullable = false)
    private String lienHeAM;
    @Column(name = "LIEN_HE_TD", nullable = true)
    private String lienHeTD;
    @Column(name = "LIEN_HE_KT", nullable = true)
    private String lienHeKT;
    @Column(name = "NGAY_TAO", nullable = true)
    @CreationTimestamp
    private Date ngayTao;
    @Column(name = "NGAY_SUA", nullable = true)
    @UpdateTimestamp
    private Date ngaySua;
    @Column(name = "NGUOI_TAO", nullable = true)
    private String nguoiTao;
    @Column(name = "NGUOI_SUA", nullable = true)
    private String nguoiSua;
    @Column(name = "MA", nullable = false)
    private String ma;

    public DMNCC() {
    }

    public DMNCC(long ID, String tenNgan, String tenDayDu, String diaChiGD, String diaChiTT, String maSoThue, String lienHeAM, String lienHeTD, String lienHeKT, Date ngayTao, Date ngaySua, String nguoiTao, String nguoiSua, String ma) {
        this.ID = ID;
        this.tenNgan = tenNgan;
        this.tenDayDu = tenDayDu;
        this.diaChiGD = diaChiGD;
        this.diaChiTT = diaChiTT;
        this.maSoThue = maSoThue;
        this.lienHeAM = lienHeAM;
        this.lienHeTD = lienHeTD;
        this.lienHeKT = lienHeKT;
        this.ngayTao = ngayTao;
        this.ngaySua = ngaySua;
        this.nguoiTao = nguoiTao;
        this.nguoiSua = nguoiSua;
        this.ma = ma;
    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public String getTenNgan() {
        return tenNgan;
    }

    public void setTenNgan(String tenNgan) {
        this.tenNgan = tenNgan;
    }

    public String getTenDayDu() {
        return tenDayDu;
    }

    public void setTenDayDu(String tenDayDu) {
        this.tenDayDu = tenDayDu;
    }

    public String getDiaChiGD() {
        return diaChiGD;
    }

    public void setDiaChiGD(String diaChiGD) {
        this.diaChiGD = diaChiGD;
    }

    public String getDiaChiTT() {
        return diaChiTT;
    }

    public void setDiaChiTT(String diaChiTT) {
        this.diaChiTT = diaChiTT;
    }

    public String getMaSoThue() {
        return maSoThue;
    }

    public void setMaSoThue(String maSoThue) {
        this.maSoThue = maSoThue;
    }

    public String getLienHeAM() {
        return lienHeAM;
    }

    public void setLienHeAM(String lienHeAM) {
        this.lienHeAM = lienHeAM;
    }

    public String getLienHeTD() {
        return lienHeTD;
    }

    public void setLienHeTD(String lienHeTD) {
        this.lienHeTD = lienHeTD;
    }

    public String getLienHeKT() {
        return lienHeKT;
    }

    public void setLienHeKT(String lienHeKT) {
        this.lienHeKT = lienHeKT;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    public Date getNgaySua() {
        return ngaySua;
    }

    public void setNgaySua(Date ngaySua) {
        this.ngaySua = ngaySua;
    }

    public String getNguoiTao() {
        return nguoiTao;
    }

    public void setNguoiTao(String nguoiTao) {
        this.nguoiTao = nguoiTao;
    }

    public String getNguoiSua() {
        return nguoiSua;
    }

    public void setNguoiSua(String nguoiSua) {
        this.nguoiSua = nguoiSua;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }
}

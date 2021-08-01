package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.entity.Diem;
import com.example.demo.entity.SinhVien;

import org.springframework.stereotype.Service;

@Service
public class SinhVienDAO {
    List<SinhVien> listsv = new ArrayList<>();

    public List<SinhVien> getAll() {
        return listsv;
    }

    public SinhVien getById(long id) {
        for (SinhVien sv : listsv) {
            if (sv.getMasv() == id) {
                return sv;
            }
        }
        return null;
    }

    public List<SinhVien> addSV(SinhVien sv) {
        listsv.add(sv);
        return listsv;
    }

    public SinhVien findByName(String name) {
        for (SinhVien sv : listsv) {
            if (sv.getName().equals(name)) {
                return sv;
            }
        }
        return null;
    }

    public List<SinhVien> delete(long id) {
        for (SinhVien sv : listsv) {
            if (sv.getMasv() == id) {
                listsv.remove(sv);
            }
        }
        return listsv;
    }

    public SinhVien update(long id, SinhVien sinhvien) {
        for (SinhVien sv : listsv) {
            if (sv.getMasv() == id) {
                SinhVien s = new SinhVien();
                s.setMasv(sv.getMasv());
                listsv.remove(sv);
                s.setName(sinhvien.getName());
                s.setLop(sinhvien.getLop());
                s.setLsdiem(sinhvien.getLsdiem());
                listsv.add(s);
                return s;
            }
        }
        return null;
    }

    public List<SinhVien> getAllByLop(String malop) {
        List<SinhVien> ds = new ArrayList<>();
        for (SinhVien sv : listsv) {
            if (sv.getLop().getMalop().equals(malop)) {
                ds.add(sv);
            }
        }
        return ds;
    }
}

package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.entity.Lop;

import org.springframework.stereotype.Service;

@Service
public class LopDAO {
    List<Lop> lsLop = new ArrayList<>();

    public List<Lop> getall() {
        return lsLop;
    }

    public List<Lop> addLop(Lop l) {
        lsLop.add(l);
        return lsLop;
    }

    public Lop findByName(String name) {
        for (Lop l : lsLop) {
            if (l.getTenlop().equals(name)) {
                return l;
            }
        }
        return null;
    }

    public Lop update(String malop, Lop lop) {
        for (Lop l : lsLop) {
            if (l.getMalop().equals(malop)) {
                Lop a = new Lop();
                a.setMalop(lop.getMalop());
                a.setTenlop(lop.getTenlop());
                lsLop.remove(l);
                lsLop.add(a);
                return a;
            }
        }
        return null;
    }

    public List<Lop> delete(String malop) {
        for (Lop l : lsLop) {
            if (l.getMalop().equals(malop)) {
                lsLop.remove(l);
                return lsLop;
            }
        }
        return null;
    }
}

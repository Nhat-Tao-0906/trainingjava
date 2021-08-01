package com.example.demo.controller;

import java.util.List;

import com.example.demo.services.SinhVienDAO;
import com.example.demo.entity.SinhVien;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sinh-vien")
public class svController {

    @Autowired
    SinhVienDAO sinhVienDAO;

    @GetMapping("/get-all")
    public List<SinhVien> getallsv() {
        return sinhVienDAO.getAll();
    }

    @PostMapping("/add-sinh-vien")
    public List<SinhVien> addSV(@RequestBody SinhVien sv) {
        return sinhVienDAO.addSV(sv);
    }

    @GetMapping("/find-by-name/{name}")
    public SinhVien findByName(@PathVariable String name) {
        return sinhVienDAO.findByName(name);
    }

    @GetMapping("/find-by-id/{id}")
    public SinhVien findByName(@PathVariable long id) {
        return sinhVienDAO.getById(id);
    }

    @PostMapping("/delete/{id}")
    public List<SinhVien> delete(@PathVariable long id) {
        return sinhVienDAO.delete(id);
    }

    @PutMapping("/update/{id}")
    public SinhVien update(@RequestBody SinhVien sv, @PathVariable long id) {
        return sinhVienDAO.update(id, sv);
    }

    @GetMapping("/get-by-lop/{malop}")
    public List<SinhVien> getByLop(@PathVariable String malop) {
        return sinhVienDAO.getAllByLop(malop);
    }

}

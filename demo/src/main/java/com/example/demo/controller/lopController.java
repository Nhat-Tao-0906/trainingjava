package com.example.demo.controller;

import java.util.List;

import com.example.demo.services.LopDAO;
import com.example.demo.entity.Lop;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/lop")
public class lopController {

    @Autowired
    LopDAO lopDAO;

    @PostMapping("/add-lop")
    public List<Lop> addLop(@RequestBody Lop lop) {
        return lopDAO.addLop(lop);
    }

    @GetMapping("/get-all")
    public List<Lop> getall() {
        return lopDAO.getall();
    }

    @GetMapping("/find-by-name/{name}")
    public Lop findByName(@PathVariable String name) {
        return lopDAO.findByName(name);
    }

    @PutMapping("/update/{malop}")
    public Lop update(@PathVariable String malop, @RequestBody Lop lop) {
        return lopDAO.update(malop, lop);
    }

    @PostMapping("/delete/{malop}")
    public List<Lop> delete(@PathVariable String malop) {
        return lopDAO.delete(malop);
    }

}

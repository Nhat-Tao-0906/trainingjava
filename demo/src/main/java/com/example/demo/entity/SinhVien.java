package com.example.demo.entity;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class SinhVien {
    long masv;
    String name;
    Lop lop;
    List<Diem> lsdiem;
}

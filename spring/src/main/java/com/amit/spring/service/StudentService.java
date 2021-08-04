package com.amit.spring.service;

import java.util.List;

import com.amit.spring.domain.ClassDomain;
import com.amit.spring.domain.StudentDomain;
import com.amit.spring.model.Student;
import com.amit.spring.model.request.AddStudentRequest;
import com.amit.spring.model.response.BaseResponse;
import com.amit.spring.model.utils.ApiException;
import com.amit.spring.model.utils.ERROR;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    StudentDomain studentDomain;

    @Autowired
    ClassDomain classDomain;

    public BaseResponse<List<Student>> getAllStudent() {
        BaseResponse<List<Student>> response = new BaseResponse<>();
        response.setData(studentDomain.getAllStudent());
        return response;
    }

    public BaseResponse<String> createdStudent(AddStudentRequest request) throws ApiException {
        if (StringUtils.isBlank(request.getName())) {
            throw new ApiException(ERROR.INVALID_PARAM, "Tên sinh viên không được bỏ trống");
        }

        if (classDomain.findById(request.getIdclass()) == null) {
            throw new ApiException(ERROR.NOT_FOUND, "Lớp không tốn tại");
        }

        studentDomain.createdStudent(request.getIdclass(), request.getName());
        return new BaseResponse<String>();
    }

    public BaseResponse<String> delete(Integer id) throws ApiException {
        if (studentDomain.findById(id) == null) {
            throw new ApiException(ERROR.NOT_FOUND, "Không tìm thấy sinh viên");
        }

        studentDomain.delete(id);
        return new BaseResponse<>();
    }

    public BaseResponse<String> update(Integer id, AddStudentRequest request) throws ApiException {
        if (studentDomain.findById(id) == null) {
            throw new ApiException(ERROR.NOT_FOUND, "Không tìm thấy sinh viên");
        }

        if (StringUtils.isBlank(request.getName())) {
            throw new ApiException(ERROR.INVALID_PARAM, "Tên sinh viên không được bỏ trống");
        }

        if (classDomain.findById(request.getIdclass()) == null) {
            throw new ApiException(ERROR.NOT_FOUND, "Lớp không tốn tại");
        }

        studentDomain.update(id, request.getIdclass(), request.getName());

        return new BaseResponse<String>();
    }

    public BaseResponse<Student> findById(Integer id) throws ApiException {
        if (studentDomain.findById(id) == null) {
            throw new ApiException(ERROR.NOT_FOUND, "Không tìm thấy sinh viên");
        }
        BaseResponse<Student> response = new BaseResponse<>();
        response.setData(studentDomain.findById(id));
        return response;
    }

    public BaseResponse<Student> findByName(String name) throws ApiException {
        if (studentDomain.findByName(name) == null) {
            throw new ApiException(ERROR.NOT_FOUND, "Không tìm thấy sinh viên");
        }
        BaseResponse<Student> response = new BaseResponse<>();
        response.setData(studentDomain.findByName(name));
        return response;
    }
}

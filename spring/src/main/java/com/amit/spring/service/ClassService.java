package com.amit.spring.service;

import java.util.List;

import com.amit.spring.domain.ClassDomain;
import com.amit.spring.model.Class;
import com.amit.spring.model.Student;
import com.amit.spring.model.request.AddClassRequest;
import com.amit.spring.model.response.BaseResponse;
import com.amit.spring.model.utils.ApiException;
import com.amit.spring.model.utils.ERROR;

import org.apache.commons.lang3.StringUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClassService {
    @Autowired
    ClassDomain classDomain;

    public BaseResponse<List<Class>> getAllClass() {
        BaseResponse<List<Class>> response = new BaseResponse<>();
        response.setData(classDomain.getAllClass());
        return response;
    }

    public BaseResponse<String> createdClass(AddClassRequest request) throws ApiException {
        if (StringUtils.isBlank(request.getName())) {
            throw new ApiException(ERROR.INVALID_PARAM, "Tên của lớp không được để trống");
        }

        if (classDomain.findByName(request.getName()) != null) {
            throw new ApiException(ERROR.CLASS_NAME_EXIST);
        }

        classDomain.createdClass(request.getName());
        return new BaseResponse<>();
    }

    public BaseResponse<Class> findByName(String name) throws ApiException {
        if (classDomain.findByName(name) == null) {
            throw new ApiException(ERROR.NOT_FOUND, "Không tìm thấy tên lớp");
        }
        BaseResponse<Class> response = new BaseResponse<>();
        response.setData(classDomain.findByName(name));
        return response;
    }

    public BaseResponse<Class> findById(Integer id) throws ApiException {
        if (classDomain.findById(id) == null) {
            throw new ApiException(ERROR.NOT_FOUND, "Không tìm thấy id lớp");
        }
        BaseResponse<Class> response = new BaseResponse<>();
        response.setData(classDomain.findById(id));
        return response;
    }

    public BaseResponse<String> delete(Integer id) throws ApiException {
        if (classDomain.findById(id) == null) {
            throw new ApiException(ERROR.NOT_FOUND, "Không tìm thấy id lớp");
        }

        classDomain.delete(id);
        return new BaseResponse<>();
    }

    public BaseResponse<String> update(Integer id, AddClassRequest request) throws ApiException {
        if (classDomain.findById(id) == null) {
            throw new ApiException(ERROR.NOT_FOUND, "Không tìm thấy id lớp");
        }

        if (StringUtils.isBlank(request.getName())) {
            throw new ApiException(ERROR.INVALID_PARAM, "Tên của lớp không được để trống");
        }

        if (classDomain.findByName(request.getName()) != null) {
            throw new ApiException(ERROR.CLASS_NAME_EXIST);
        }

        classDomain.update(id, request.getName());
        return new BaseResponse<>();
    }

    public BaseResponse<List<Student>> getListStudent(Integer id) throws ApiException {
        if (classDomain.findById(id) == null) {
            throw new ApiException(ERROR.NOT_FOUND, "Không tìm thấy id lớp");
        }

        BaseResponse<List<Student>> response = new BaseResponse<>();
        response.setData(classDomain.getListStudent(id));
        return response;
    }
}

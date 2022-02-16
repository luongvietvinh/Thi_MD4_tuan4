package com.baithi_md4.service;

import com.baithi_md4.model.QuocGia;
import com.baithi_md4.repository.QuocGiaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class QuocGiaServiceImpl implements IQuocGiaService{

    @Autowired
    QuocGiaRepo quocGiaRepo;
    @Override
    public List<QuocGia> findAll() {
        return (List<QuocGia>) quocGiaRepo.findAll();
    }
}

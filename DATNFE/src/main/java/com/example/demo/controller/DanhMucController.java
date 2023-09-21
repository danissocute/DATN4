package com.example.demo.controller;

import com.example.demo.entity.DanhMuc;
import com.example.demo.repository.DanhMucRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class DanhMucController {
    @Autowired
    DanhMucRepo danhMucRepo;
    @RequestMapping("")
    public String slidebar() {
        return "sildebar/sildebar";
    }
    @RequestMapping("/admin/danhmuc")
    public String danhMuc(@ModelAttribute("danhmuc") DanhMuc danhMuc) {
        return "product/danh_muc";
    }

    @PostMapping("/admin/danhmuc/create")
    public String createDanhMuc(@ModelAttribute("danhmuc") DanhMuc danhMuc) {
        danhMucRepo.createDanhMuc(danhMuc);
        return "redirect:/admin/danhmuc";
    }

    @RequestMapping("/admin/danhmuc/detail/{ma}")
    public String createDanhMuc(@PathVariable("ma") String ma, Model model) {
        model.addAttribute("danhmuc", danhMucRepo.getDanhMucByMa(ma));
        return "product/danh_muc";
    }

    @ModelAttribute("listDanhMuc")
    public List<DanhMuc> getListDanhMuc() {
        return danhMucRepo.getListDanhMuc();
    }
}

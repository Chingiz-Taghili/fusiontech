package com.multishop.fusiontech.controllers.admin;

import com.multishop.fusiontech.dtos.brand.BrandCreateDto;
import com.multishop.fusiontech.dtos.brand.BrandUpdateDto;
import com.multishop.fusiontech.dtos.brand.BrandDto;
import com.multishop.fusiontech.models.Brand;
import com.multishop.fusiontech.services.BrandService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class BrandController {

    private final BrandService brandService;

    public BrandController(BrandService brandService) {
        this.brandService = brandService;
    }

    @GetMapping("/admin/brand")
    public String showIndexPage(Model model) {
        List<BrandDto> brands = brandService.getAllBrands();
        model.addAttribute("brands", brands);
        return "/admin/brand/index";
    }

    @GetMapping("/admin/brand/create")
    public String showCreatePage() {
        return "/admin/brand/create";
    }

    @PostMapping("/admin/brand/create")
    public String createBrand(BrandCreateDto brandCreateDto) {
        boolean result = brandService.createBrand(brandCreateDto);
        if (result) {
            return "redirect:/admin/brand";
        }
        return "redirect:/admin/brand/create";
    }

    @GetMapping("/admin/brand/update/{id}")
    public String showUpdatePage(@PathVariable Long id, Model model) {
        Brand brand = brandService.getBrandById(id);
        model.addAttribute("brand", brand);
        return "/admin/brand/update";
    }

    @PostMapping("/admin/brand/update/{id}")
    public String updateBrand(BrandUpdateDto brandUpdateDto, @PathVariable Long id) {
        boolean result = brandService.updateBrand(id, brandUpdateDto);
        if (result) {
            return "redirect:/admin/brand";
        }
        return "redirect:/admin/brand/update";
    }

    @GetMapping("admin/brand/delete/{id}")
    public String showDeletePage(@PathVariable Long id, Model model) {
        Brand brand = brandService.getBrandById(id);
        model.addAttribute("brand", brand);
        return "/admin/brand/delete";
    }

    @PostMapping("/admin/brand/delete/{id}")
    public String deleteBrand(@RequestParam Long brandId) {
        brandService.deleteBrand(brandId);
        return "redirect:/admin/brand";
    }
}

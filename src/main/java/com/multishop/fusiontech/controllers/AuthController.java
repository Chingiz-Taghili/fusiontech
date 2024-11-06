package com.multishop.fusiontech.controllers;

import com.multishop.fusiontech.dtos.category.CategoryDto;
import com.multishop.fusiontech.dtos.user.UserCreateDto;
import com.multishop.fusiontech.services.CategoryService;
import com.multishop.fusiontech.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;
import java.util.List;

@Controller
public class AuthController {

    private final UserService userService;
    private final CategoryService categoryService;

    public AuthController(UserService userService, CategoryService categoryService) {
        this.userService = userService;
        this.categoryService = categoryService;
    }

    @GetMapping("/login")
    public String showLoginPage(Model model, Principal principal) {

        List<CategoryDto> categories = categoryService.getAllCategories();
        model.addAttribute("categories", categories);

        int cartSize;
        int favoriteSize;
        if (principal == null) {
            cartSize = 0;
            favoriteSize = 0;
        } else {
            cartSize = userService.getUserCartSize(principal.getName());
            favoriteSize = userService.getUserFavoriteSize(principal.getName());
        }
        model.addAttribute("cartSize", cartSize);
        model.addAttribute("favoriteSize", favoriteSize);

        return "auth/login";
    }

    @GetMapping("/register")
    public String showRegisterPage(Model model, Principal principal) {

        List<CategoryDto> categories = categoryService.getAllCategories();
        model.addAttribute("categories", categories);

        int cartSize;
        int favoriteSize;
        if (principal == null) {
            cartSize = 0;
            favoriteSize = 0;
        } else {
            cartSize = userService.getUserCartSize(principal.getName());
            favoriteSize = userService.getUserFavoriteSize(principal.getName());
        }
        model.addAttribute("cartSize", cartSize);
        model.addAttribute("favoriteSize", favoriteSize);

        return "auth/register";
    }

    @PostMapping("/register")
    public String createAccount(UserCreateDto userCreateDto) {
        boolean result = userService.createUser(userCreateDto);
        if (result) {
            return "redirect:/login";
        }
        return "redirect:/register";
    }
}

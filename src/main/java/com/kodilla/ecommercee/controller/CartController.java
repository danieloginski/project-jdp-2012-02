package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.domain.CartEntry;
import com.kodilla.ecommercee.dto.AddCartEntryDto;
import com.kodilla.ecommercee.dto.CartDto;
import com.kodilla.ecommercee.dto.CartEntryDto;
import com.kodilla.ecommercee.mapper.CartEntryMapper;
import com.kodilla.ecommercee.mapper.CartMapper;
import com.kodilla.ecommercee.service.CartDbService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@FieldDefaults(level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("v1/cart")
public class CartController {

    final CartEntryMapper cartEntryMapper;
    final CartDbService service;
    final CartMapper cartMapper;


    @PostMapping(value = "createCart")
    public CartDto createCart() {
        return cartMapper.mapToCartDto(service.createCart());
    }

    @GetMapping(value = "getProducts/{cartId}")
    public List<CartEntryDto> getProducts(@PathVariable Long cartId) {
        List<CartEntry> products = service.getProducts(cartId);
        return cartEntryMapper.mapToCartEntryDtoList(products);
    }

    @PostMapping(value = "addProduct")
    public CartEntryDto addProduct(@RequestBody AddCartEntryDto addCartEntryDto) {
        CartEntry newEntry = service.addProduct(addCartEntryDto);
        return cartEntryMapper.mapToCartEntryDto(newEntry);
    }

    @DeleteMapping(value = "deleteProduct/{cartEntryId}")
    public void deleteProduct(@PathVariable Long cartEntryId) {
        service.deleteProduct(cartEntryId);
    }

    @DeleteMapping(value = "deleteCart/{cartId}")
    public void deleteCart(@PathVariable Long cartId) {service.deleteCart(cartId);}

}

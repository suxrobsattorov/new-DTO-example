package com.example.service;

import com.example.dto.ProductDTO;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class ProductService {
    private Long generalId = 1L;
    private List<ProductDTO.Response.Private> privateList = new LinkedList<>();
    private List<ProductDTO.Response.Public> publicList = new LinkedList<>();

    public ProductDTO.Response.Private createProduct(ProductDTO.Request.Create dto) {
        ProductDTO.Response.Private p = new ProductDTO.Response.Private(generalId++,
                dto.getName(), dto.getPrice(), dto.getCost());
        privateList.add(p);
        return p;
    }

    public List<ProductDTO.Response.Public> getAllPublicProduct() {
        for (ProductDTO.Response.Private p : privateList) {
            ProductDTO.Response.Public aPublic = new ProductDTO.Response.Public(p.getId(), p.getName(), p.getPrice());
            publicList.add(aPublic);
        }
        return publicList;
    }

    public ProductDTO.Response.Public getByIdPublicProduct(Long id) {
        for (ProductDTO.Response.Public p : publicList) {
            if (p.getId().equals(id))
                return p;
        }
        return null;
    }

    public List<ProductDTO.Response.Private> getAllPrivateProduct() {
        return privateList;
    }

    public ProductDTO.Response.Private getByIdPrivateProduct(Long id) {
        for (ProductDTO.Response.Private p : privateList) {
            if (p.getId().equals(id))
                return p;
        }
        return null;
    }
}

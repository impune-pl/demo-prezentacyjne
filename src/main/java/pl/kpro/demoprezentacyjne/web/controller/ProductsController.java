package pl.kpro.demoprezentacyjne.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.kpro.demoprezentacyjne.data.entity.Product;
import pl.kpro.demoprezentacyjne.data.repository.ProductRepository;
import pl.kpro.demoprezentacyjne.data.service.ProductService;
import pl.kpro.demoprezentacyjne.web.payload.request.NewProductRequest;
import pl.kpro.demoprezentacyjne.web.payload.request.ProductEditRequest;
import pl.kpro.demoprezentacyjne.web.payload.response.ProductEditResponse;

import java.util.Optional;

/**
 * @author Krzysztof 'impune_pl' Prorok <Krzysztof1397@gmail.com>
 */
@Controller
@RequestMapping("/product")
public class ProductsController
{
    private final ProductRepository productRepository;
    private final ProductService productService;

    @Autowired
    public ProductsController(ProductRepository productRepository, ProductService productService)
    {
        this.productRepository = productRepository;
        this.productService = productService;
    }

    @GetMapping
    public String indexProducts(Model model)
    {
        model.addAttribute("products",productRepository.findAll());
        return "products";
    }

    @GetMapping(path="/{productId}")
    public String productDetails(@PathVariable Long productId, Model model)
    {
        Optional<Product> product = productRepository.findById(productId);
        if(product.isPresent())
            model.addAttribute("product", product.get());
        else
            return "redirect:/product/";
        return "product";
    }

    @GetMapping(path="/{productId}/edit")
    public String editProductDetails(@PathVariable Long productId, Model model)
    {
        Optional<Product> product = productRepository.findById(productId);
        if(product.isPresent())
            model.addAttribute("product",new ProductEditResponse(product.get()));
        else
            return "redirect:/product/";
        return "editProduct";
    }
    @PostMapping(path="/{productId}/edit")
    public String editProductDetails(@PathVariable Long productId, ProductEditRequest productEditRequest)
    {
        productEditRequest.setId(productId);
        productService.saveEdit(productEditRequest);
        return "redirect:/product/";
    }

    @GetMapping(path="/new")
    public String newProductDetails(Model model)
    {
        model.addAttribute("product", new NewProductRequest());
        return "newProduct";
    }

    @PostMapping(path="/new")
    public String newProduct(NewProductRequest newProduct)
    {
        productService.saveNew(newProduct);
        return "redirect:/product/";
    }
}

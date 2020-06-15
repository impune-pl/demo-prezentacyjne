package pl.kpro.demoprezentacyjne.data.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.kpro.demoprezentacyjne.data.entity.Product;
import pl.kpro.demoprezentacyjne.data.repository.ProductRepository;
import pl.kpro.demoprezentacyjne.web.payload.request.NewProductRequest;
import pl.kpro.demoprezentacyjne.web.payload.request.ProductEditRequest;

/**
 * @author Krzysztof 'impune_pl' Prorok <Krzysztof1397@gmail.com>
 */
@Service
public class ProductService
{
    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository)
    {
        this.productRepository = productRepository;
    }

    public void saveEdit(ProductEditRequest productEditRequest)
    {
        Product editedProduct = productRepository.findById(productEditRequest.getId()).orElseThrow();
        editedProduct.setDescription(productEditRequest.getDescription());
        editedProduct.setInventory(productEditRequest.getInventory());
        editedProduct.setName(productEditRequest.getName());
        editedProduct.setPrice(productEditRequest.getPrice());
        productRepository.saveAndFlush(editedProduct);
    }

    public void saveNew(NewProductRequest newProductRequest)
    {
        Product newProduct = new Product();
        newProduct.setDescription(newProductRequest.getDescription());
        newProduct.setInventory(newProductRequest.getInventory());
        newProduct.setName(newProductRequest.getName());
        newProduct.setPrice(newProductRequest.getPrice());
        productRepository.saveAndFlush(newProduct);
    }
}

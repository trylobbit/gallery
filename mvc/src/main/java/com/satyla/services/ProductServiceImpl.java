package com.satyla.services;


import com.satyla.currency.CurrencyService;
import com.satyla.model.Product;
import com.satyla.repositories.ProductRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;


@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final CurrencyService currencyService;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, CurrencyService currencyService) {
        this.productRepository = productRepository;
        this.currencyService = currencyService;
    }

    @Override
    public void add(Product product) {
        productRepository.save(product);
    }

    @Override
    public void updateProduct(long id, Product productUpdate) {
        Optional<Product> product = productRepository.findById(id);
        if (product.isPresent()) {
            Product productFromBase = product.get();
            productFromBase.setName(productUpdate.getName());
            productFromBase.setPrice(productUpdate.getPrice());
            productFromBase.setAmount(productUpdate.getAmount());
        }
    }

    @Override
    public List<Product> getAllProducts(String currencyCode) {

        return StringUtils.isNotBlank(currencyCode) ? getCustomCurrencyProducts(currencyCode) : getProducts();
    }

    private List<Product> getProducts() {
        Iterable<Product> products = productRepository.findAll();
        return StreamSupport.stream(products.spliterator(), false)
                .collect(Collectors.toList());
    }

    private List<Product> getCustomCurrencyProducts(String currencyCode) {
        BigDecimal rate = currencyService.getRateForCode(Currency.getInstance(currencyCode));

       return getProducts().stream()
               .map(product -> {
                    Product productNewPrice = new Product(product);
                    productNewPrice.setPrice(product.getPrice().divide(rate, 2));
                    return productNewPrice;
                })
               .collect(Collectors.toList());
   }

}

package au.com.dius.pactworkshop.consumer;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.List;

@Service
public class ProductService {
    private final RestTemplate restTemplate;
    private final Logger LOG;

    @Autowired
    public ProductService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
        this.LOG = LoggerFactory.getLogger(ProductService.class);
    }

    public List<Product> getAllProducts() {
        LOG.info("Getting all products");
        return restTemplate.exchange("/products",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Product>>(){}).getBody();
    }

    public Product getProduct(String id) {
        LOG.info("Requested getProducts with id {}", id);
        return restTemplate.getForEntity("/products/{id}", Product.class, id).getBody();
    }
}

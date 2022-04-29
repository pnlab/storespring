package com.example.learn;

import com.example.learn.model.Product;
import com.example.learn.repository.ProductRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace =  AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
public class ProductRepositoryTests {
    @Autowired private ProductRepository repo;

    @Test
    public void testAddNew(){
        Product sp = new Product();
        sp.setName("Sua");
        sp.setDescription("");
        sp.setPrice(10000F);
        sp.setQuantity(10);
        sp.setUnit("Hop");

        Product spSave = repo.save(sp);
        Assertions.assertThat(spSave).isNotNull();
        Assertions.assertThat(spSave.getId()).isGreaterThan(0);

    }
}

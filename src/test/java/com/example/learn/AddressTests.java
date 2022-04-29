package com.example.learn;


import com.example.learn.model.Address;
import com.example.learn.repository.AddressRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace =  AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
public class AddressTests {
    @Autowired private AddressRepository repo;

    @Test
    public void testAddNew(){
        Address ad = new Address();
        ad.setStreet("Nguyen Van Troi");
        ad.setCity("Ha Noi");
        ad.setState("Ha Noi");
        ad.setZip("100000");
        Address adRes = repo.save(ad);

        Assertions.assertThat(adRes).isNotNull();
        Assertions.assertThat(adRes.getId()).isGreaterThan(0);
    }
}

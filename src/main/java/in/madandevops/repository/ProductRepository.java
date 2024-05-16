package in.madandevops.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import in.madandevops.binding.Product;

public interface ProductRepository extends JpaRepository<Product, Serializable> {

}

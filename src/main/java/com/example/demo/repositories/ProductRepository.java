package com.example.demo.repositories;

import com.example.demo.entity.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ProductRepository extends JpaRepository<Products, Integer> {
    @Query(value = "SELECT * FROM clothes.products as p , \n" +
            "clothes.categories c where p.cate_id = c.id \n" +
            "and c.id = :cateId \n" +
            "and p.product_name like %:productName%", nativeQuery = true)
    List<Products> findByCateProductName(@Param("cateId") int cateId,@Param("productName") String productName);
    @Query(value = "select * from products p, categories c\n" +
            "where p.cate_id = c.id\n" +
            "and c.id = :idCate", nativeQuery = true)
    List<Products> findProductByCate(@Param("idCate") int idCate);
}

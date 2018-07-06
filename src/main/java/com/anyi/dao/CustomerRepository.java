package com.anyi.dao;

import com.anyi.pojo.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends ElasticsearchRepository<Customer,String>{
    List<Customer> findNameByName(String name);
    List<Customer> findByPhone(String phone, Pageable pageable);
    @Query("{\"bool\" : {\"must\" : {\"term\" : {\"phone\" : \"?0\"}}}}")
    List<Customer> findByPhone(String phone);


}

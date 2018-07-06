package com.anyi.service;

import com.anyi.dao.CustomerRepository;
import com.anyi.pojo.Customer;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
//
import java.util.List;
//import java.util.Optional;
//
@Service
public class CustomerService {
    @Autowired private CustomerRepository customerRepository;
    public List<Customer> findByPhone(String phone){
        Sort sort = new Sort(Sort.Direction.ASC,"id");
        Pageable pageable = PageRequest.of(1,10);
        return  customerRepository.findByPhone(phone);
    }
    public Customer save(Customer customer){
        return customerRepository.save(customer);
    }
//    public Iterable<Customer> findAll(){
//        return  customerRepository.findAll();
//    }
//    public Optional<Customer> findCustomerById(String id){
//        return  customerRepository.findById(id);
//    }
//
    public List<Customer> findByName(String name){
        return customerRepository.findNameByName(name);
    }
    public Iterable<Customer> findAll(){
        Sort sort = new Sort(Sort.Direction.ASC,"createTime");
        Pageable pageable = PageRequest.of(1,5,sort);
//        QueryBuilder queryBuilder = QueryBuilders.matchQuery("name","alen1323"); //精确匹配
//        QueryBuilder queryBuilder = QueryBuilders.multiMatchQuery("alen1323","phone","name");// 匹配个filed
        QueryBuilder queryBuilder = QueryBuilders.wildcardQuery("name","*alen*");//模糊匹配
//          QueryBuilder queryBuilder = QueryBuilders.matchAllQuery();// 匹配所有
        return customerRepository.search(queryBuilder,pageable);
//        return  customerRepository.findAll();
    }

    public Iterable<Customer> findByAllPage(){
        Sort sort = new Sort(Sort.Direction.DESC,"id");
        Pageable pageable = PageRequest.of(1,10);
        return  customerRepository.findAll();
    }
////    public Iterable<Customer> findCustomerBySort(){
////        Sort sort = new Sort(Sort.Direction.DESC,"name");
////        return  customerRepository.findAll(sort);
////    }
//
////    public List<Customer> findByDSL(String search){
////        Pageable pageable = PageRequest.of(1,10);
////        FunctionScoreQueryBuildr functionScoreQueryBuilder = QueryBuilders.functionScoreQuery().add(QueryBuilders.boolQuery().should(QueryBuilders.matchQuery("name", search))
//
//        ;
////    }
}

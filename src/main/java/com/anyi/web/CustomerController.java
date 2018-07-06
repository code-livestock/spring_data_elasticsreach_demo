package com.anyi.web;

import com.anyi.pojo.Customer;
import com.anyi.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@ResponseBody
public class CustomerController {
    @Autowired
    private  CustomerService customerService;
    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public  void save(@RequestBody Customer customer){
        customer.setCreateTime(new Date());
        customerService.save(customer);
    }
//
//    @RequestMapping(value = "/findAll",method = RequestMethod.POST)
//    public Iterable<Customer> findAll(@RequestBody Customer customer){
////        customer.setCreateTime(new Date());
//        return customerService.findAll();
//    }
//
//    @RequestMapping(value = "/findCustomerById",method = RequestMethod.POST)
//    public Optional<Customer> findCustomerById(@RequestBody Customer customer){
//        String id = customer.getId();
//        return customerService.findCustomerById(id);
//    }
//
    @RequestMapping(value = "/findCustomerByName",method = RequestMethod.POST)
    public List<Customer> findCustomerByName(@RequestBody Customer customer){
        String name = customer.getName();
        return customerService.findByName(name);
    }
    @RequestMapping(value = "/findByPhone",method = RequestMethod.POST)
    public List<Customer> findByPhone(@RequestBody Customer customer){
        String phone = customer.getPhone();
        return customerService.findByPhone(phone);
    }
    @RequestMapping(value = "/findByAllPage",method = RequestMethod.POST)
    public Iterable<Customer> findByAllPage(@RequestBody Customer customer){
     String name = customer.getName();
        return customerService.findByAllPage();
    }

    @RequestMapping(value = "/findAll",method = RequestMethod.POST)
    public Iterable<Customer> findAll(@RequestBody Customer customer){
       String name = customer.getName();
        return customerService.findAll();
   }
}

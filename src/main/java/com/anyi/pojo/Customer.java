package com.anyi.pojo;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.io.Serializable;
import java.util.Date;

@Data

@Document( indexName = "index_customer_test",type = "type_customer_test",shards = 5,replicas = 0,indexStoreType = "memory")
public class Customer implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    private String id;
//    @Field
    private String name;
//    @Field
    private String phone;
//    @Field
    private String email;
//    @Field
    private String cardType;
//    @Field
    private String cardId;
//    @Field
    private int age;
//    @Field
    private char sex;
//    @Field
    private Date birthday;
//    @Field
    private String address;
//    @Field
//    @Field(format = DateFormat.basic_date_time)
    private Date createTime;
//    @Field
//     @Field(format = DateFormat.basic_date_time)
    private Date updateTime;


}

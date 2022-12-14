package com.batuhanaslan.elasticsearch.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.Date;

@Document(indexName = "customers")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    @Id
    private String id;
    @Field(name = "name",type = FieldType.Text)
    private String name;
    @Field(name = "sur_name",type = FieldType.Text)
    private String surName;
    @Field(name = "address",type = FieldType.Text)
    private String address;
    @Field(name = "birthday",type = FieldType.Date)
    private Date birthday;

}

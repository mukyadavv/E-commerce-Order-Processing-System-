package com.app.Ecommerce.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.io.Serializable;

@Data
@Document(indexName = "orders")
public class Order implements Serializable {

    @Id
    private String orderId;

    @Field(type = FieldType.Text)
    private String product;

    @Field(type = FieldType.Integer)
    private int quantity;

    @Field(type = FieldType.Double)
    private double price;
}

package com.example.back.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Entity(name = "product")
@Table(name = "product")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "product_id")
	private int productId;

	@Column(name = "product_name")
	private String productName;

	@Column(name = "product_image_path")
	private String productImagePath;

	@Column(name = "product_price")
	private double productPrice;

	@Column(name = "product_for")
	private String productFor;

	@Column(name = "product_type")
	private String productType;

	@Column(name = "product_color")
	private String productColor;

	@Column(name = "product_add_date", columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP",insertable=false, updatable=false)
	private Timestamp productAddDate;

}

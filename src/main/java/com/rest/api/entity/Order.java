package com.rest.api.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="Order_Details")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Order implements Serializable{
	
	private static final long serialVersionUID = 1720727204346740048L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="order_id")
	private Long orderId;
	
	private String orderDate;
	
	private String description;
	
	private String status;
	
	private String email;
	
	        
	@OneToMany(mappedBy="order",cascade=CascadeType.ALL)
	//@Fetch(FetchMode.JOIN)
	private List<Item> items;
	
}

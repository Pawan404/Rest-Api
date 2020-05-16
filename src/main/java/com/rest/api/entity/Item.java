package com.rest.api.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Item implements Serializable {
	
	private static final long serialVersionUID = 3421644577041577208L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="item_id")
	private Long itemId;
	
	private String itemName;
	
	private double itemPrice;
	
	private String itemDescription;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="order_id",referencedColumnName="order_id",insertable=true)
	private Order order;


}

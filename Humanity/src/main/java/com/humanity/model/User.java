package com.humanity.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="USERS")
public class User {
	
	@Id
	@Column(name="USERNAME")
	private String username;
	
	@Column(name="PASSWORD")
	private String password;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="CARTS_USERNAME")
	@JsonIgnore
	private Cart cart;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="ORDERS_USERNAME")
	@JsonIgnore
	private OrderHistory orderHistory;

	
	public User() {
		super();
	}

	public User(String username, String password, Cart cart, OrderHistory orderHistory) {
		super();
		this.username = username;
		this.password = password;
		this.cart = cart;
		this.orderHistory = orderHistory;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public OrderHistory getOrderHistory() {
		return orderHistory;
	}

	public void setOrderHistory(OrderHistory orderHistory) {
		this.orderHistory = orderHistory;
	}
	
	
}

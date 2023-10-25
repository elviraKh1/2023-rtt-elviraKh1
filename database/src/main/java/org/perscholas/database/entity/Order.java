package org.perscholas.database.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	@OneToMany(mappedBy = "order",
			fetch = FetchType.LAZY,
			cascade = CascadeType.ALL)
	private List<OrderDetail> ordersDetail;

	@Column(name = "customer_id", insertable = false, updatable = false)
	private Integer customerId;

	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "customer_id", nullable = false)
	private Customer customer;

	@Column(name = "order_date")
	@Temporal(TemporalType.DATE)
	private Date orderDate;

	@Column(name = "required_date")
	@Temporal(TemporalType.DATE)
	private Date requiredDate;

	@Column(name = "shipped_date")
	@Temporal(TemporalType.DATE)
	private Date shippedDate;

	@Column(name = "status")
	private String status;

	@Column(name = "comments", columnDefinition = "text")
	private String comments;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public Date getRequiredDate() {
		return requiredDate;
	}

	public void setRequiredDate(Date requiredDate) {
		this.requiredDate = requiredDate;
	}

	public Date getShippedDate() {
		return shippedDate;
	}

	public void setShippedDate(Date shippedDate) {
		this.shippedDate = shippedDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<OrderDetail> getOrdersDetail() {
		return ordersDetail;
	}

	public void setOrdersDetail(List<OrderDetail> ordersDetail) {
		this.ordersDetail = ordersDetail;
	}

	@Override
	public String toString() {
		return "\nOrder [id=" + id + ", customerId=" + customerId + ", customer=" + customer + ", orderDate=" + orderDate
				+ ", requiredDate=" + requiredDate + ", shippedDate=" + shippedDate + ", status=" + status
				+ ", comments=" + comments + "]\n\n";
	}

	
	
}

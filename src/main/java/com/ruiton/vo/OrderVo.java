package com.ruiton.vo;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 订单
 * @author weiminke
 *
 */
@SuppressWarnings("serial")
public class OrderVo extends BaseVo{
	Long id;
	String no;
	String area;
	String address;
	String customerName;
	Integer weight;
	String patient;
	String orderNo;
	String paymentUnit;
	Date receiptTime;
	Date shipmentTime;
	Date effectiveTime;
	String model;
	String singlejaw;
	String material;
	BigDecimal price;
	String paymentDesc;
	Date paymentTime;
	String eBrace;
	String followPerson;
	String salePerson;
	
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * @return the no
	 */
	public String getNo() {
		return no;
	}
	/**
	 * @param no the no to set
	 */
	public void setNo(String no) {
		this.no = no;
	}
	/**
	 * @return the area
	 */
	public String getArea() {
		return area;
	}
	/**
	 * @param area the area to set
	 */
	public void setArea(String area) {
		this.area = area;
	}
	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * @return the customerName
	 */
	public String getCustomerName() {
		return customerName;
	}
	/**
	 * @param customerName the customerName to set
	 */
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	/**
	 * @return the weight
	 */
	public Integer getWeight() {
		return weight;
	}
	/**
	 * @param weight the weight to set
	 */
	public void setWeight(Integer weight) {
		this.weight = weight;
	}
	/**
	 * @return the patient
	 */
	public String getPatient() {
		return patient;
	}
	/**
	 * @param patient the patient to set
	 */
	public void setPatient(String patient) {
		this.patient = patient;
	}
	/**
	 * @return the orderNo
	 */
	public String getOrderNo() {
		return orderNo;
	}
	/**
	 * @param orderNo the orderNo to set
	 */
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	/**
	 * @return the paymentUnit
	 */
	public String getPaymentUnit() {
		return paymentUnit;
	}
	/**
	 * @param paymentUnit the paymentUnit to set
	 */
	public void setPaymentUnit(String paymentUnit) {
		this.paymentUnit = paymentUnit;
	}
	/**
	 * @return the receiptTime
	 */
	public Date getReceiptTime() {
		return receiptTime;
	}
	/**
	 * @param receiptTime the receiptTime to set
	 */
	public void setReceiptTime(Date receiptTime) {
		this.receiptTime = receiptTime;
	}
	/**
	 * @return the shipmentTime
	 */
	public Date getShipmentTime() {
		return shipmentTime;
	}
	/**
	 * @param shipmentTime the shipmentTime to set
	 */
	public void setShipmentTime(Date shipmentTime) {
		this.shipmentTime = shipmentTime;
	}
	/**
	 * @return the effectiveTime
	 */
	public Date getEffectiveTime() {
		return effectiveTime;
	}
	/**
	 * @param effectiveTime the effectiveTime to set
	 */
	public void setEffectiveTime(Date effectiveTime) {
		this.effectiveTime = effectiveTime;
	}
	/**
	 * @return the model
	 */
	public String getModel() {
		return model;
	}
	/**
	 * @param model the model to set
	 */
	public void setModel(String model) {
		this.model = model;
	}
	/**
	 * @return the singlejaw
	 */
	public String getSinglejaw() {
		return singlejaw;
	}
	/**
	 * @param singlejaw the singlejaw to set
	 */
	public void setSinglejaw(String singlejaw) {
		this.singlejaw = singlejaw;
	}
	/**
	 * @return the material
	 */
	public String getMaterial() {
		return material;
	}
	/**
	 * @param material the material to set
	 */
	public void setMaterial(String material) {
		this.material = material;
	}
	/**
	 * @return the price
	 */
	public BigDecimal getPrice() {
		return price;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	/**
	 * @return the paymentDesc
	 */
	public String getPaymentDesc() {
		return paymentDesc;
	}
	/**
	 * @param paymentDesc the paymentDesc to set
	 */
	public void setPaymentDesc(String paymentDesc) {
		this.paymentDesc = paymentDesc;
	}
	/**
	 * @return the paymentTime
	 */
	public Date getPaymentTime() {
		return paymentTime;
	}
	/**
	 * @param paymentTime the paymentTime to set
	 */
	public void setPaymentTime(Date paymentTime) {
		this.paymentTime = paymentTime;
	}
	/**
	 * @return the eBrace
	 */
	public String geteBrace() {
		return eBrace;
	}
	/**
	 * @param eBrace the eBrace to set
	 */
	public void seteBrace(String eBrace) {
		this.eBrace = eBrace;
	}
	/**
	 * @return the followPerson
	 */
	public String getFollowPerson() {
		return followPerson;
	}
	/**
	 * @param followPerson the followPerson to set
	 */
	public void setFollowPerson(String followPerson) {
		this.followPerson = followPerson;
	}
	/**
	 * @return the salePerson
	 */
	public String getSalePerson() {
		return salePerson;
	}
	/**
	 * @param salePerson the salePerson to set
	 */
	public void setSalePerson(String salePerson) {
		this.salePerson = salePerson;
	}

}

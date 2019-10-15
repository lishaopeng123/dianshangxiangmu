package cn.com.shop.cart.pojo;

import cn.com.shop.product.pojo.Product;


public class CartItem {
	
	//购物项
	
	private Product product;//商品
	private int count;//数量
	private double subTotal;//小计
	
	
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
	
	
	
	public double getSubTotal() {
		
		//小计只能获取 数量*商品价格
		
		return count*product.getShopPrice();
	}
	
	
	
	public void setSubTotal(double subTotal) {
		this.subTotal = subTotal;
	}
	
	
	

}

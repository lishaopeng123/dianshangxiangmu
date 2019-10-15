package cn.com.shop.cart.pojo;

import java.util.Collection;
import java.util.LinkedHashMap;

public class Cart {
	
	//购物车
	//封装购物项
	//因为购物车有多个购物项  使用map集合存储 方便查询 增删比较频繁 使用linkhashMap<>
	//使用商品的pid作为主键 购物项作为值
	
	
	//购物项的封装
	private LinkedHashMap<Integer,CartItem> map = new LinkedHashMap<Integer,CartItem>();
	//总金额
	private double total;
	
	
	
	//添加购物项
	/*
	 * 1.先去判断集合里是否有，如果有就加一，没有就添加（获取pid）
	 * 
	 * */
	public void addCartItem(CartItem cartItem){
		//获取新添加的购物项的商品pid
		Integer pid = cartItem.getProduct().getPid();
		//判断购物车map是否包含此商品
		if(map.containsKey(pid)){
			
			//存在
			//拿到已存在的购物项
			CartItem cartItem2 = map.get(pid);
			//已存在的和新添加的累加然后重新设置进去
		//	cartItem2.getCount()+cartItem.getCount();
			cartItem2.setCount(cartItem2.getCount()+cartItem.getCount());
			
			
		}else{
			
			//不存在直接添加
			map.put(pid, cartItem);
		}
		
		//总金额发生变化
		//total=total+cartItem.getSubTotal();
		total+=cartItem.getSubTotal();
	}

	//移除购物项  根据键删除
	public void removeCart(int pid){
		//移除 map集合根据键移除 返回的就是所移除的值
		CartItem cartItem = map.remove(pid);
		//总金额发生变化
		total -=cartItem.getSubTotal();		
	}
	
	//清空购物车
	public void clear(){
		
		map.clear();
		//总金额为 0
		total=0.0;
	}
	
	//获取总金额
	public double getTotal(){
		
		return total;
	}
	
	//获取所有的购物项      目的：方便页面展示
	public Collection<CartItem> getCartItem(){
		
		return map.values();
	}
	
	
	

}

package cn.com.shop.cart.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.com.shop.cart.pojo.Cart;
import cn.com.shop.cart.pojo.CartItem;
import cn.com.shop.product.service.ProductService;

@Controller
@RequestMapping("/cart")
public class CartController {
	
	@Autowired
	private ProductService productService;
	
	
	@RequestMapping("/toCart")
	public String toCart(){
		
		return "cart";
	}

	
	//添加购物车
	@RequestMapping("/addCart")
	public String addCart(int count,Integer pid,HttpServletRequest request){
		
		//封装购物项
		CartItem cartItem = new CartItem();
		cartItem.setCount(count);
		cartItem.setProduct(productService.findProductBypid(pid));
		
		//封装购物车
		//Cart cart = new Cart();
		Cart cart = getCart(request);
		cart.addCartItem(cartItem);
		
		//request.setAttribute("cart", cart);
		
		return "cart";
	}
	
	
	
	//删除购物项
	@RequestMapping("/removeCart")
	public String removeCart(HttpServletRequest request,Integer pid){
		
		Cart cart = getCart(request);
		cart.removeCart(pid);
		return "cart";
	}


	//创建购物车
	private Cart getCart(HttpServletRequest request) {
		Cart cart = (Cart) request.getSession().getAttribute("cart");
		//判断购物车是否存在
		if(cart==null){
			
			//创建并存入session
			cart = new Cart();
			request.getSession().setAttribute("cart", cart);
			return cart;
		}else{
			return cart; 
		}
	}
	
}

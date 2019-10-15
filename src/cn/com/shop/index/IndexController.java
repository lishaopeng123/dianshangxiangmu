package cn.com.shop.index;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.com.shop.category.pojo.Category;
import cn.com.shop.category.service.CategoryService;
import cn.com.shop.product.pojo.Product;
import cn.com.shop.product.service.ProductService;

@Controller
public class IndexController {

	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private ProductService productService;
	
	//去首页
	@RequestMapping("/index")
	public String index(HttpServletRequest request,Model model){
		
		//查询一级导航
		/*List<Category> clist =  categoryService.findCategory();
		model.addAttribute("clist", clist);*/
		
		
		//查询一级导航关联查询二级导航
		List<Category> clist = categoryService.findCategoryAndCategorysecond();
		request.getSession().setAttribute("clist", clist);
		
		//查询热门商品 1.is_host=1  2.根据日期降序排序 3.只要十条数据
		List<Product> plist = productService.findHotProduct();
		request.setAttribute("plist", plist);
		
		//查询最新商品 is_host=0   只要十条数据
		List<Product> nlist = productService.findNewProduct();
		model.addAttribute("nlist", nlist);
		
		
		return "index";
	}
}

package cn.com.shop.category.pojo;

import java.util.List;

import cn.com.shop.categorysecond.pojo.Categorysecond;

public class Category {
    private Integer cid;

    private String cname;
    
    //一对多关联
   private List<Categorysecond> clists;
   
   
   
    

	public List<Categorysecond> getClists() {
	return clists;
}

public void setClists(List<Categorysecond> clists) {
	this.clists = clists;
}

	public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname == null ? null : cname.trim();
    }
}
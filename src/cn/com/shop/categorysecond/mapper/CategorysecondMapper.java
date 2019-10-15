package cn.com.shop.categorysecond.mapper;

import cn.com.shop.categorysecond.pojo.Categorysecond;
import cn.com.shop.categorysecond.pojo.CategorysecondExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CategorysecondMapper {
    int countByExample(CategorysecondExample example);

    int deleteByExample(CategorysecondExample example);

    int deleteByPrimaryKey(Integer csid);

    int insert(Categorysecond record);

    int insertSelective(Categorysecond record);

    List<Categorysecond> selectByExample(CategorysecondExample example);

    Categorysecond selectByPrimaryKey(Integer csid);

    int updateByExampleSelective(@Param("record") Categorysecond record, @Param("example") CategorysecondExample example);

    int updateByExample(@Param("record") Categorysecond record, @Param("example") CategorysecondExample example);

    int updateByPrimaryKeySelective(Categorysecond record);

    int updateByPrimaryKey(Categorysecond record);
}
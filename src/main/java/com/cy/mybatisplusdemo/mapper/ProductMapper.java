package com.cy.mybatisplusdemo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cy.mybatisplusdemo.pojo.Product;

//继承了BaseMapper<Product>后即可直接调用增删改查方法
public interface ProductMapper extends BaseMapper<Product> {


}

package com.cy.mybatisplusdemo.mapper;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cy.mybatisplusdemo.pojo.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
public class MybatisPlusTests {
    //自动装配变量
    @Autowired
    private ProductMapper productMapper;

    //插入信息
    @Test
    public void test01(){
        Product product = new Product();
        product.setName("kun");
        product.setImages("小鸡子图");
        product.setPrice(2.5);
        productMapper.insert(product);
    }

    //根据id删除记录
    @Test
    public void test02(){
        productMapper.deleteById(2);
    }

    //根据id集批量删除记录
    @Test
    public void test03(){
        ArrayList<Integer> ids = new ArrayList<>(){{
            add(4);
            add(3);
        }};

        //放一个集合
        productMapper.deleteBatchIds(ids);
    }

    //根据条件删除记录
    @Test
    public void test04(){
        //map里面存放的是where条件
        Map<String,Object> col = new HashMap<>(){{
            put("name","kun");
        }};
        productMapper.deleteByMap(col);
    }

    //根据封装的条件对象删除记录
    @Test
    public void test05(){
        /**
         * Wrapper<T> queryWrapper：表示封装的是一个删除条件对象，
         * 读取queryWrapper中的条件，根据设置中的条件来删除内容
         * int delete(@Param(constants.WRAPPER) Wrapper<T> queryWrapper) 需要传入一个wrapper条件对象
         * 条件对象可以看做是where后面的条件
         */

        //创建wrapper更新条件对象
        UpdateWrapper<Product> wrapper = new UpdateWrapper<>();
        //gt方法表示大于，传递两个参数，哪个字段大于哪个值
        wrapper.gt("price",2).or().likeRight("name","kun");
        productMapper.delete(wrapper);

        /**
         * AND("AND"),OR("OR"),NOT("NOT"),IN("IN"),NOT_IN("NOT IN"),LIKE("LIKE"),
         * NOT_LIKE("NOT LIKE"),EQ("="),NE("<>"),GT(">"),GE(">="),LT("<"),LE("<="),
         * IS_NULL("IS NULL"),IS_NOT_NULL("IS NOT NULL"),GROUP_BY("GROUP BY"),HAVING("HAVING"),
         * ORDER_BY("ORDER BY"),EXISTS("EXISTS"),NOT_EXISTS("NOT EXISTS"),BETWEEN("BETWEEN"),
         * NOT_BETWEEN("NOT BETWEEN"),ASC("ASC"), DESC("DESC");
         */
    }

    //更新记录
    @Test
    public void test06(){
        //定义一个实体对象，id是要更新的记录对应的id，其他字段是要更新后的数据
        Product product = new Product();
        product.setId(6);
        product.setName("kun");
        product.setImages("小鸡子");
        product.setPrice(2.5);
        productMapper.updateById(product);
    }

    //根据条件更新记录
    @Test
    public void test07(){
        //定义一个实体对象，id是要更新的记录对应的id，其他字段是要更新后的数据
        Product product = new Product();
        //根据条件只需要提供要更新的id
        product.setId(6);

        //定义条件对象
        UpdateWrapper<Product> wrapper = new UpdateWrapper<>();
        //ge表示大于等于
        wrapper.ge("price",2.5).set("name","坤坤子").set("goods_stock",10);
        productMapper.update(product,wrapper);
    }
}

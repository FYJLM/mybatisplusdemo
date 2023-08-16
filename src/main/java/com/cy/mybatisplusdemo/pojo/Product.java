package com.cy.mybatisplusdemo.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
// MyBatis-Plus提供一 个映射注解: @TabLeName("表名")
@TableName("t_product") //表示标记当前实体类对应的数据库表的映射
public class Product implements Serializable {
    //指定当前实体类中那一个字段和数据库中的表id字段映射
    @TableId(type = IdType.AUTO) // MyBatis-Plus的id值自增策略
    private Integer id;
    private String name;
    private Double price;
    private String flag;
    // aTableField("goods_ desc")
    private String goodsDesc; // goods_ desc
    private String images;
    private Integer goodsStock;
    private String goodsType;
    private String createdUser;
    private Date createdTime;
    private String modifiedUser;
    private Date modifiedTime;
}


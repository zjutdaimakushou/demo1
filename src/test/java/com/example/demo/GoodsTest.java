package com.example.demo;

import com.example.demo.controller.GoodsController;
import com.example.demo.mapper.GoodsMapper;
import com.example.demo.model.Goods;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class GoodsTest {
    GoodsMapper goodsMapper;

    @Autowired
    public void setGoodsMapper(GoodsMapper goodsMapper) {
        this.goodsMapper = goodsMapper;
    }

    @Test
    public void insertgoods(){
        goodsMapper.insert("ºÎ¶«î£",12,12312,3213,"ºÃ","sadasdqw");
    }

    @Test
    public void selectgoods(){
        ArrayList<Goods> goodsList=goodsMapper.select();
        System.out.println("a");
        System.out.println(goodsList.isEmpty());
        System.out.println(goodsList);

    }

    @Test
    public void deletegoods(){
        System.out.println(goodsMapper.delete(1));
    }
}

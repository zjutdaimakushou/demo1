package com.example.demo.mapper;

import com.example.demo.model.Goods;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.sql.Blob;
import java.util.ArrayList;


@Mapper
@Repository
public interface GoodsMapper {
    @Insert("insert into Goods(gname,gcost,gnumber,gean,gdescription,gimage) VALUES (#{name},#{cost},#{number},#{ean},#{description},#{Filepath})")
    int insert(String name, float cost , int number , int ean ,String description ,String Filepath);

    @Select("select gid id,gname name,gcost cost,gnumber number,gean ean,gdescription description,gimage path from Goods where gid=#{id}")
    Goods selectid(int id);

    @Select("select gid id,gname name,gcost cost,gnumber number,gean ean,gdescription description,gimage path from Goods")
    ArrayList<Goods> select();

    @Delete("delete from Goods where gid=#{id}")
    int delete(int id);

    @Update("update Goods set gname=#{name}, gcost=#{cost}, gnumber=#{number},gean=#{ean},gdescription=#{description},gimage=#{path} where gid=#{id}")
    int update(int id, String name, float cost , int number , int ean ,String description,String path);
}

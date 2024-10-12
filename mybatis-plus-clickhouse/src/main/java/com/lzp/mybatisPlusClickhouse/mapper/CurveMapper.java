package com.lzp.mybatisPlusClickhouse.mapper;


import com.lzp.mybatisPlusClickhouse.entity.Curve;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

//@Mapper
public interface CurveMapper {


    List<Curve> selectAll();
}

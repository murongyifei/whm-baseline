package com.lzp.mybatisPlusClickhouse.service.impl;

import com.lzp.mybatisPlusClickhouse.entity.Curve;
import com.lzp.mybatisPlusClickhouse.mapper.CurveMapper;
import com.lzp.mybatisPlusClickhouse.service.ICurveService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
// @DataSource(value = DataSourceType.SLAVE)
public class CurveServiceImpl implements ICurveService {


    //private final CurveMapper curveMapper;


    @Override
    public List<Curve> selectAll() {
        return null; // curveMapper.selectAll();
    }
}

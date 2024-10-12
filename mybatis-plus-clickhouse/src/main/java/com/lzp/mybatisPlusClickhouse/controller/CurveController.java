package com.lzp.mybatisPlusClickhouse.controller;

import com.lzp.mybatisPlusClickhouse.service.ICurveService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/curve")
@Slf4j
@RequiredArgsConstructor
public class CurveController {

    private final ICurveService iCurveService;

    @GetMapping("/list")
    public void list() {
        System.out.println(iCurveService.selectAll());
    }

}

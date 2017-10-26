package com.yihaomen.inter;

import com.yihaomen.model.ReverseEngineer;

public interface ReverseEngineerMapper {
    int insert(ReverseEngineer record);

    int insertSelective(ReverseEngineer record);
}
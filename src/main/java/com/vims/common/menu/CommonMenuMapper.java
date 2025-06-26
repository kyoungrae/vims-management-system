package com.vims.common.menu;

import com.system.common.base.CommonMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CommonMenuMapper extends CommonMapper<CommonMenu> {
    List<CommonMenu> SELECT_HIERARCHY(CommonMenu request);
}
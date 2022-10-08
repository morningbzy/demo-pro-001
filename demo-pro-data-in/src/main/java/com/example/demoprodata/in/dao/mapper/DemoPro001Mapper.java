package com.example.demoprodata.in.dao.mapper;

import com.example.demoprodata.in.dao.entity.DemoPro001;
import com.example.demoprodata.in.dao.entity.DemoPro001Example;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DemoPro001Mapper {
    long countByExample(DemoPro001Example example);

    int deleteByExample(DemoPro001Example example);

    int insert(DemoPro001 record);

    int insertSelective(DemoPro001 record);

    List<DemoPro001> selectByExample(DemoPro001Example example);

    int updateByExampleSelective(@Param("record") DemoPro001 record, @Param("example") DemoPro001Example example);

    int updateByExample(@Param("record") DemoPro001 record, @Param("example") DemoPro001Example example);
}
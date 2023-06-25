package rdc.platform.java.mbg.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import rdc.platform.java.mbg.model.ConfigColumn;
import rdc.platform.java.mbg.model.ConfigColumnExample;

public interface ConfigColumnMapper {
    int countByExample(ConfigColumnExample example);

    int deleteByExample(ConfigColumnExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ConfigColumn record);

    int insertSelective(ConfigColumn record);

    List<ConfigColumn> selectByExample(ConfigColumnExample example);

    ConfigColumn selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ConfigColumn record, @Param("example") ConfigColumnExample example);

    int updateByExample(@Param("record") ConfigColumn record, @Param("example") ConfigColumnExample example);

    int updateByPrimaryKeySelective(ConfigColumn record);

    int updateByPrimaryKey(ConfigColumn record);
}
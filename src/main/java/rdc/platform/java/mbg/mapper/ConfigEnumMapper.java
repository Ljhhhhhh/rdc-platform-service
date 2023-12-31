package rdc.platform.java.mbg.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import rdc.platform.java.mbg.model.ConfigEnum;
import rdc.platform.java.mbg.model.ConfigEnumExample;

public interface ConfigEnumMapper {
    int countByExample(ConfigEnumExample example);

    int deleteByExample(ConfigEnumExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ConfigEnum record);

    int insertSelective(ConfigEnum record);

    List<ConfigEnum> selectByExample(ConfigEnumExample example);

    ConfigEnum selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ConfigEnum record, @Param("example") ConfigEnumExample example);

    int updateByExample(@Param("record") ConfigEnum record, @Param("example") ConfigEnumExample example);

    int updateByPrimaryKeySelective(ConfigEnum record);

    int updateByPrimaryKey(ConfigEnum record);
}
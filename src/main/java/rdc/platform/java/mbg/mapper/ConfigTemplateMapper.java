package rdc.platform.java.mbg.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import rdc.platform.java.mbg.model.ConfigTemplate;
import rdc.platform.java.mbg.model.ConfigTemplateExample;

public interface ConfigTemplateMapper {
    int countByExample(ConfigTemplateExample example);

    int deleteByExample(ConfigTemplateExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ConfigTemplate record);

    int insertSelective(ConfigTemplate record);

    List<ConfigTemplate> selectByExample(ConfigTemplateExample example);

    ConfigTemplate selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ConfigTemplate record, @Param("example") ConfigTemplateExample example);

    int updateByExample(@Param("record") ConfigTemplate record, @Param("example") ConfigTemplateExample example);

    int updateByPrimaryKeySelective(ConfigTemplate record);

    int updateByPrimaryKey(ConfigTemplate record);
}
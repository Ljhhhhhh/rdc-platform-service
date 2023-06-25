package rdc.platform.java.mbg.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import rdc.platform.java.mbg.model.TemplateColumn;
import rdc.platform.java.mbg.model.TemplateColumnExample;

public interface TemplateColumnMapper {
    int countByExample(TemplateColumnExample example);

    int deleteByExample(TemplateColumnExample example);

    int insert(TemplateColumn record);

    int insertSelective(TemplateColumn record);

    List<TemplateColumn> selectByExample(TemplateColumnExample example);

    int updateByExampleSelective(@Param("record") TemplateColumn record, @Param("example") TemplateColumnExample example);

    int updateByExample(@Param("record") TemplateColumn record, @Param("example") TemplateColumnExample example);
}
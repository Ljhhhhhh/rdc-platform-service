package rdc.platform.java.mbg.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import rdc.platform.java.mbg.model.ConfigDetail;
import rdc.platform.java.mbg.model.ConfigDetailExample;

public interface ConfigDetailMapper {
    int countByExample(ConfigDetailExample example);

    int deleteByExample(ConfigDetailExample example);

    int deleteByPrimaryKey(@Param("id") Integer id);

    int insert(ConfigDetail record);

    int insertSelective(ConfigDetail record);

    List<ConfigDetail> selectByExample(ConfigDetailExample example);

    ConfigDetail selectByPrimaryKey(@Param("id") Integer id);

    int updateByExampleSelective(@Param("record") ConfigDetail record, @Param("example") ConfigDetailExample example);

    int updateByExample(@Param("record") ConfigDetail record, @Param("example") ConfigDetailExample example);

    int updateByPrimaryKey(ConfigDetail record);

    int setTemplateUpdated(@Param("detail") ConfigDetail detail, @Param("templateUpdated") Boolean templateUpdated);
}
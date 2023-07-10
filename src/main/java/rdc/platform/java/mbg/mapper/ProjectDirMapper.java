package rdc.platform.java.mbg.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import rdc.platform.java.mbg.model.ProjectDir;
import rdc.platform.java.mbg.model.ProjectDirExample;

public interface ProjectDirMapper {
    int countByExample(ProjectDirExample example);

    int deleteByExample(ProjectDirExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ProjectDir record);

    List<ProjectDir> selectByExample(ProjectDirExample example);

    ProjectDir selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ProjectDir record, @Param("example") ProjectDirExample example);

    int updateByExample(@Param("record") ProjectDir record, @Param("example") ProjectDirExample example);

    int updateByPrimaryKeySelective(ProjectDir record);

    int updateByPrimaryKey(ProjectDir record);
}
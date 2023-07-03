package rdc.platform.java.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import rdc.platform.java.common.utils.ConverterToTree;
import rdc.platform.java.controller.ConfigEnumController;
import rdc.platform.java.mbg.mapper.ProjectDirMapper;
import rdc.platform.java.mbg.model.ProjectDir;
import rdc.platform.java.mbg.model.ProjectDirExample;
import rdc.platform.java.service.ProjectDirService;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

@Service
public class ProjectDirServiceImpl implements ProjectDirService {

    @Resource
    private ProjectDirMapper projectDirMapper;

    private static final Logger LOGGER = LoggerFactory.getLogger(ConfigEnumController.class);

    @Override
    public List<ProjectDir> projectDirTree(UUID projectId) {
        ProjectDirExample example = new ProjectDirExample();
        ProjectDirExample.Criteria criteria = example.createCriteria();
        criteria.andProjectIdEqualTo(projectId);
        List<ProjectDir> projectDirs = projectDirMapper.selectByExample(example);

        return ConverterToTree.convertToHierarchy(projectDirs);
    }

    @Override
    public int createDir(ProjectDir dir) {
        return projectDirMapper.insert(dir);
    }

    @Override
    public int updateDir(Integer id, ProjectDir dir) {
        dir.setId(id);
        return projectDirMapper.updateByPrimaryKey(dir);
    }

    @Override
    public int deleteDir(Integer id) {
        return projectDirMapper.deleteByPrimaryKey(id);
    }
}

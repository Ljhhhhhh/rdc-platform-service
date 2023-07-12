package rdc.platform.java.service.impl;

import io.swagger.models.auth.In;
import org.springframework.stereotype.Service;
import rdc.platform.java.mbg.mapper.ConfigDetailMapper;
import rdc.platform.java.mbg.mapper.ProjectDirMapper;
import rdc.platform.java.mbg.mapper.ProjectsMapper;
import rdc.platform.java.mbg.model.ConfigDetail;
import rdc.platform.java.mbg.model.ConfigDetailExample;
import rdc.platform.java.mbg.model.ProjectDir;
import rdc.platform.java.mbg.model.Projects;
import rdc.platform.java.service.ConfigDetailService;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ConfigDetailServiceImpl implements ConfigDetailService {

    @Resource
    private ConfigDetailMapper detailMapper;

    @Resource
    private ProjectDirMapper projectDirMapper;

    @Resource
    private ProjectsMapper projectsMapper;

    @Override
    public int createDetail(ConfigDetail detail) {
        return detailMapper.insertSelective(detail);
    }

    @Override
    public int updateDetail(Integer id, ConfigDetail detail) {
        detail.setId(id);
        return detailMapper.updateByPrimaryKey(detail);
    }

    @Override
    public int deleteDetail(Integer id) {
        return detailMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int deleteByDirId(Integer dirId) {
        ConfigDetailExample detail = new ConfigDetailExample();
        detail.createCriteria().andDirIdEqualTo(dirId);
        return detailMapper.deleteByExample(detail);
    }

    @Override
    public List<ConfigDetail> getFileDetail(Integer fileId) {
        ConfigDetailExample detail = new ConfigDetailExample();
        detail.createCriteria().andDirIdEqualTo(fileId);
        return detailMapper.selectByExample(detail);
    }

    @Override
    public List<ConfigDetail> getDetailsByTemplateId(Integer templateId) {
        ConfigDetailExample detail = new ConfigDetailExample();
        detail.createCriteria().andTemplateIdEqualTo(templateId);
        return detailMapper.selectByExample(detail);
    }

    @Override
    public List<ProjectDir> getDirsByTemplateId(Integer templateId) {
        List<ConfigDetail> list = getDetailsByTemplateId(templateId);
        if (list != null) {
            List<Integer> dirIds = list.stream()
                    .map(ConfigDetail::getDirId)
                    .collect(Collectors.toList());
            List<ProjectDir> results = new ArrayList<>();
            for (Integer dirId : dirIds) {
                ProjectDir dir = projectDirMapper.selectByPrimaryKey(dirId);
                Projects projectDir = projectsMapper.selectByPrimaryKey(dir.getProjectId());
                ProjectDir resultDir = addChildrenToParent(dir, projectDirMapper, projectDir.getName());
                results.add(resultDir);
            }
            return results;
        } else {
            return null;
        }
    }

    private ProjectDir addChildrenToParent(ProjectDir dir, ProjectDirMapper projectDirMapper, String projectName) {
        dir.setProjectName(projectName);
        if (dir.getParentId() != null) {
            ProjectDir parentDir = projectDirMapper.selectByPrimaryKey(dir.getParentId());
            if (parentDir != null) {
                parentDir.setChild(dir);
                parentDir = addChildrenToParent(parentDir, projectDirMapper, projectName);
                return parentDir;
            }
        }
        return dir;
    }

    @Override
    public int setTemplateUpdated(ConfigDetail detail, Boolean needUpdate) {
        return detailMapper.setTemplateUpdated(detail, needUpdate);
    }
}

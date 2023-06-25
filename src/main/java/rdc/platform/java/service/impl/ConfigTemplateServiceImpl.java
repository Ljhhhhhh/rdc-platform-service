package rdc.platform.java.service.impl;

import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;
import rdc.platform.java.mbg.mapper.ConfigColumnMapper;
import rdc.platform.java.mbg.mapper.ConfigTemplateMapper;
import rdc.platform.java.mbg.model.ConfigTemplate;
import rdc.platform.java.mbg.model.ConfigTemplateExample;
//import rdc.platform.java.mbg.model.TemplateColumn;
import rdc.platform.java.service.ConfigTemplateService;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ConfigTemplateServiceImpl implements ConfigTemplateService {

    @Resource
    private ConfigColumnMapper configColumnMapper;

    @Resource
    private ConfigTemplateMapper configTemplateMapper;

//    @Resource
//    private TemplateColumn templateColumn;

    @Override
    public List<ConfigTemplate> listTemplate(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return configTemplateMapper.selectByExample(new ConfigTemplateExample());
    }

    @Override
    public List<ConfigTemplate> listAllTemplate() {
        return configTemplateMapper.selectByExample(new ConfigTemplateExample());
    }

    @Override
    public int createTemplate(ConfigTemplate template) {
        configTemplateMapper.insertSelective(template);
        return template.getId();
    }

    @Override
    public int updateTemplate(Integer id, ConfigTemplate template) {
        template.setId(id);
        return configTemplateMapper.updateByPrimaryKey(template);
    }

    @Override
    public int deleteTemplate(Integer id) {
        return configTemplateMapper.deleteByPrimaryKey(id);
    }

    @Override
    public ConfigTemplate getTemplate(Integer id) {
        return configTemplateMapper.selectByPrimaryKey(id);
    }
}

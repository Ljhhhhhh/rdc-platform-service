package rdc.platform.java.service.impl;

import org.springframework.stereotype.Service;
import rdc.platform.java.mbg.mapper.ConfigColumnMapper;
import rdc.platform.java.mbg.mapper.ConfigTemplateMapper;
import rdc.platform.java.mbg.model.ConfigColumn;
import rdc.platform.java.mbg.model.ConfigColumnExample;
import rdc.platform.java.mbg.model.ConfigDetailExample;
import rdc.platform.java.service.ConfigColumnService;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ConfigColumnServiceImpl implements ConfigColumnService {

    @Resource
    private ConfigColumnMapper configColumnMapper;

    @Override
    public List<ConfigColumn> listAllBrand() {
        return null;
    }

    @Override
    public int createColumn(ConfigColumn column) {
        return 0;
    }

    @Override
    public int updateColumn(Integer id, ConfigColumn column) {
        return 0;
    }

    @Override
    public int deleteColumn(Integer id) {
        return 0;
    }

    @Override
    public ConfigColumn getColumn(Integer id) {
        return configColumnMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<ConfigColumn> getColumnsByEnumId(Integer enumId) {
        ConfigColumnExample columnExample = new ConfigColumnExample();
        columnExample.createCriteria().andLinkEnumIdEqualTo(enumId);
        return configColumnMapper.selectByExample(columnExample);
    }

    @Override
    public List<ConfigColumn> getColumnsByTemplateId(Integer templateId) {
        return null;
    }
}

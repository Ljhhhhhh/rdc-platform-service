package rdc.platform.java.service.impl;

import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;
import rdc.platform.java.mbg.mapper.ConfigEnumMapper;
import rdc.platform.java.mbg.model.*;
import rdc.platform.java.service.ConfigEnumService;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ConfigEnumServiceImpl implements ConfigEnumService {
    @Resource
    private ConfigEnumMapper enumMapper;

    @Override
    public List<ConfigEnum> listAllEnum() {
        return enumMapper.selectByExample(new ConfigEnumExample());
    }

    @Override
    public List<ConfigEnum> listEnum(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return enumMapper.selectByExample(new ConfigEnumExample());
    }

    @Override
    public ConfigEnum getEnum(Integer id) {
        return enumMapper.selectByPrimaryKey(id);
    }

    @Override
    public int createEnum(ConfigEnum configEnum) {
        return enumMapper.insertSelective(configEnum);
    }

    @Override
    public int updateEnum(Integer id, ConfigEnum configEnum) {
        configEnum.setId(id);
        return enumMapper.updateByPrimaryKeySelective(configEnum);
    }

    @Override
    public int deleteEnum(Integer id) {
        return enumMapper.deleteByPrimaryKey(id);
    }
}

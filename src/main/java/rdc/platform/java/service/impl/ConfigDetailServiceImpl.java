package rdc.platform.java.service.impl;

import org.springframework.stereotype.Service;
import rdc.platform.java.mbg.mapper.ConfigDetailMapper;
import rdc.platform.java.mbg.model.ConfigDetail;
import rdc.platform.java.mbg.model.ConfigDetailExample;
import rdc.platform.java.service.ConfigDetailService;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ConfigDetailServiceImpl implements ConfigDetailService {

    @Resource
    private ConfigDetailMapper detailMapper;

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
}

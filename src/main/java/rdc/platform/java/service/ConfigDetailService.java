package rdc.platform.java.service;

import rdc.platform.java.mbg.model.ConfigDetail;
import java.util.List;
public interface ConfigDetailService {
    int createDetail(ConfigDetail detail);

    int updateDetail(Integer id, ConfigDetail detail);

    int deleteDetail(Integer id);

    int deleteByDirId(Integer dirId);

    List<ConfigDetail> getFileDetail(Integer id);
}

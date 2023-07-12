package rdc.platform.java.service;

import rdc.platform.java.mbg.model.ConfigDetail;
import rdc.platform.java.mbg.model.ProjectDir;

import java.util.List;
public interface ConfigDetailService {
    int createDetail(ConfigDetail detail);

    int updateDetail(Integer id, ConfigDetail detail);

    int deleteDetail(Integer id);

    int deleteByDirId(Integer dirId);

    List<ConfigDetail> getFileDetail(Integer id);

    List<ConfigDetail> getDetailsByTemplateId(Integer templateId);

    List<ProjectDir> getDirsByTemplateId(Integer templateId);

    int setTemplateUpdated(ConfigDetail detail, Boolean templateUpdated);
}

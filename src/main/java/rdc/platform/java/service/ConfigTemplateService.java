package rdc.platform.java.service;

import rdc.platform.java.mbg.model.ConfigTemplate;

import java.util.List;

public interface ConfigTemplateService {
    List<ConfigTemplate> listTemplate(int pageNum, int pageSize);

    List<ConfigTemplate> listAllTemplate();

    int createTemplate(ConfigTemplate template);

    int updateTemplate(Integer id, ConfigTemplate template);

    int deleteTemplate(Integer id);

    ConfigTemplate getTemplate(Integer id);

    List<ConfigTemplate> getTemplateByEnumId(Integer enumId);
}

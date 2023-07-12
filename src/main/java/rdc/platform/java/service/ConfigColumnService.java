package rdc.platform.java.service;

import rdc.platform.java.mbg.model.ConfigColumn;

import java.util.List;

public interface ConfigColumnService {
    List<ConfigColumn> listAllBrand();

    int createColumn(ConfigColumn column);

    int updateColumn(Integer id, ConfigColumn column);

    int deleteColumn(Integer id);

    ConfigColumn getColumn(Integer id);

    List<ConfigColumn> getColumnsByEnumId(Integer enumId);

    List<ConfigColumn> getColumnsByTemplateId(Integer templateId);
}

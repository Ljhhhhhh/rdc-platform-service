package rdc.platform.java.service;

import rdc.platform.java.mbg.model.ConfigEnum;

import java.util.List;

public interface ConfigEnumService {
    List<ConfigEnum> listAllEnum();

    int createEnum(ConfigEnum configEnum);

    int updateEnum(Integer id, ConfigEnum enumInfo);

    int deleteEnum(Integer id);

    List<ConfigEnum> listEnum(int pageNum, int pageSize);

    ConfigEnum getEnum(Integer id);
}

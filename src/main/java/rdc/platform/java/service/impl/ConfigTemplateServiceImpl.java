package rdc.platform.java.service.impl;

import com.github.pagehelper.PageHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import rdc.platform.java.controller.ConfigEnumController;
import rdc.platform.java.mbg.mapper.ConfigColumnMapper;
import rdc.platform.java.mbg.mapper.ConfigTemplateMapper;
import rdc.platform.java.mbg.mapper.TemplateColumnMapper;
import rdc.platform.java.mbg.model.*;
import rdc.platform.java.service.ConfigTemplateService;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class ConfigTemplateServiceImpl implements ConfigTemplateService {

    @Resource
    private ConfigColumnMapper configColumnMapper;

    @Resource
    private ConfigTemplateMapper configTemplateMapper;

    @Resource
    private TemplateColumnMapper templateColumnMapper;

    private static final Logger LOGGER = LoggerFactory.getLogger(ConfigEnumController.class);

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
        int result = configTemplateMapper.insertSelective(template);
        if (result == 1) {
            int templateId = template.getId();
            // 获取columns列表
            List<ConfigColumn> columns = template.getColumns();
            try {
                // 遍历 columns 列表，插入 config_column 表并在 templateColumn 表中插入关联关系
                for (ConfigColumn column : columns) {
                    // 插入到 config_column 表
                    configColumnMapper.insertSelective(column);
                    int columnId = column.getId();

                    // 插入到 templateColumn 表，建立关联关系
                    TemplateColumn templateColumn = new TemplateColumn();
                    templateColumn.setTemplateId(templateId);
                    templateColumn.setColumnId(columnId);
                    templateColumnMapper.insertSelective(templateColumn);
                }
            } catch (Exception e) {
                LOGGER.info(e.getMessage());
                // 异常处理，可以记录日志或进行其他操作
                e.printStackTrace();
                throw new RuntimeException("创建模板失败");
            }

        }
        return result;
    }

    @Override
    public int updateTemplate(Integer id, ConfigTemplate template) {
        // TODO 当前模版是否已经被使用
        template.setId(id);
        List<ConfigColumn> columns = template.getColumns();
        for (ConfigColumn column : columns) {
            LOGGER.info("column:{}", column);
            configColumnMapper.updateByPrimaryKey(column);
        }
        return configTemplateMapper.updateByPrimaryKey(template);
    }

    @Override
    public int deleteTemplate(Integer id) {
        // TODO 当前模版是否已经被使用
        TemplateColumnExample templateColumn = new TemplateColumnExample();
        List<TemplateColumn> templateColumns = templateColumnMapper.selectByExample(templateColumn);
        for (TemplateColumn column : templateColumns) {
            configColumnMapper.deleteByPrimaryKey(column.getColumnId());
        }
        return configTemplateMapper.deleteByPrimaryKey(id);
    }

    @Override
    public ConfigTemplate getTemplate(Integer id) {
        ConfigTemplate template = configTemplateMapper.selectByPrimaryKey(id);
        TemplateColumnExample condition = new TemplateColumnExample();
        List<TemplateColumn> templateColumns = templateColumnMapper.selectByExample(condition);

        List<ConfigColumn> columns = new ArrayList<ConfigColumn>();
        // 处理查询结果
        for (TemplateColumn templateColumn : templateColumns) {
            int columnId = templateColumn.getColumnId();
            ConfigColumn configColumn = configColumnMapper.selectByPrimaryKey(columnId);
            columns.add(configColumn);
        }
        template.setColumns(columns);

        return template;
    }
}

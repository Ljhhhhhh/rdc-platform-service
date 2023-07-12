package rdc.platform.java.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.models.auth.In;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import rdc.platform.java.common.api.CommonPage;
import rdc.platform.java.common.api.CommonResult;
import rdc.platform.java.mbg.model.*;
import rdc.platform.java.service.ConfigColumnService;
import rdc.platform.java.service.ConfigDetailService;
import rdc.platform.java.service.ConfigTemplateService;

import javax.annotation.Resource;
import java.util.List;

@Api(tags = "模板管理")
@Controller
@RequestMapping("/template")
public class ConfigTemplateController {
    @Resource
    private ConfigTemplateService templateService;

    @Resource
    private ConfigDetailService detailService;

    private static final Logger LOGGER = LoggerFactory.getLogger(ConfigEnumController.class);

    @ApiOperation("获取所有模板")
    @RequestMapping(value = "listAll", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<ConfigTemplate>> getAllList() {
        return CommonResult.success(templateService.listAllTemplate());
    }

    @ApiOperation("分页查询模板列表")
    @RequestMapping(value = "", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<ConfigTemplate>> getList(
            @RequestParam(value = "pageNum", defaultValue = "1")
            @ApiParam("页码") String pageNum,
            @RequestParam(value = "pageSize", defaultValue = "10")
            @ApiParam("每页条数") String pageSize
    ) {
        List<ConfigTemplate> templateList = templateService.listTemplate(Integer.parseInt(pageNum), Integer.parseInt(pageSize));
        return CommonResult.success(CommonPage.restPage(templateList));
    }

    @ApiOperation("获取指定ID模板详情")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<ConfigTemplate> getTemplateInfo(
            @PathVariable("id") Integer id
    ) {
        return CommonResult.success(templateService.getTemplate(id));
    }

    @ApiOperation("创建模板")
    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult createTemplate(
            @RequestBody ConfigTemplate configTemplate
    ) {
        CommonResult commonResult;
        LOGGER.info("create template.getColumns: {}", configTemplate.getColumns());
        int result = templateService.createTemplate(configTemplate);
        if (result == 1) {
            commonResult = CommonResult.success(configTemplate);
        } else {
            commonResult = CommonResult.failed("操作失败");
            LOGGER.info("create template failed: {}", configTemplate);
        }
        return commonResult;
    }

    @ApiOperation("更新指定ID模板信息")
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public CommonResult updateTemplate(
            @PathVariable("id") Integer id,
            @RequestBody ConfigTemplate configTemplate
    ) {
        List<ProjectDir> dirs = detailService.getDirsByTemplateId(id);
        if (dirs != null && dirs.size() > 0) {
            return CommonResult.failed("当前模板存在引用，无法更新", dirs);
        }
        CommonResult commonResult;
        int count = templateService.updateTemplate(id, configTemplate);
        if (count == 1) {
            commonResult = CommonResult.success(configTemplate);
        } else {
            commonResult = CommonResult.failed("操作失败");
            LOGGER.info("update template failed: {}", configTemplate);
        }
        return commonResult;
    }

    @ApiOperation("强制更新指定ID模板信息")
    @RequestMapping(value = "/force/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public CommonResult forceUpdateTemplate(
            @PathVariable("id") Integer id,
            @RequestBody ConfigTemplate configTemplate
    ) {
        CommonResult commonResult;
        int count = templateService.updateTemplate(id, configTemplate);
        if (count == 1) {
            List<ConfigDetail> details = detailService.getDetailsByTemplateId(id);
            if (details != null && details.size() > 0) {
                for (ConfigDetail detail : details) {
                    detailService.setTemplateUpdated(detail, true);
                }
            }
            commonResult = CommonResult.success(details);
        } else {
            commonResult = CommonResult.failed("操作失败");
            LOGGER.info("update template failed: {}", configTemplate);
        }
        return commonResult;
    }



    @ApiOperation("删除指定ID模板")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public CommonResult deleteEnum(@PathVariable("id") Integer id) {
        List<ProjectDir> dirs = detailService.getDirsByTemplateId(id);
        if (dirs != null) {
            return CommonResult.failed("当前模板存在引用，禁止删除", dirs);
        }
        int count = templateService.deleteTemplate(id);
        if (count == 1) {
            return CommonResult.success(null);
        } else {
            LOGGER.debug("delete template failed :id={}", id);
            return CommonResult.failed("操作失败");
        }
    }

}

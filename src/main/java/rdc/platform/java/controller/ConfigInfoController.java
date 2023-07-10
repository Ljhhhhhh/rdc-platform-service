package rdc.platform.java.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import rdc.platform.java.common.api.CommonResult;
import rdc.platform.java.mbg.model.ConfigDetail;
import rdc.platform.java.mbg.model.ConfigTemplate;
import rdc.platform.java.service.ConfigDetailService;
import rdc.platform.java.service.ConfigTemplateService;

import javax.annotation.Resource;
import java.util.List;

@Api(tags = "配置管理")
@Controller
@RequestMapping("/config_info")
public class ConfigInfoController {
    @Resource
    private ConfigDetailService configDetailService;

    @Resource
    private ConfigTemplateService configTemplateService;

    private static final Logger LOGGER = LoggerFactory.getLogger(ConfigEnumController.class);

    @ApiOperation("获取指定文件配置信息")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<ConfigDetail>> getConfigInfo(@PathVariable("id") Integer id) {
        List<ConfigDetail> results = configDetailService.getFileDetail(id);
        // TODO 按照 sort 进行数组排序
        for (ConfigDetail info : results) {
            Integer templateId = info.getTemplateId();
            ConfigTemplate template = configTemplateService.getTemplate(templateId);
            info.setTemplateInfo(template);
        }
        return CommonResult.success(results);
    }

    @ApiOperation("对文件进行配置")
    @RequestMapping(value = "/set", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult setConfigInfo(@RequestBody List<ConfigDetail> configDetailList) {
        // TODO 按照数组顺序设置 sort
        int successNum = 0;
        for (ConfigDetail detail : configDetailList) {
            Integer detailId = detail.getId();
            if (detailId == null) {
                int insert = configDetailService.createDetail(detail);
                successNum += insert;
            } else {
                int update = configDetailService.updateDetail(detailId, detail);
                successNum += update;
            }
        }
        return CommonResult.success(successNum == configDetailList.size());
    }

    // TODO 删除指定区域配置
    @ApiOperation("删除指定区域配置")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public CommonResult<Boolean> deleteConfigInfo(@PathVariable("id") Integer id) {
        int result = configDetailService.deleteDetail(id);
        return CommonResult.success(result == 1);
    }

    // TODO 删除整个文件配置
    @ApiOperation("删除整个文件配置")
    @RequestMapping(value = "/fileDelete/{dirId}", method = RequestMethod.DELETE)
    @ResponseBody
    public CommonResult<Integer> fileDelete(@PathVariable("dirId") Integer dirId) {
        int result = configDetailService.deleteByDirId(dirId);
        return CommonResult.success(result);
    }
}

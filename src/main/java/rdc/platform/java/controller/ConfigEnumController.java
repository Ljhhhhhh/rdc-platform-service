package rdc.platform.java.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import rdc.platform.java.common.api.CommonPage;
import rdc.platform.java.common.api.CommonResult;
import rdc.platform.java.mbg.model.*;
import rdc.platform.java.service.ConfigEnumService;
import rdc.platform.java.service.ConfigTemplateService;

import javax.annotation.Resource;
import java.util.List;

@Api(tags = "枚举管理")
@Controller
@RequestMapping("/enum")
public class ConfigEnumController {
    @Resource
    private ConfigEnumService enumService;

    @Resource
    private ConfigTemplateService templateService;

    private static final Logger LOGGER = LoggerFactory.getLogger(ConfigEnumController.class);

    @ApiOperation("获取所有枚举列表")
    @RequestMapping(value = "listAll", method = RequestMethod.GET)
    @ResponseBody
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public CommonResult<List<ConfigEnum>> getEnumList() {
        return CommonResult.success(enumService.listAllEnum());
    }

    @ApiOperation("分页查询枚举列表")
    @RequestMapping(value = "", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<ConfigEnum>> listEnum(
            @RequestParam(value = "pageNum", defaultValue = "1")
            @ApiParam("页码") String pageNum,
            @RequestParam(value = "pageSize", defaultValue = "10")
            @ApiParam("每页数量") String pageSize
    ) {
        List<ConfigEnum> enumList = enumService.listEnum(Integer.parseInt(pageNum), Integer.parseInt(pageSize));
        return CommonResult.success(CommonPage.restPage(enumList));
    }

    @ApiOperation("获取指定id的枚举详情")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<ConfigEnum> getEnumInfo(@PathVariable("id") Integer id) {
        return CommonResult.success(enumService.getEnum(id));
    }

    @ApiOperation("创建枚举")
    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult createEnum(@RequestBody ConfigEnum configEnum) {
        CommonResult commonResult;
        int count = enumService.createEnum(configEnum);
        if (count == 1) {
            commonResult = CommonResult.success(configEnum);
            LOGGER.debug("create Enum success:{}", configEnum);
        } else {
            commonResult = CommonResult.failed("操作失败");
            LOGGER.debug("create Enum failed:{}", configEnum);
        }
        return commonResult;
    }

    @ApiOperation("更新指定id枚举信息")
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public CommonResult updateEnum(@PathVariable("id") String id, @RequestBody ConfigEnum configEnum, BindingResult result) {
        CommonResult commonResult;
        int count = enumService.updateEnum(Integer.valueOf(id), configEnum);
        if (count == 1) {
            commonResult = CommonResult.success(configEnum);
            LOGGER.debug("update Enum success:{}", configEnum);
        } else {
            commonResult = CommonResult.failed("操作失败");
            LOGGER.debug("update Enum failed:{}", configEnum);
        }
        return commonResult;
    }

    @ApiOperation("删除指定id枚举")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public CommonResult deleteEnum(@PathVariable("id") Integer id) {
        List<ConfigTemplate> templates = templateService.getTemplateByEnumId(id);
        if (templates != null) {
            return CommonResult.failed("该枚举已被模板使用,无法删除", templates);
        }
        int count = enumService.deleteEnum(id);
        if (count == 1) {
            LOGGER.debug("delete Enum success :id={}", id);
            return CommonResult.success(null);
        } else {
            LOGGER.debug("delete Enum failed :id={}", id);
            return CommonResult.failed("操作失败");
        }
    }
}

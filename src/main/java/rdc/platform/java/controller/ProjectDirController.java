package rdc.platform.java.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import rdc.platform.java.common.api.CommonResult;
import rdc.platform.java.mbg.model.ProjectDir;
import rdc.platform.java.service.ProjectDirService;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

@Api(tags = "项目结构")
@Controller
@RequestMapping("/dir")
public class ProjectDirController {
    @Resource
    private ProjectDirService projectDirService;

    @ApiOperation("获取指定ID项目结构")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<ProjectDir>> getProjectDir(@PathVariable UUID id) {
        return CommonResult.success(projectDirService.projectDirTree(id));
    }

    @ApiOperation("新增项目目录")
    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult createProjectDir(@RequestBody ProjectDir projectDir) {
        int result = projectDirService.createDir(projectDir);
        if (result == 1) {
            return CommonResult.success(projectDir);
        } else {
            return CommonResult.failed("新增目录失败");
        }
    }

    @ApiOperation("更新项目目录")
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public CommonResult updateProjectDir(
            @PathVariable("id") Integer id,
            @RequestBody ProjectDir projectDir) {
        int result = projectDirService.updateDir(id, projectDir);
        if (result == 1) {
            return CommonResult.success(projectDir);
        } else {
            return CommonResult.failed("更新目录失败");
        }
    }

    @ApiOperation("删除项目目录")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public CommonResult deleteProjectDir(@PathVariable Integer id) {
        int result = projectDirService.deleteDir(id);
        if (result == 1) {
            return CommonResult.success("删除目录成功");
        } else {
            return CommonResult.failed("删除目录失败");
        }
    }
}

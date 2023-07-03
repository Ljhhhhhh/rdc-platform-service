package rdc.platform.java.service;

import rdc.platform.java.mbg.model.ProjectDir;

import java.util.List;
import java.util.UUID;

public interface ProjectDirService {
    List<ProjectDir> projectDirTree(UUID projectId);

    int createDir(ProjectDir dir);

    int updateDir(Integer id, ProjectDir dir);

    int deleteDir(Integer id);

}

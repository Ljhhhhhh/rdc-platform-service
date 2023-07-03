package rdc.platform.java.common.utils;

import rdc.platform.java.mbg.model.ProjectDir;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

public class ConverterToTree {
    public static List<ProjectDir> convertToHierarchy(List<ProjectDir> projectDirs) {
        Map<Integer, List<ProjectDir>> parentMap = new HashMap<>();
        List<ProjectDir> rootNodes = new ArrayList<>();

        // 构建父节点映射
        for (ProjectDir item : projectDirs) {
            Integer parentId = item.getParentId();
            if (parentId == null) {
                rootNodes.add(item);
            } else {
                parentMap.computeIfAbsent(parentId, k -> new ArrayList<>()).add(item);
            }
        }

        // 递归构建层级结构
        for (ProjectDir item : rootNodes) {
            buildHierarchy(item, parentMap);
        }

        return rootNodes;
    }

    private static void buildHierarchy(ProjectDir node, Map<Integer, List<ProjectDir>> parentMap) {
        Integer nodeId = node.getId();
        List<ProjectDir> children = parentMap.get(nodeId);
        if (children != null) {
            node.setChildren(children);
            for (ProjectDir child : children) {
                buildHierarchy(child, parentMap);
            }
        }
    }
}
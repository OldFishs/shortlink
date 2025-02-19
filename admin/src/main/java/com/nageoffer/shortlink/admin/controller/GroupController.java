package com.nageoffer.shortlink.admin.controller;


import com.nageoffer.shortlink.admin.common.convention.result.Result;
import com.nageoffer.shortlink.admin.common.convention.result.Results;
import com.nageoffer.shortlink.admin.dto.req.ShortLinkGroupSaveReqDTO;
import com.nageoffer.shortlink.admin.dto.req.ShortLinkGroupUpdateReqDTO;
import com.nageoffer.shortlink.admin.dto.resp.ShortLinkGroupRespDTO;
import com.nageoffer.shortlink.admin.service.GroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 短链接分组控制层
 */
@RestController
@RequiredArgsConstructor
public class GroupController {

    private final GroupService groupService;

    /**
     * 新增短链接分组
     */
    @PostMapping("/api/short-link/v1/group")
    public Result<Void> saveGroup(@RequestBody ShortLinkGroupSaveReqDTO requestParam) {
        groupService.saveGroup(requestParam.getName());
        return Results.success();
    }

    /**
     * 查询短链接分组集合
     */
    @GetMapping("/api/short-link/v1/group")
    public Result<List<ShortLinkGroupRespDTO>> getGroups(){

        return Results.success(groupService.listGroup());
    }

    /**
     * 修改短链接分组名称
     */
    @PutMapping("/api/shortj-link/v1/group")
    public Result<Void> updateGroup(@RequestBody ShortLinkGroupUpdateReqDTO requestParam){
        groupService.updateGroup(requestParam);
        return Results.success();

    }
}

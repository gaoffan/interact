package org.sacc.interact.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.sacc.interact.mapper.LessonMapper;
import org.sacc.interact.model.RestResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LessonController {
    @Autowired
    LessonMapper lessonMapper;
    @ApiOperation("查询课程直播地址和回放地址")
    @PostMapping("/getLessonUrl")
    public RestResult geturl(@RequestParam("LessonName")@ApiParam("课程名称") String LessonName){
        String str=lessonMapper.getLessonUrl(LessonName);
        RestResult restResult=new RestResult(200,str);
        return restResult;

    }
    @ApiOperation("修改直播课地址")
    @PostMapping("/updateUrl")
    public  RestResult updateurl(@RequestParam("LessonName")@ApiParam("课程名称")String LessonName,@RequestParam("Url")@ApiParam("新的课程地址")String url){
    lessonMapper.updateUrl(url,LessonName);
    if (lessonMapper.checkUrl(LessonName)==url){
        RestResult restresult=new RestResult(200,"修改成功");
        return restresult;
    }
    else
        return RestResult.error(404,"未找到匹配课程");
    }
    @ApiOperation("设置某课程是否为直播课")
    @PostMapping("/setLessonType")
    public  RestResult setlessontype(@ApiParam("课程名称")@RequestParam("LessonName")String LessonName,
                                     @ApiParam("课程类型1为线下课，2为线上课")@RequestParam("LessonType")int type){
        lessonMapper.updateType(LessonName,type);
        if (lessonMapper.checkType(LessonName)==type){
            RestResult restresult=new RestResult(200,"课程类型设置成功");
            return restresult;
        }
        else
            return RestResult.error(404,"未找到匹配课程");
    }
}

package org.sacc.interact.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.sacc.interact.pojo.RemarkParam;

@Mapper
public interface HomeworkCheckMapper {

    @Update("UPDATE homework_submission SET remark=#{remark} WHERE id=#{submissionId}")
    int remarkHomework(RemarkParam remarkParam);

    @Update("UPDATE homework_submission SET is_show=1 WHERE id=#{submissionId}")
    int setExcellent(int submissionId);
}

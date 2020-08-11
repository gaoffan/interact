package org.sacc.interact.service;

import org.sacc.interact.pojo.RemarkParam;

public interface HomeworkCheckService {

    public int remarkHomework(RemarkParam remarkParam);
    public int setExcellentWork(int submissionId);
}

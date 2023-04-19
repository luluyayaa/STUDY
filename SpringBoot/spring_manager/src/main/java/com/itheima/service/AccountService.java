package com.itheima.service;

import org.springframework.transaction.annotation.Transactional;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface AccountService {
    //rollback:设置当前事务参与回滚的异常，默认非运行时异常不参与回滚
//    @Transactional(rollbackFor = IOException.class)

    /**
     * 事务管理 @Transactional
     * @param out
     * @param in
     * @param money
     * @throws IOException
     */
    @Transactional
    public void transfer(String out,String in ,Double money) throws IOException;
}

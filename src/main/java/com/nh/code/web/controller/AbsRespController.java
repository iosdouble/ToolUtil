package com.nh.code.web.controller;

import com.nh.code.web.resp.generator.IDownloadGenerator;
import com.nh.code.web.resp.generator.IResultRespGenerator;
import com.nh.code.web.resp.generator.ISpringResponseGenerator;
import com.nh.code.web.resp.generator.IWsRsResponseGenerator;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Classname AbsRespController
 * @Description TODO
 * @Date 2019/8/20 11:55 AM
 * @Created by nihui
 */
public class AbsRespController extends AbsBaseController {
    @Autowired(
            required = false
    )
    protected IDownloadGenerator downloadGenerator;
    @Autowired(
            required = false
    )
    protected IResultRespGenerator resultRespGenerator;
    @Autowired(
            required = false
    )
    protected ISpringResponseGenerator springResponseGenerator;
    @Autowired(
            required = false
    )
    protected IWsRsResponseGenerator wsrsResponseGenerator;

    public AbsRespController() {
    }

    public IDownloadGenerator getDownloadGenerator() {
        return this.downloadGenerator;
    }

    public IResultRespGenerator getResultRespGenerator() {
        return this.resultRespGenerator;
    }

    public ISpringResponseGenerator getSpringResponseGenerator() {
        return this.springResponseGenerator;
    }

    public IWsRsResponseGenerator getWsrsResponseGenerator() {
        return this.wsrsResponseGenerator;
    }

    public void setDownloadGenerator(IDownloadGenerator downloadGenerator) {
        this.downloadGenerator = downloadGenerator;
    }

    public void setResultRespGenerator(IResultRespGenerator resultRespGenerator) {
        this.resultRespGenerator = resultRespGenerator;
    }

    public void setSpringResponseGenerator(ISpringResponseGenerator springResponseGenerator) {
        this.springResponseGenerator = springResponseGenerator;
    }

    public void setWsrsResponseGenerator(IWsRsResponseGenerator wsrsResponseGenerator) {
        this.wsrsResponseGenerator = wsrsResponseGenerator;
    }
}

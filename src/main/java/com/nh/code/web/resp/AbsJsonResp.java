package com.nh.code.web.resp;

import com.nh.code.util.json.JsonUtil;

/**
 * @Classname AbsJsonResp
 * @Description TODO
 * @Date 2019/8/20 12:15 PM
 * @Created by nihui
 */
public class AbsJsonResp implements IResp {
    private static final long serialVersionUID = 3451833393183790558L;

    public AbsJsonResp() {
    }

    public String toJson() {
        return JsonUtil.toJsonAndLongToString(this);
    }

    public String toString() {
        return this.toJson();
    }
}

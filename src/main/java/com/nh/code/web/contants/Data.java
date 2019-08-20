package com.nh.code.web.contants;

/**
 * @Classname Data
 * @Description TODO
 * @Date 2019/8/20 11:31 AM
 * @Created by nihui
 */
public class Data {
    public Data() {
    }

    public static final class Env {
        public static final int UNKNOWN = 0;
        public static final int PROD = 1;
        public static final int UAT = 2;
        public static final int ALPHA = 3;

        public Env() {
        }
    }

    public static class Delete {
        public static final int YES = 1;
        public static final int NO = 0;

        public Delete() {
        }
    }

    public static class StatusV2 {
        public static final int ING = 0;
        public static final int YES = 1;
        public static final int NO = 2;

        public StatusV2() {
        }
    }

    public static class Status {
        public static final int ENABLED = 1;
        public static final int DISABLED = 0;

        public Status() {
        }
    }
}

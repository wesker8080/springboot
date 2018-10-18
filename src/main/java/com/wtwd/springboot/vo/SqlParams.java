package com.wtwd.springboot.vo;

/**
 * @author MR.ZHANG
 * @create 2018-08-09 18:32
 */
public class SqlParams {
    private String cmd;
    private String value;

    public String getCmd() {
        return cmd;
    }

    public void setCmd(String cmd) {
        this.cmd = cmd;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "SqlParams{" +
                "cmd='" + cmd + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}

package com.wtwd.springboot.common;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author MR.ZHANG
 * @create 2018-07-24 15:10
 */
public class CommonUtils {
    /**
     * 获取随机日期
     * @param beginDate 起始日期
     * @param endDate 结束日期
     * @return
     */
    public static Date randomDate(String beginDate,String endDate){
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy_");
            Date start = format.parse(beginDate);
            Date end = format.parse(endDate);

            if(start.getTime() >= end.getTime()){
                return null;
            }

            long date = random(start.getTime(),end.getTime());

            return new Date(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private static long random(long begin,long end){
        long rtn = begin + (long)(Math.random() * (end - begin));
        if(rtn == begin || rtn == end){
            return random(begin,end);
        }
        return rtn;
    }
}

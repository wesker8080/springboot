package com.wtwd.springboot.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.wtwd.springboot.common.BaseResult;
import com.wtwd.springboot.dao.MongoRep;
import com.wtwd.springboot.model.Device;
import com.wtwd.springboot.model.DeviceUserLocation;
import com.wtwd.springboot.model.MongoBean;
import com.wtwd.springboot.service.DeviceService;
import com.wtwd.springboot.vo.SqlParams;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author MR.ZHANG
 * @create 2018-07-23 14:23
 */
@Controller
@RequestMapping("/api/v1.1")
public class IndexController {
    private final Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    DeviceService deviceService;



    @RequestMapping("/index")
    public String index() {
      /* for(int i=1; i < 30; i++) {
            Device device = new Device();
            device.setDevId(i);
            Random random = new Random();
            int year = random.nextInt(18) + 2000;
            int month = random.nextInt(11) + 1;
            int day = random.nextInt(27) + 1;
            LocalDate date =LocalDate.of(year,month,day);
            ZoneId zone = ZoneId.systemDefault();
            Instant instant = date.atStartOfDay().atZone(zone).toInstant();
            device.setDevActivetime(Date.from(instant));
            if (i % 2 == 0) {
                device.setDevGroup("市");
                device.setDevType("1");
            } else {
                device.setDevGroup("区");
                device.setDevType("2");
            }
            device.setDevPower(random.nextInt(100)+"");
            device.setDevUserid(10+i);
           Map<String,Double> map = new HashMap<>();
           Double longitude = random.nextDouble()/2 + 113;
           Double latitude = random.nextDouble()/2 + 22;
           map.put("longitude",longitude);
           map.put("latitude",latitude);
           String location = JSON.toJSON(map).toString();
           device.setDevData(location);
            deviceService.addDevice(device);
        }*/
        /*for(int i=1;i<30;i++) {
            Data data = new Data();
            Random random = new Random();
            int year = random.nextInt(18) + 2000;
            int month = random.nextInt(11) + 1;
            int day = random.nextInt(27) + 1;
            LocalDate date =LocalDate.of(year,month,day);
            ZoneId zone = ZoneId.systemDefault();
            Instant instant = date.atStartOfDay().atZone(zone).toInstant();
            data.setDataCreatetime(Date.from(instant));
            Map<String,Double> map = new HashMap<>();
            Double longitude = random.nextDouble()+116;
            Double latitude = random.nextDouble()+39;
            map.put("longitude",longitude);
            map.put("latitude",latitude);
            String location = JSON.toJSON(map).toString();
            data.setDataData(location);
            data.setDataId(i);
            dataService.addData(data);
        }*/
        return "index";
    }
    @GetMapping(value = "/current")
    public String allDevice(Model model, @RequestParam(value = "require",required = false,defaultValue = "all") String require) {

        List<Device> devices = deviceService.getAllDeviceInfo();
        Map<String,Map<String,Double>> dataMap = new HashMap<>();
        Map<String,List<Map<String,Double>>> listMap = new HashMap<>();
        if ("all".equals(require)) {
            Map<Integer, String> collect = devices.stream().collect(Collectors.toMap(Device::getDevUserid, Device::getDevData));
            collect.keySet().forEach(key -> {
                Map<String,Double> location = (Map) JSON.parse(collect.get(key));
                dataMap.put(String.valueOf(key),location);
            });
            dataMap.keySet().forEach(key1 -> System.out.println(key1 + " : " + dataMap.get(key1)));
            String json = JSON.toJSON(dataMap).toString();
            model.addAttribute("map", json);
        } else if ("type".equals(require) || "group".equals(require)) {
            Map<String, List<Device>> collect;
            if ("type".equals(require)) {
                collect = devices.stream().collect(Collectors.groupingBy(Device::getDevType));
            } else {
                collect = devices.stream().collect(Collectors.groupingBy(Device::getDevGroup));
            }
            collect.keySet().forEach(key -> {
                List<String> collect1 = collect.get(key).stream().map(Device::getDevData).collect(Collectors.toList());
                List<Map<String,Double>> locations = new ArrayList<>();
                collect1.forEach(x -> {
                    Map<String,Double> location = (Map) JSON.parse(x);
                    locations.add(location);
                });
                listMap.put(key,locations);
            });
            String json = JSON.toJSON(listMap).toString();
            model.addAttribute("listmap", json);
        } else if ("power".equals(require)) {
            Map<Integer, String> collect = devices.stream().filter(x -> Integer.valueOf(x.getDevPower()) < 30).collect(Collectors.toMap(Device::getDevUserid, Device::getDevData));
            collect.keySet().forEach(key -> {
                Map<String,Double> location = (Map) JSON.parse(collect.get(key));
                dataMap.put(String.valueOf(key),location);
            });
            //dataMap.keySet().forEach(key1 -> System.out.println(key1 + " : " + dataMap.get(key1)));
            String json = JSON.toJSON(dataMap).toString();
            model.addAttribute("map", json);
        }
        return "all";
    }
    @RequestMapping("/error")
    @ResponseBody
    public String testError() {
        int i = 1/0;
        return "i";
    }

    @GetMapping(value = "/query")
    @ResponseBody
    public BaseResult queryByParam(@RequestParam(value = "param") String param,@RequestParam(value = "value") String value) {
        Map<Integer,Map<String,Double>> dataMap = new HashMap<>();
        List<String> list = Stream.of(value.split("_")).collect(Collectors.toList());
        List<DeviceUserLocation> devices = deviceService.getLocationDataByParam(param,list);
        Map<Integer, String> collect = devices.stream().collect(Collectors.toMap(DeviceUserLocation::getDevUserid, DeviceUserLocation::getDevData));
        collect.keySet().forEach(key -> {
            Map<String,Double> location = (Map)JSON.parse(collect.get(key));
            dataMap.put(key,location);
        });
        String json = JSON.toJSON(dataMap).toString();
        return BaseResult.build(200,json);
    }




    @RequestMapping("/json")
    @ResponseBody
    public Device getDeviceJson() {
        System.out.println("json");
        Device device = new Device();
        device.setDevId(1);
        device.setDevPower("23");
        device.setDevUserid(45);
        device.setDevGroup("wesker");
        device.setDevActivetime(new Date());
        device.setDevType("type");
        return device;
    }


    @GetMapping("/mobile/{type}/{id}")
    @ResponseBody
    public BaseResult getUserLocationFromType(@PathVariable(value = "type") String type, @PathVariable(value = "id") int id) {
        List<DeviceUserLocation> data = deviceService.getLocationDataByParam(type, id + "");
        Map<Integer, String> collect = data.stream().collect(Collectors.toMap(DeviceUserLocation::getDevUserid, DeviceUserLocation::getDevData));
        String userLocation = JSON.toJSON(data).toString();
        return BaseResult.build(200, userLocation);
    }

    @PostMapping("/dev")
    @ResponseBody
    public Object getUserLocationFromTypePost(@RequestBody SqlParams params) {
        logger.error("cmd : " + params.getCmd()  + " value : " + params.getValue());
        List<Map<String, Object>> list = new ArrayList<>();
        Map<String, Object> resultMap = new HashMap<>();
        List<DeviceUserLocation.DevLocation> locations = new ArrayList<>();
        List<DeviceUserLocation> data = deviceService.getLocationDataByParam(params.getCmd(), params.getValue());
        Optional<List<DeviceUserLocation>> optional = Optional.ofNullable(data);
        resultMap.put("resultCode",2);
        resultMap.put("data",null);
        optional.ifPresent(d -> {
            d.forEach(y -> {
                Map<String,Object> map = new HashMap<>();
                map.put("devUserid",y.getDevUserid());
                Map<String, Double> locMap = (Map)JSONObject.parse(y.getDevData());
                map.put("longitude", locMap.get("longitude"));
                map.put("latitude", locMap.get("latitude"));
                list.add(map);
            });
            resultMap.put("data",list);
            resultMap.put("resultCode",1);
        });

        //list.forEach(System.out::println);
        /*data.stream().map(DeviceUserLocation::getDevData).forEach(x -> {
            Optional<String> x1 = Optional.ofNullable(x);
            x1.ifPresent(x2 -> {
                Map<String, Double> map = (Map)JSONObject.parse(x);
                map.keySet().forEach(k -> {
                    DeviceUserLocation.DevLocation devLocation = new DeviceUserLocation.DevLocation();
                    if (k.equals("longitude")) {
                        devLocation.setLongitude(map.get(k));
                    } else {
                        devLocation.setLatitude(map.get(k));
                    }
                });
            });

        });*/
        //Map<Integer, String> collect = data.stream().collect(Collectors.toMap(DeviceUserLocation::getDevUserid, DeviceUserLocation::getDevData));
        //data.forEach(System.out::println);
        return resultMap;
    }


    @Autowired
    MongoRep mongoRep;
    @GetMapping("/mongo/list")
    @ResponseBody
    public List<MongoBean> getDataFromMongo(HttpServletResponse response) {
        response.setCharacterEncoding("utf-8");
        response.setContentType("application/json;charset=utf-8");
        List<MongoBean> list = mongoRep.findAll();
        list.forEach(System.out::println);
        return list;
    }
    @GetMapping("/mongo/get/age/{age}")
    @ResponseBody
    public MongoBean getDataFromMongoByName(HttpServletResponse response,
                                                  @PathVariable(value = "age") int age) {
        response.setCharacterEncoding("utf-8");
        response.setContentType("application/json;charset=utf-8");
        MongoBean mongoBean = mongoRep.findByAge(age);
        return mongoBean;
    }
    @GetMapping("/mongo/get/name/{name}")
    @ResponseBody
    public MongoBean getDataFromMongoByName(HttpServletResponse response,
                                            @PathVariable(value = "name") String name) {
        MongoBean mongoBean = mongoRep.findByName(name);
        return mongoBean;
    }
}

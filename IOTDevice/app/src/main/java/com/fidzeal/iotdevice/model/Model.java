package com.fidzeal.iotdevice.model;

/**
 * Created by Manoj on 11/04/2017.
 */
public class Model {

    private static Model sSingleton;

    public static Model getSingleton() {
        if (sSingleton == null) {
            sSingleton = new Model();
        }
        return sSingleton;
    }

    public String REFRESH_URL = ":8080/pi/Ardunio/oneTimeSW_req";
    public String STATUS_URL = ":8080/pi/Ardunio/control";

    public final int CONNECTION_TIMEOUT = 120;

    public String status = "status";
    public String IP_ADDRESS = "IP_ADDRESS";
    public String ip = "ip_address";

}

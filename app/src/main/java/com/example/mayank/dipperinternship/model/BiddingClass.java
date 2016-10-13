package com.example.mayank.dipperinternship.model;

/**
 * Created by mayank on 12-10-2016.
 */
public class BiddingClass {

    /**
     * id : 936
     * request_id : 935
     * route_start : Haldia
     * route_end : Delhi
     * tonnage : 20.0
     * trucks_no_available : 1
     * is_active : true
     * quoted_price : 2600.0
     * last_quoted_price : null
     * truck_type : Truck
     * has_GPS : null
     * trucker_id : 44
     * request_state : pending_confirmation
     * read : false
     * pickup_date : 2016-10-07
     * pickup_time : null
     * created_at : 2016-10-07T11:57:12.000Z
     * updated_at : 2016-10-07T11:58:33.000Z
     * check_near_location : true
     * check_near_location_route_end : true
     * near_location_start_distance : null
     * near_location_end_distance : null
     * subtype : null
     * length : 27.0
     * is_per_truck : false
     * is_mg : true
     */

    private int id;
    private int request_id;
    private String route_start;
    private String route_end;
    private String tonnage;
    private int trucks_no_available;
    private boolean is_active;
    private String quoted_price;
    private Object last_quoted_price;
    private String truck_type;
    private Object has_GPS;
    private int trucker_id;
    private String request_state;
    private boolean read;
    private String pickup_date;
    private Object pickup_time;
    private String created_at;
    private String updated_at;
    private boolean check_near_location;
    private boolean check_near_location_route_end;
    private Object near_location_start_distance;
    private Object near_location_end_distance;
    private Object subtype;
    private String length;
    private boolean is_per_truck;
    private boolean is_mg;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRequest_id() {
        return request_id;
    }

    public void setRequest_id(int request_id) {
        this.request_id = request_id;
    }

    public String getRoute_start() {
        return route_start;
    }

    public void setRoute_start(String route_start) {
        this.route_start = route_start;
    }

    public String getRoute_end() {
        return route_end;
    }

    public void setRoute_end(String route_end) {
        this.route_end = route_end;
    }

    public String getTonnage() {
        return tonnage;
    }

    public void setTonnage(String tonnage) {
        this.tonnage = tonnage;
    }

    public int getTrucks_no_available() {
        return trucks_no_available;
    }

    public void setTrucks_no_available(int trucks_no_available) {
        this.trucks_no_available = trucks_no_available;
    }

    public boolean isIs_active() {
        return is_active;
    }

    public void setIs_active(boolean is_active) {
        this.is_active = is_active;
    }

    public String getQuoted_price() {
        return quoted_price;
    }

    public void setQuoted_price(String quoted_price) {
        this.quoted_price = quoted_price;
    }

    public Object getLast_quoted_price() {
        return last_quoted_price;
    }

    public void setLast_quoted_price(Object last_quoted_price) {
        this.last_quoted_price = last_quoted_price;
    }

    public String getTruck_type() {
        return truck_type;
    }

    public void setTruck_type(String truck_type) {
        this.truck_type = truck_type;
    }

    public Object getHas_GPS() {
        return has_GPS;
    }

    public void setHas_GPS(Object has_GPS) {
        this.has_GPS = has_GPS;
    }

    public int getTrucker_id() {
        return trucker_id;
    }

    public void setTrucker_id(int trucker_id) {
        this.trucker_id = trucker_id;
    }

    public String getRequest_state() {
        return request_state;
    }

    public void setRequest_state(String request_state) {
        this.request_state = request_state;
    }

    public boolean isRead() {
        return read;
    }

    public void setRead(boolean read) {
        this.read = read;
    }

    public String getPickup_date() {
        return pickup_date;
    }

    public void setPickup_date(String pickup_date) {
        this.pickup_date = pickup_date;
    }

    public Object getPickup_time() {
        return pickup_time;
    }

    public void setPickup_time(Object pickup_time) {
        this.pickup_time = pickup_time;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public boolean isCheck_near_location() {
        return check_near_location;
    }

    public void setCheck_near_location(boolean check_near_location) {
        this.check_near_location = check_near_location;
    }

    public boolean isCheck_near_location_route_end() {
        return check_near_location_route_end;
    }

    public void setCheck_near_location_route_end(boolean check_near_location_route_end) {
        this.check_near_location_route_end = check_near_location_route_end;
    }

    public Object getNear_location_start_distance() {
        return near_location_start_distance;
    }

    public void setNear_location_start_distance(Object near_location_start_distance) {
        this.near_location_start_distance = near_location_start_distance;
    }

    public Object getNear_location_end_distance() {
        return near_location_end_distance;
    }

    public void setNear_location_end_distance(Object near_location_end_distance) {
        this.near_location_end_distance = near_location_end_distance;
    }

    public Object getSubtype() {
        return subtype;
    }

    public void setSubtype(Object subtype) {
        this.subtype = subtype;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public boolean isIs_per_truck() {
        return is_per_truck;
    }

    public void setIs_per_truck(boolean is_per_truck) {
        this.is_per_truck = is_per_truck;
    }

    public boolean isIs_mg() {
        return is_mg;
    }

    public void setIs_mg(boolean is_mg) {
        this.is_mg = is_mg;
    }
}

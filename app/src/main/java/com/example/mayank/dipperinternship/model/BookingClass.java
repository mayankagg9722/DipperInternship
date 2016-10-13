package com.example.mayank.dipperinternship.model;

/**
 * Created by mayank on 12-10-2016.
 */
public class BookingClass {

    /**
     * id : 644
     * shipper_id : 1
     * trucker_id : 44
     * route_start : Jamshedpur
     * route_end : Delhi
     * booking_price : 2400.0
     * booked_quantity : 1
     * status : confirmed
     * is_completed : null
     * pending_trucker_confirmation : false
     * pending_shipper_confirmation : false
     * load_id : 847
     * payment_state : null
     * total_amount : 48000.0
     * truck_type : Truck
     * material_type : null
     * tracking_link : null
     * trucker_request_id : 935
     * read : false
     * is_active : null
     * consigner_id : 59
     * pickup_address : Jamshedpur
     * drop_address : Delhi
     * consignee_name : null
     * consignee_id : null
     * loading_supervisor_id : 28
     * created_at : 2016-10-07T11:44:12.000Z
     * updated_at : 2016-10-07T11:54:13.000Z
     * UTR_code : null
     * petrocard_percentage : null
     * challan_no : null
     * slug : wh0000
     */

    private int id;
    private int shipper_id;
    private int trucker_id;
    private String route_start;
    private String route_end;
    private String booking_price;
    private int booked_quantity;
    private String status;
    private Object is_completed;
    private boolean pending_trucker_confirmation;
    private boolean pending_shipper_confirmation;
    private int load_id;
    private Object payment_state;
    private String total_amount;
    private String truck_type;
    private Object material_type;
    private Object tracking_link;
    private int trucker_request_id;
    private boolean read;
    private Object is_active;
    private int consigner_id;
    private String pickup_address;
    private String drop_address;
    private Object consignee_name;
    private Object consignee_id;
    private int loading_supervisor_id;
    private String created_at;
    private String updated_at;
    private Object UTR_code;
    private Object petrocard_percentage;
    private Object challan_no;
    private String slug;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getShipper_id() {
        return shipper_id;
    }

    public void setShipper_id(int shipper_id) {
        this.shipper_id = shipper_id;
    }

    public int getTrucker_id() {
        return trucker_id;
    }

    public void setTrucker_id(int trucker_id) {
        this.trucker_id = trucker_id;
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

    public String getBooking_price() {
        return booking_price;
    }

    public void setBooking_price(String booking_price) {
        this.booking_price = booking_price;
    }

    public int getBooked_quantity() {
        return booked_quantity;
    }

    public void setBooked_quantity(int booked_quantity) {
        this.booked_quantity = booked_quantity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Object getIs_completed() {
        return is_completed;
    }

    public void setIs_completed(Object is_completed) {
        this.is_completed = is_completed;
    }

    public boolean isPending_trucker_confirmation() {
        return pending_trucker_confirmation;
    }

    public void setPending_trucker_confirmation(boolean pending_trucker_confirmation) {
        this.pending_trucker_confirmation = pending_trucker_confirmation;
    }

    public boolean isPending_shipper_confirmation() {
        return pending_shipper_confirmation;
    }


    public void setPending_shipper_confirmation(boolean pending_shipper_confirmation) {
        this.pending_shipper_confirmation = pending_shipper_confirmation;
    }

    public int getLoad_id() {
        return load_id;
    }

    public void setLoad_id(int load_id) {
        this.load_id = load_id;
    }

    public Object getPayment_state() {
        return payment_state;
    }

    public void setPayment_state(Object payment_state) {
        this.payment_state = payment_state;
    }

    public String getTotal_amount() {
        return total_amount;
    }

    public void setTotal_amount(String total_amount) {
        this.total_amount = total_amount;
    }

    public String getTruck_type() {
        return truck_type;
    }

    public void setTruck_type(String truck_type) {
        this.truck_type = truck_type;
    }

    public Object getMaterial_type() {
        return material_type;
    }

    public void setMaterial_type(Object material_type) {
        this.material_type = material_type;
    }

    public Object getTracking_link() {
        return tracking_link;
    }

    public void setTracking_link(Object tracking_link) {
        this.tracking_link = tracking_link;
    }

    public int getTrucker_request_id() {
        return trucker_request_id;
    }

    public void setTrucker_request_id(int trucker_request_id) {
        this.trucker_request_id = trucker_request_id;
    }

    public boolean isRead() {
        return read;
    }

    public void setRead(boolean read) {
        this.read = read;
    }

    public Object getIs_active() {
        return is_active;
    }

    public void setIs_active(Object is_active) {
        this.is_active = is_active;
    }

    public int getConsigner_id() {
        return consigner_id;
    }

    public void setConsigner_id(int consigner_id) {
        this.consigner_id = consigner_id;
    }

    public String getPickup_address() {
        return pickup_address;
    }

    public void setPickup_address(String pickup_address) {
        this.pickup_address = pickup_address;
    }

    public String getDrop_address() {
        return drop_address;
    }

    public void setDrop_address(String drop_address) {
        this.drop_address = drop_address;
    }

    public Object getConsignee_name() {
        return consignee_name;
    }

    public void setConsignee_name(Object consignee_name) {
        this.consignee_name = consignee_name;
    }

    public Object getConsignee_id() {
        return consignee_id;
    }

    public void setConsignee_id(Object consignee_id) {
        this.consignee_id = consignee_id;
    }

    public int getLoading_supervisor_id() {
        return loading_supervisor_id;
    }

    public void setLoading_supervisor_id(int loading_supervisor_id) {
        this.loading_supervisor_id = loading_supervisor_id;
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

    public Object getUTR_code() {
        return UTR_code;
    }

    public void setUTR_code(Object UTR_code) {
        this.UTR_code = UTR_code;
    }

    public Object getPetrocard_percentage() {
        return petrocard_percentage;
    }

    public void setPetrocard_percentage(Object petrocard_percentage) {
        this.petrocard_percentage = petrocard_percentage;
    }

    public Object getChallan_no() {
        return challan_no;
    }

    public void setChallan_no(Object challan_no) {
        this.challan_no = challan_no;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }
}

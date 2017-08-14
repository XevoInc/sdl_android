package com.smartdevicelink.proxy.rpc;

import com.smartdevicelink.proxy.RPCStruct;
import com.smartdevicelink.util.SdlDataTypeConverter;

import java.util.Hashtable;

public class SpatialParams extends RPCStruct {
    public static final String KEY_ID = "id";
    public static final String KEY_X = "x";
    public static final String KEY_Y = "y";
    public static final String KEY_WIDTH = "width";
    public static final String KEY_HEIGHT = "height";

    public SpatialParams() {
    }

    public SpatialParams(Hashtable<String, Object> hash) {
        super(hash);
    }

    public Integer getId() {
        return (Integer) store.get(KEY_ID);
    }

    public void setId(Integer id) {
        if (id != null) {
            store.put(KEY_ID, id);
        } else {
            store.remove(KEY_ID);
        }
    }

    public Double getX() {
        return SdlDataTypeConverter.objectToDouble(store.get(KEY_X));
    }

    public void setX(Double x) {
        if (x != null) {
            store.put(KEY_X, x);
        } else {
            store.remove(KEY_X);
        }
    }

    public void setY(Double y) {
        if (y != null) {
            store.put(KEY_Y, y);
        } else {
            store.remove(KEY_Y);
        }
    }

    public Double getY() {
        return SdlDataTypeConverter.objectToDouble(store.get(KEY_Y));
    }

    public Double getWidth() {
        return SdlDataTypeConverter.objectToDouble(store.get(KEY_WIDTH));
    }

    public void setWidth(Double width) {
        if (width != null) {
            store.put(KEY_WIDTH, width);
        } else {
            store.remove(KEY_WIDTH);
        }
    }

    public Double getHeight() {
        return SdlDataTypeConverter.objectToDouble(store.get(KEY_HEIGHT));
    }

    public void setHeight(Double height) {
        if (height != null) {
            store.put(KEY_HEIGHT, height);
        } else {
            store.remove(KEY_HEIGHT);
        }
    }


}

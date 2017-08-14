package com.smartdevicelink.proxy.rpc;

import com.smartdevicelink.protocol.enums.FunctionID;
import com.smartdevicelink.proxy.RPCRequest;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class SendHapticData extends RPCRequest {
    public static final String KEY_SPATIAL_PARAMS = "hapticSpatialData";

    public SendHapticData() {
        super(FunctionID.SEND_HAPTIC_DATA.toString());
    }

    public SendHapticData(Hashtable<String, Object> hash) {
        super(hash);
    }

    @SuppressWarnings("unchecked")
    public List<SpatialParams> getSpatialParams() {
        if (parameters.get(KEY_SPATIAL_PARAMS) instanceof List<?>) {
            List<?> list = (List<?>) parameters.get(KEY_SPATIAL_PARAMS);
            if (list != null && list.size() > 0) {
                Object obj = list.get(0);
                if (obj instanceof SpatialParams) {
                    return (List<SpatialParams>) list;
                } else if (obj instanceof Hashtable) {
                    List<SpatialParams> newList = new ArrayList<>();
                    for (Object hashObj : list) {
                        newList.add(new SpatialParams((Hashtable<String, Object>) hashObj));
                    }
                    return newList;
                }
            }
        }
        return null;
    }

    public void setSpatialParams(List<SpatialParams> spatialParams) {
        if (spatialParams != null) {
            parameters.put(KEY_SPATIAL_PARAMS, spatialParams);
        } else {
            parameters.remove(KEY_SPATIAL_PARAMS);
        }
    }
}

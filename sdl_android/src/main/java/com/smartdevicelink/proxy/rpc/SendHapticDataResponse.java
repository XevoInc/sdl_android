package com.smartdevicelink.proxy.rpc;

import com.smartdevicelink.protocol.enums.FunctionID;
import com.smartdevicelink.proxy.RPCResponse;

import java.util.Hashtable;

/**
 * Add SendHapticData Response is sent, when SendHapticData has been called
 */
public class SendHapticDataResponse extends RPCResponse {

    public SendHapticDataResponse() {
        super(FunctionID.SEND_HAPTIC_DATA.toString());
    }

    public SendHapticDataResponse(Hashtable<String, Object> hash) {
        super(hash);
    }
}

package com.smartdevicelink.test.rpc.requests;

import com.smartdevicelink.marshal.JsonRPCMarshaller;
import com.smartdevicelink.protocol.enums.FunctionID;
import com.smartdevicelink.proxy.RPCMessage;
import com.smartdevicelink.proxy.rpc.SendHapticData;
import com.smartdevicelink.proxy.rpc.SpatialParams;
import com.smartdevicelink.test.BaseRpcTests;
import com.smartdevicelink.test.JsonUtils;
import com.smartdevicelink.test.Test;
import com.smartdevicelink.test.Validator;
import com.smartdevicelink.test.json.rpc.JsonFileReader;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class SendHapticDataTests extends BaseRpcTests {

    @Override
    protected RPCMessage createMessage() {
        SendHapticData msg = new SendHapticData();
        msg.setSpatialParams(Test.GENERAL_SPATIALPARAMS_LIST);
        return msg;
    }

    @Override
    protected String getMessageType() {
        return RPCMessage.KEY_REQUEST;
    }

    @Override
    protected String getCommandType() {
        return FunctionID.SEND_HAPTIC_DATA.toString();
    }

    @Override
    protected JSONObject getExpectedParameters(int sdlVersion) {
        JSONObject result = new JSONObject();
        try {
            result.put(SendHapticData.KEY_SPATIAL_PARAMS, Test.JSON_SPATIALPARAMS);
        } catch (JSONException e) {
            fail(Test.JSON_FAIL);
        }
        return result;
    }

    /**
     * Tests the expected values of the RPC message.
     */
    public void testRpcValues() {
        // Test Values
        List<SpatialParams> copy = ((SendHapticData) msg).getSpatialParams();

        // Valid Tests
        assertTrue(Test.TRUE,
                Validator.validateSpatialParams(Test.GENERAL_SPATIALPARAMS_LIST, copy));

        // Invalid/Null Tests
        SendHapticData msg = new SendHapticData();
        assertNotNull(Test.NOT_NULL, msg);
        testNullBase(msg);

        assertNull(Test.NULL, msg.getSpatialParams());
    }

    /**
     * Tests a valid JSON construction of this RPC message.
     */
    public void testJsonConstructor() {
        JSONObject commandJson =
                JsonFileReader.readId(mContext, getCommandType(), getMessageType());
        assertNotNull(Test.NOT_NULL, commandJson);

        try {
            Hashtable<String, Object> hash = JsonRPCMarshaller.deserializeJSONObject(commandJson);
            SendHapticData cmd = new SendHapticData(hash);

            JSONObject body = JsonUtils.readJsonObjectFromJsonObject(commandJson, getMessageType());
            assertNotNull(Test.NOT_NULL, body);

            // Test everything in the json body.
            assertEquals(Test.MATCH,
                    JsonUtils.readStringFromJsonObject(body, RPCMessage.KEY_FUNCTION_NAME),
                    cmd.getFunctionName());
            assertEquals(Test.MATCH,
                    JsonUtils.readIntegerFromJsonObject(body, RPCMessage.KEY_CORRELATION_ID),
                    cmd.getCorrelationID());

            JSONObject parameters =
                    JsonUtils.readJsonObjectFromJsonObject(body, RPCMessage.KEY_PARAMETERS);

            JSONArray spatialParamsArray = JsonUtils
                    .readJsonArrayFromJsonObject(parameters, SendHapticData.KEY_SPATIAL_PARAMS);
            List<SpatialParams> spatialParamsList = new ArrayList<>();
            for (int index = 0; index < spatialParamsArray.length(); index++) {
                SpatialParams spatialParams = new SpatialParams(JsonRPCMarshaller
                        .deserializeJSONObject((JSONObject) spatialParamsArray.get(index)));
                spatialParamsList.add(spatialParams);
            }
            assertTrue(Test.TRUE,
                    Validator.validateSpatialParams(spatialParamsList, cmd.getSpatialParams()));
        } catch (JSONException e) {
            fail(Test.JSON_FAIL);
        }
    }
}

package com.smartdevicelink.test.rpc.datatypes;

import com.smartdevicelink.proxy.rpc.SpatialParams;
import com.smartdevicelink.test.JsonUtils;
import com.smartdevicelink.test.Test;

import junit.framework.TestCase;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Iterator;

/**
 * This is a unit test class for the SmartDeviceLink library project class :
 * {@link SpatialParams}
 */
public class SpatialParamsTest extends TestCase {

    private SpatialParams msg;

    @Override
    protected void setUp() throws Exception {
        msg = new SpatialParams();
        msg.setId(Test.GENERAL_INT);
        msg.setX(Test.GENERAL_DOUBLE);
        msg.setY(Test.GENERAL_DOUBLE);
        msg.setWidth(Test.GENERAL_DOUBLE);
        msg.setHeight(Test.GENERAL_DOUBLE);
    }

    /**
     * Tests the expected values of the RPC message.
     */
    public void testRpcValues() {
        // Test values
        assertEquals(Test.MATCH, Test.GENERAL_INT, (int) msg.getId());
        assertEquals(Test.MATCH, Test.GENERAL_DOUBLE, msg.getX());
        assertEquals(Test.MATCH, Test.GENERAL_DOUBLE, msg.getY());
        assertEquals(Test.MATCH, Test.GENERAL_DOUBLE, msg.getWidth());
        assertEquals(Test.MATCH, Test.GENERAL_DOUBLE, msg.getHeight());

        SpatialParams msg = new SpatialParams();
        assertNotNull(Test.NOT_NULL, msg);

        assertNull(Test.NULL, msg.getId());
        assertNull(Test.NULL, msg.getX());
        assertNull(Test.NULL, msg.getY());
        assertNull(Test.NULL, msg.getWidth());
        assertNull(Test.NULL, msg.getHeight());
    }

    public void testJson() {
        JSONObject reference = new JSONObject();

        try {
            reference.put(SpatialParams.KEY_ID, (Integer) Test.GENERAL_INT);
            reference.put(SpatialParams.KEY_X, Test.GENERAL_DOUBLE);
            reference.put(SpatialParams.KEY_Y, Test.GENERAL_DOUBLE);
            reference.put(SpatialParams.KEY_WIDTH, Test.GENERAL_DOUBLE);
            reference.put(SpatialParams.KEY_HEIGHT, Test.GENERAL_DOUBLE);

            JSONObject underTest = msg.serializeJSON();
            assertEquals(Test.MATCH, reference.length(), underTest.length());

            final Iterator<?> iterator = reference.keys();
            while (iterator.hasNext()) {
                String key = (String) iterator.next();
                Object a = JsonUtils.readObjectFromJsonObject(reference, key);
                Object b = JsonUtils.readObjectFromJsonObject(underTest, key);

                assertEquals(Test.MATCH, a, b);
            }
        } catch (JSONException e) {
            fail(Test.JSON_FAIL);
        }
    }
}
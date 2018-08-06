package com.smartdevicelink.test.security;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import android.test.AndroidTestCase;

import com.smartdevicelink.SdlConnection.ISdlConnectionListener;
import com.smartdevicelink.SdlConnection.SdlSession;
import com.smartdevicelink.protocol.ProtocolMessage;
import com.smartdevicelink.protocol.enums.SessionType;
import com.smartdevicelink.security.SdlSecurityBase;
import com.smartdevicelink.test.Test;
import com.smartdevicelink.transport.BTTransportConfig;
import com.smartdevicelink.transport.BaseTransportConfig;
import com.smartdevicelink.transport.enums.TransportType;

public class SdlSecurityBaseTest extends AndroidTestCase {
		
	@Override
	protected void setUp() throws Exception {
		super.setUp();
	
	}
	
	private class MockSdlSecurityBase extends SdlSecurityBase {

		@Override
		public void initialize() {
			
		}

		@Override
		public Integer runHandshake(byte[] inputData, byte[] outputData) {
			return null;
		}

		@Override
		public Integer encryptData(byte[] inputData, byte[] outputData) {
			return null;
		}

		@Override
		public Integer decryptData(byte[] inputData, byte[] outputData) {
			return null;
		}

		@Override
		public void shutDown() {
			
		}
		
	    public SdlSession getSdlSession() {
	    	return session;
	    }
	    
	    public void setStartServiceList(List<SessionType> list) {
	    	startServiceList = list;
	    }
	}
	
	class MockInterfaceBroker implements ISdlConnectionListener {
		public MockInterfaceBroker () { }
		@Override
		public void onTransportDisconnected(String info) {
			
		}

		@Override
		public void onTransportDisconnected(String info, TransportType transportType) {

		}

		@Override
		public void onTransportError(String info, Exception e) {
			
		}

		@Override
		public void onTransportError(String info, TransportType transportType, Exception e) {

		}

		@Override
		public void onProtocolMessageReceived(ProtocolMessage msg) {
			
		}
		@Override
		public void onProtocolSessionStartedNACKed(SessionType sessionType,
				byte sessionID, byte version, String correlationID, List<String> rejectedParams) {
			
		}
		@Override
		public void onProtocolSessionStarted(SessionType sessionType,
				byte sessionID, byte version, String correlationID, int hashID,
				boolean isEncrypted) {
			
		}

		@Override
		public void onProtocolSessionStarted(SessionType sessionType, byte sessionID, byte version,
				String correlationID, int hashID, boolean isEncrypted, TransportType transportType) {

		}

		@Override
		public void onProtocolSessionEnded(SessionType sessionType, byte sessionID,
				String correlationID) {
			
		}

		@Override
		public void onProtocolSessionEnded(SessionType sessionType, byte sessionID,
				String correlationID, TransportType transportType) {

		}

		@Override
		public void onProtocolSessionEndedNACKed(SessionType sessionType,
				byte sessionID, String correlationID) {
			
		}
		@Override
		public void onProtocolError(String info, Exception e) {
			
		}
		@Override
		public void onHeartbeatTimedOut(byte sessionID) {
			
		}
		@Override
		public void onProtocolServiceDataACK(SessionType sessionType, int dataSize,
				byte sessionID) {
			
		}

		@Override
		public void onEnableSecondaryTransport(byte sessionID, ArrayList<String> secondaryTransports,
				ArrayList<Integer> audioTransports, ArrayList<Integer> videoTransports,
				TransportType type) {

		}

		@Override
		public void onTransportEventUpdate(byte sessionID, Map<String, Object> params) {

		}

		@Override
		public void onRegisterSecondaryTransportACK(byte sessionID) {

		}

		@Override
		public void onRegisterSecondaryTransportNACKed(byte sessionID, String reason) {

		}

	}
	
	public void testMakeListSetAndGet(){
		List<String> makeList = new ArrayList<String>();
		MockSdlSecurityBase mockSdlSecurityBase = new MockSdlSecurityBase();
		
		String MAKE_1 = "SDL1";
		String MAKE_2 = "SDL2";
    	makeList.add(MAKE_1);
    	makeList.add(MAKE_2);

    	mockSdlSecurityBase.setMakeList(makeList);
    	
    	assertNotNull(Test.NOT_NULL, makeList);
    	assertEquals(Test.MATCH, makeList, mockSdlSecurityBase.getMakeList());
	}
	
	public void testHandleInitResult() {
		byte testWiproVersion = (byte) 0x0B;
		boolean testInitResult = true;
		MockInterfaceBroker interfaceBroker = new MockInterfaceBroker();
		BaseTransportConfig transportConfig = new BTTransportConfig(true);
		MockSdlSecurityBase mockSdlSecurityBase = new MockSdlSecurityBase();
		
		SdlSession testSdlSession = SdlSession.createSession(testWiproVersion,interfaceBroker,
				transportConfig, null, null);
		
		assertNotNull(Test.NOT_NULL, mockSdlSecurityBase);
		assertNotNull(Test.NOT_NULL, testSdlSession);
		
		testSdlSession.setSdlSecurity(mockSdlSecurityBase);

		mockSdlSecurityBase.handleSdlSession(testSdlSession);
		
		assertEquals(Test.MATCH, mockSdlSecurityBase.getSdlSession(), testSdlSession);
		assertEquals(Test.MATCH, mockSdlSecurityBase.getSdlSession().getSessionId(), testSdlSession.getSessionId());
		
		mockSdlSecurityBase.handleInitResult(testInitResult);
		
		assertEquals(Test.MATCH, testInitResult, mockSdlSecurityBase.getInitSuccess());
	}
	
	public void testStartServiceListSetAndGet() {
		List<SessionType> startServiceList = new ArrayList<SessionType>();
		MockSdlSecurityBase mockSdlSecurityBase = new MockSdlSecurityBase();
		
		startServiceList.add(SessionType.RPC);
		startServiceList.add(SessionType.NAV);
		startServiceList.add(SessionType.PCM);
		startServiceList.add(SessionType.CONTROL);

    	assertNotNull(Test.NOT_NULL, startServiceList);
    	
    	mockSdlSecurityBase.setStartServiceList(startServiceList);
    	
    	assertEquals(Test.MATCH, startServiceList, mockSdlSecurityBase.getServiceList());		
	}

}

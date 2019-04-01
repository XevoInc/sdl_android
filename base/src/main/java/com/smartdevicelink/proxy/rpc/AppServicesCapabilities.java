/*
 * Copyright (c) 2019 Livio, Inc.
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * Redistributions of source code must retain the above copyright notice, this
 * list of conditions and the following disclaimer.
 *
 * Redistributions in binary form must reproduce the above copyright notice,
 * this list of conditions and the following
 * disclaimer in the documentation and/or other materials provided with the
 * distribution.
 *
 * Neither the name of the Livio Inc. nor the names of its contributors
 * may be used to endorse or promote products derived from this software
 * without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 */
package com.smartdevicelink.proxy.rpc;

import com.smartdevicelink.proxy.RPCStruct;

import java.util.Hashtable;
import java.util.List;

/**
 * Capabilities of app services including what service types are supported
 * and the current state of services.
 */
public class AppServicesCapabilities extends RPCStruct {

	public static final String KEY_APP_SERVICES = "appServices";

	// Constructors

	/**
	 * Capabilities of app services including what service types are supported
	 * and the current state of services.
	 */
	public AppServicesCapabilities(){}

	/**
	 * Capabilities of app services including what service types are supported
	 * and the current state of services.
	 * @param hash of parameters
	 */
	public AppServicesCapabilities(Hashtable<String, Object> hash) {
		super(hash);
	}

	// Setters and Getters

	/**
	 * An array of currently available services. If this is an update to the
	 * capability the affected services will include an update reason in that item
	 * @param appServices -
	 */
	public void setAppServices(List<AppServiceCapability> appServices){
		setValue(KEY_APP_SERVICES, appServices);
	}

	/**
	 * An array of currently available services. If this is an update to the
	 * capability the affected services will include an update reason in that item
	 * @return appServices
	 */
	@SuppressWarnings("unchecked")
	public List<AppServiceCapability> getAppServices(){
		return (List<AppServiceCapability>) getObject(AppServiceCapability.class,KEY_APP_SERVICES);
	}

}

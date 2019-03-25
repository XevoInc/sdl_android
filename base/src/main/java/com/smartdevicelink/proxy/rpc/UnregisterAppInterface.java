package com.smartdevicelink.proxy.rpc;

import com.smartdevicelink.protocol.enums.FunctionID;
import com.smartdevicelink.proxy.RPCRequest;

import java.util.Hashtable;

/**
 * Terminates an application's interface registration. This causes SDL&reg; to
 * dispose of all resources associated with the application's interface
 * registration (e.g. Command Menu items, Choice Sets, button subscriptions,
 * etc.)
 * 
 * <p>After the UnregisterAppInterface operation is performed, no other operations
 * can be performed until a new app interface registration is established by
 * calling <i>{@linkplain RegisterAppInterface}</i></p>
 *
 * @see RegisterAppInterface
 * @see OnAppInterfaceUnregistered
 */
public class UnregisterAppInterface extends RPCRequest {
	/**
	 * Constructs a new UnregisterAppInterface object
	 */
    public UnregisterAppInterface() {
        super(FunctionID.UNREGISTER_APP_INTERFACE.toString());
    }
	/**
	 * <p>Constructs a new UnregisterAppInterface object indicated by the Hashtable
	 * parameter</p>
	 * 
	 * 
	 * @param hash
	 *            The Hashtable to use
	 */    
    public UnregisterAppInterface(Hashtable<String, Object> hash) {
        super(hash);
    }
}
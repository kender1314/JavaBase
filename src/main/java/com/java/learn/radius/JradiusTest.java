package com.java.learn.radius;

import net.jradius.client.RadiusClient;
import net.jradius.client.auth.*;
import net.jradius.dictionary.Attr_NASIdentifier;
import net.jradius.dictionary.Attr_UserName;
import net.jradius.dictionary.Attr_UserPassword;
import net.jradius.packet.AccessAccept;
import net.jradius.packet.AccessRequest;
import net.jradius.packet.RadiusPacket;
import net.jradius.packet.attribute.AttributeFactory;
import net.jradius.packet.attribute.AttributeList;

import java.net.InetAddress;


/**
 * Radius客户端，用于用户认证
 *
 * @author Administrator
 */
public class JradiusTest {

    public static void main(String[] args) throws Exception {
        if(args.length!=4) {
            System.out.println("<host><secret><username><password>");
            System.exit(2);
        }
        InetAddress host = InetAddress.getByName(args[0]);
        boolean aa=new JradiusTest().isRadius(host, 1812, 1813, "pap",args[2] , args[3], args[1], "110.110.110.110", 3, 1);
        System.out.println("鉴权结果："+aa);
    }

    /**
     *
     * @param host
     *            The address for the radius server test.
     * @param authport
     *            Radius authentication port
     * @param acctport
     *            Radius accounting port - required by jradius
     *            but not explicitly checked
     * @param authType
     *            authentication type - pap or chap
     * @param user
     *            user for Radius authentication
     * @param password
     *            password for Radius authentication
     * @param secret
     *            Radius shared secret
     * @param timeout
     *            Timeout in milliseconds
     * @param retry
     *          Number of times to retry
     *
     * @param nasid
     *            NAS Identifier to use
     *
     * @return True if server, false if not.
     */
    @SuppressWarnings("unused")
    private boolean isRadius(final InetAddress host, final int authport, final int acctport, final String authType,
                             final String user, final String password, final String secret, final String nasid, final int retry, final int timeout) {

        boolean isRadiusServer = false;

        AttributeFactory.loadAttributeDictionary("net.jradius.dictionary.AttributeDictionaryImpl");
        try {
//            final RadiusClient rc = new RadiusClient(host, secret, authport, acctport, convertTimeoutToSeconds(timeout));
            final RadiusClient rc = new RadiusClient(host, secret, authport, acctport, timeout);

            final AttributeList attributes = new AttributeList();
            attributes.add(new Attr_UserName(user));
            attributes.add(new Attr_NASIdentifier(nasid));
            attributes.add(new Attr_UserPassword(password));

            final AccessRequest accessRequest = new AccessRequest(rc, attributes);
            final RadiusAuthenticator auth;
            if (authType.equalsIgnoreCase("chap")) {
                auth = new CHAPAuthenticator();
            } else if (authType.equalsIgnoreCase("pap")) {
                auth = new PAPAuthenticator();
            } else if (authType.equalsIgnoreCase("mschapv1")) {
                auth = new MSCHAPv1Authenticator();
            } else if (authType.equalsIgnoreCase("mschapv2")) {
                auth = new MSCHAPv2Authenticator();
            } else if (authType.equalsIgnoreCase("eapmd5")) {
                auth = new EAPMD5Authenticator();
            } else if (authType.equalsIgnoreCase("eapmschapv2")) {
                auth = new EAPMSCHAPv2Authenticator();
            } else {
//                LogUtils.warnf(this, "Unknown authenticator type '%s'", authType);
                return isRadiusServer;
            }

            RadiusPacket reply = rc.authenticate(accessRequest, auth, retry);
            isRadiusServer = reply instanceof AccessAccept;
//            LogUtils.debugf(this, "Discovered RADIUS service on %s", host.getCanonicalHostName());
        } catch (final Throwable e) {
//            LogUtils.debugf(this, e, "Error while attempting to discover RADIUS service on %s", host.getCanonicalHostName());
            isRadiusServer = false;
        }

        return isRadiusServer;
    }

}
package main.java.com.wbc.core.utils;

import java.net.URL;

import com.nimbusds.jose.jwk.source.RemoteJWKSet;

/**
 * Héritage de RemoteJWKSet pour redéfinir les timeout
 * @author Aurelien
 *
 */
public class RemoteJWKSetTimeout extends RemoteJWKSet {
	int DEFAULT_HTTP_CONNECT_TIMEOUT = 10000; // 10000 = 10s
	int DEFAULT_HTTP_READ_TIMEOUT = 10000; // 10000 = 10s
	public RemoteJWKSetTimeout(URL jwkSetURL) {
		super(jwkSetURL);
	}
}

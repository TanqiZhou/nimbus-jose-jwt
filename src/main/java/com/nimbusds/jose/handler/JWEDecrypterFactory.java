package com.nimbusds.jose.handler;


import java.security.Key;

import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.JWEDecrypter;
import com.nimbusds.jose.JWEHeader;


/**
 * JSON Web Encryption (JWE) decrypter factory.
 *
 * @author Vladimir Dzhuvinov
 * @version $version$ (2015-06-08)
 */
public interface JWEDecrypterFactory {


	/**
	 * Creates a new JWE decrypter for the specified header and key.
	 *
	 * @param header The JWE header. Not {@code null}.
	 * @param key    The key intended to verify the JWS message. Not
	 *               {@code null}.
	 *
	 * @return The JWE decrypter.
	 *
	 * @throws JOSEException If the JWE algorithm / encryption method is
	 *                       not supported or the key type doesn't match
	 *                       expected for the JWE algorithm.
	 */
	JWEDecrypter createJWEDecrypter(final JWEHeader header, final Key key)
		throws JOSEException;
}
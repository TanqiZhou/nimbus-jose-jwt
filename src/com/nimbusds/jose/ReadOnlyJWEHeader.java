package com.nimbusds.jose;


import com.nimbusds.util.Base64URL;


/**
 * Read-only view of a {@link JWEHeader JWE header}.
 *
 * @author Vladimir Dzhuvinov
 * @version $version$ (2012-09-18)
 */
public interface ReadOnlyJWEHeader extends ReadOnlyCommonSEHeader {


	/**
	 * Gets the encryption method ({@code enc}) parameter.
	 *
	 * @return The encryption method parameter, {@code null} if not 
	 *         specified.
	 */
	public Algorithm getEncryptionMethod();
	
	
	/**
	 * Gets the integrity algorithm ({@code int}) parameter.
	 *
	 * @return The integrity algorithm parameter, {@code null} if not 
	 *         specified.
	 */
	public Algorithm getIntegrityAlgorithm();
	
	
	/**
	 * Gets the key derivation function ({@code kdf}) parameter.
	 *
	 * @return The key derivation function, {@code null} if not specified.
	 */
	public Algorithm getKeyDerivationFunction();
	
	
	/**
	 * Gets the initialisation vector ({@code iv}) parameter.
	 *
	 * @return The initialisation vector parameter, {@code null} if not 
	 *         specified.
	 */
	public Base64URL getInitializationVector();
	
	
	/**
	 * Gets the Ephemeral Public Key ({@code epk}) parameter.
	 *
	 * @return The Ephemeral Public Key parameter, {@code null} if not 
	 *         specified.
	 */
	public ECKey getEphemeralPublicKey();
	
	
	/**
	 * Gets the compression algorithm ({@code zip}) parameter.
	 *
	 * @return The compression algorithm parameter, {@code null} if not 
	 *         specified.
	 */
	public CompressionAlgorithm getCompressionAlgorithm();
}

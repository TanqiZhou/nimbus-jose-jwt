/*
 * nimbus-jose-jwt
 *
 * Copyright 2012-2016, Connect2id Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use
 * this file except in compliance with the License. You may obtain a copy of the
 * License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed
 * under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR
 * CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */

package com.nimbusds.jose.util;


import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.util.Arrays;

import junit.framework.TestCase;


/**
 * Tests the byte utilities.
 */
public class ByteUtilsTest extends TestCase {


	public void testConcat() {

		byte[] a1 = { (byte)1, (byte)2 };
		byte[] a2 = { (byte)3, (byte)4 };

		byte[] out = ByteUtils.concat(a1, a2);

		assertTrue(Arrays.equals(new byte[]{(byte)1, (byte)2, (byte)3, (byte)4}, out));
	}


	public void testConcatWithNullValue() {

		byte[] a1 = { (byte)1, (byte)2 };
		byte[] a2 = null;
		byte[] a3 = { (byte)3, (byte)4 };

		byte[] out = ByteUtils.concat(a1, a2, a3);

		assertTrue(Arrays.equals(new byte[]{(byte)1, (byte)2, (byte)3, (byte)4}, out));
	}
	
	
	public void testHashTruncation()
		throws Exception {
		
		byte[] hash = MessageDigest.getInstance("SHA-256").digest("Hello, world!".getBytes(Charset.forName("UTF-8")));
		
		byte[] firstHalf  = ByteUtils.subArray(hash, ByteUtils.byteLength(0),   ByteUtils.byteLength(128));
		byte[] secondHalf = ByteUtils.subArray(hash, ByteUtils.byteLength(128), ByteUtils.byteLength(128));
		
		byte[] concat = ByteUtils.concat(firstHalf, secondHalf);
		
		assertTrue(Base64URL.encode(hash).equals(Base64URL.encode(concat)));
	}
}
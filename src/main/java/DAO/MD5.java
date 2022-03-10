package DAO;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
public class MD5 {
		
	public static String getMd5(String input)
	{
		try {
			// Static getInstance method is called with hashing MD5
			MessageDigest md = MessageDigest.getInstance("MD5");
			// digest() method is called to calculate message digest
			// of an input digest() return array of byte
			byte[] messageDigest = md.digest(input.getBytes());
			// Convert byte array into signum representation
			BigInteger no = new BigInteger(1, messageDigest);
			// Convert message digest into hex value
			String hashtext = no.toString(16);
			while (hashtext.length() < 32) {
				hashtext = "0" + hashtext;
			}
			return hashtext;
		}
		// For specifying wrong message digest algorithms
		catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}
	}
	public static String MaHoa(String input)
	{
   

	// Create a new instance of MessageDigest, using MD5. SHA and other
	// digest algorithms are also available.
	    MessageDigest alg;
		try {
			alg = MessageDigest.getInstance("MD5");
			 alg.reset();
				
				// Calculate the md5 hash for the password. md5 operates on bytes, so give
				// MessageDigest the byte verison of the string
				    alg.update(input.getBytes());
				
				// Create a byte array from the string digest
				    byte[] digest = alg.digest();
				
				// Convert the hash from whatever format it's in, to hex format
				// which is the normal way to display and report md5 sums
				// This is done byte by byte, and put into a StringBuffer
				    StringBuffer hashedpasswd = new StringBuffer();
				    String hx;
				    for (int i = 0; i < digest.length; i++) {
				        hx = Integer.toHexString(0xFF & digest[i]);
				        //0x03 is equal to 0x3, but we need 0x03 for our md5sum
				        if (hx.length() == 1) {
				            hx = "0" + hx;
				        }
				        hashedpasswd.append(hx);
				    }
				
				// Output hashedpasswd.toString()
				    System.out.println("Mat khau: "+hashedpasswd.toString());
				    return hashedpasswd.toString();
		}
	    catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}
			
		   
	}
}
package edu.escuelaing.arep.secure.app.LogService.Encrytp;

/**
 * @author Alan Marin
 */
public class Hash {
    
	/**
	 * Return a hash of the txt using a certain type(hashtype)
	 * @param txt
	 * @param hashType
	 * @return
	 */
    public static String getHash(String txt, String hashType) {
		try {
			java.security.MessageDigest md = java.security.MessageDigest
					.getInstance(hashType);
			byte[] array = md.digest(txt.getBytes());
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < array.length; ++i) {
				sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100)
						.substring(1, 3));
			}
			return sb.toString();
		} catch (java.security.NoSuchAlgorithmException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	/**
	 * Return a MD5 hash for txt
	 * @param txt
	 * @return
	 */
	public static String md5(String txt) {
		return Hash.getHash(txt, "MD5");
	}
}

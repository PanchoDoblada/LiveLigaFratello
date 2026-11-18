package utiles;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Base64;

public class Seguridad {

    // Genera un salt aleatorio de 16 bytes (128 bits)
    public static byte[] generarSalt() {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);
        return salt;
    }

    // Hashea la contraseña con PBKDF2
    public static String generarHashPassword(String password, byte[] salt,
            int iterations, int keyLength)
            throws NoSuchAlgorithmException, InvalidKeySpecException {

        PBEKeySpec spec = new PBEKeySpec(
            password.toCharArray(), salt, iterations, keyLength
        );

        try {
            SecretKeyFactory factory =
                SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");

            byte[] hash = factory.generateSecret(spec).getEncoded();

            return Base64.getEncoder().encodeToString(hash);

        } finally {
            spec.clearPassword();
        }
    }
    
    public static boolean verificarPassword(
            String password,
            String saltBase64,
            String hashGuardado,
            int iterations,
            int keyLength) {

        try {

            // Recuperar el salt original
            byte[] salt = Base64.getDecoder().decode(saltBase64);

            // Generar hash de la contraseña introducida
            String hashCalculado = generarHashPassword(
                password, salt, iterations, keyLength
            );

            // Comparar ambos hashes
            byte[] hashOriginal = Base64.getDecoder().decode(hashGuardado);
            byte[] hashNuevo = Base64.getDecoder().decode(hashCalculado);

            return java.security.MessageDigest.isEqual(
                hashOriginal, hashNuevo
            );

        } catch (Exception e) {

            return false;
        }
    }
}


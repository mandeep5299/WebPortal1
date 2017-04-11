package com.wipro.portal.util;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.crypto.*;
import javax.crypto.spec.*;

import org.apache.commons.codec.binary.Hex;

public class EncryptionUtil {
    public static String inputString="apple";
    public static String outputString="[B@270e3293";
    public static void main(String[] args) {
       /* JFrame frame = new JFrame("AES Encryption");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(600,300));

        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        Test p = new Test();

        frame.getContentPane().add(p);
        frame.pack();
        frame.setVisible(true);*/
    	EncryptionUtil encryptionUtil =new EncryptionUtil();
    
    	try {
			outputString=encryptionUtil.encrypt("squirrel123",inputString);
			System.out.println("Encrypted Password is : "+outputString);
			outputString=encryptionUtil.decrypt("squirrel123",outputString);
			System.out.println("Decrypted String is : "+outputString);
			Calendar calendar =Calendar.getInstance();
			SimpleDateFormat sdf=new SimpleDateFormat("ddmmyyyy");
			System.out.println(sdf.format(calendar.getTime()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }

   /* private JTextField in;
    private JTextArea out;

    public Test() {
        JLabel info = new JLabel("Type any String");
        in = new JTextField(20);
        JButton encrypt = new JButton("Encrypt");
        out = new JTextArea(10,40);

        out.setEditable(false);

        encrypt.addActionListener(new encryptListener());
        in.addActionListener(new encryptListener());

        add(info);
        add(in);
        add(encrypt);
        add(out);
        add(new JScrollPane(out));
    }

    private class encryptListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String data = in.getText();
            if (data.length() == 0) { }
            else
                try {
                    String en = encrypt(data);
                    out.append("Encrypted string: " + en + "\n");
                    out.append("Original String: " + decrypt(en) + "\n\n");
                } catch(Exception ex) { }
        }
    }*/

    public String asHex(byte[] buf) {
        StringBuffer strbuf = new StringBuffer(buf.length * 2);
        int i;
        for (i = 0; i < buf.length; i++) {
            if (((int) buf[i] & 0xff) < 0x10)
                strbuf.append("0");
            strbuf.append(Long.toString((int) buf[i] & 0xff, 16));
        }
        return strbuf.toString();
    }

    private SecretKeySpec skeySpec;
    private Cipher cipher;
    private byte[] encrypted;

    public String encrypt(String keyStr,String str) throws Exception {
        // Get the KeyGenerator
    	DESKeySpec dks = new DESKeySpec(keyStr.getBytes("UTF8"));
    	SecretKeyFactory kgen = SecretKeyFactory.getInstance("DES");

    	SecretKey desKey = kgen.generateSecret(dks);
       
    	
        // Instantiate the cipher
        cipher = Cipher.getInstance("DES");

        cipher.init(Cipher.ENCRYPT_MODE, desKey);
        
        encrypted = cipher.doFinal(str.getBytes("UTF8"));
        System.out.println(encrypted);
        char[] encryptedTranspherable = Hex.encodeHex(encrypted);
        return new String(encryptedTranspherable);
        /*return asHex(encrypted);*/
    }

    public String decrypt(String keyStr,String str) throws Exception {
    	DESKeySpec dks = new DESKeySpec(keyStr.getBytes("UTF8"));
    	SecretKeyFactory kgen = SecretKeyFactory.getInstance("DES");

    	SecretKey desKey = kgen.generateSecret(dks);
    	cipher = Cipher.getInstance("DES");
        cipher.init(Cipher.DECRYPT_MODE, desKey);
        byte[] bts = Hex.decodeHex(str.toCharArray());
        System.out.println(bts);
        byte[] original = cipher.doFinal(bts);
        String originalString = new String(original,"UTF8");
        return originalString;
    }

}
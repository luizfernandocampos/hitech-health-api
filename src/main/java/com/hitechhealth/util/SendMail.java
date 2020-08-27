package com.hitechhealth.util;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendMail {

	public static void sendEmail(String to, String key, String subject, String url) throws Exception {

		// Sender's email ID needs to be mentioned
		String from = "hitech.health.test.crud@gmail.com";

		// Assuming you are sending email from through gmails smtp
		String host = "smtp.gmail.com";

		// Get system properties
		Properties properties = System.getProperties();

		// Setup mail server
		properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.port", "465");
		properties.put("mail.smtp.ssl.enable", "true");
		properties.put("mail.smtp.auth", "true");

		// Get the Session object.// and pass username and password
		Session session = Session.getInstance(properties, new javax.mail.Authenticator() {

			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("hitech.health.test.crud@gmail.com", "j!klm$%O");
			}

		});

		// Used to debug SMTP issues
		session.setDebug(true);

		// Create a default MimeMessage object.
		MimeMessage message = new MimeMessage(session);

		// Set From: header field of the header.
		message.setFrom(new InternetAddress(from));

		// Set To: header field of the header.
		message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

		// Set Subject: header field
		message.setSubject(subject);

		// Send the actual HTML message.
        message.setContent(getHtmlConfirmation(key, url), "text/html");
            

		// Now set the actual message
		//message.setText(text);

		System.out.println("sending...");
		// Send message
		Transport.send(message);
		System.out.println("Sent message successfully....");

	}
	
	
	
	private static String getHtmlConfirmation(String key, String url) throws Exception  {
	String linkConfirmation = url+"/ValidateUser?k="+key;
	return 	"<!DOCTYPE html>" + 
			"<html>" + 
			"<head>" + 
			"" + 
			"  <meta charset=\"utf-8\">" + 
			"  <meta http-equiv=\"x-ua-compatible\" content=\"ie=edge\">" + 
			"  <title>Email Confirmation</title>" + 
			"  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">" + 
			"  <style type=\"text/css\">" + 
			"  /**" + 
			"   * Google webfonts. Recommended to include the .woff version for cross-client compatibility." + 
			"   */" + 
			"  @media screen {" + 
			"    @font-face {" + 
			"      font-family: 'Source Sans Pro';" + 
			"      font-style: normal;" + 
			"      font-weight: 400;" + 
			"      src: local('Source Sans Pro Regular'), local('SourceSansPro-Regular'), url(https://fonts.gstatic.com/s/sourcesanspro/v10/ODelI1aHBYDBqgeIAH2zlBM0YzuT7MdOe03otPbuUS0.woff) format('woff');" + 
			"    }" + 
			"" + 
			"    @font-face {" + 
			"      font-family: 'Source Sans Pro';" + 
			"      font-style: normal;" + 
			"      font-weight: 700;" + 
			"      src: local('Source Sans Pro Bold'), local('SourceSansPro-Bold'), url(https://fonts.gstatic.com/s/sourcesanspro/v10/toadOcfmlt9b38dHJxOBGFkQc6VGVFSmCnC_l7QZG60.woff) format('woff');" + 
			"    }" + 
			"  }" + 
			"" + 
			"  /**" + 
			"   * Avoid browser level font resizing." + 
			"   * 1. Windows Mobile" + 
			"   * 2. iOS / OSX" + 
			"   */" + 
			"  body," + 
			"  table," + 
			"  td," + 
			"  a {" + 
			"    -ms-text-size-adjust: 100%; /* 1 */" + 
			"    -webkit-text-size-adjust: 100%; /* 2 */" + 
			"  }" + 
			"" + 
			"  /**" + 
			"   * Remove extra space added to tables and cells in Outlook." + 
			"   */" + 
			"  table," + 
			"  td {" + 
			"    mso-table-rspace: 0pt;" + 
			"    mso-table-lspace: 0pt;" + 
			"  }" + 
			"" + 
			"  /**" + 
			"   * Better fluid images in Internet Explorer." + 
			"   */" + 
			"  img {" + 
			"    -ms-interpolation-mode: bicubic;" + 
			"  }" + 
			"" + 
			"  /**" + 
			"   * Remove blue links for iOS devices." + 
			"   */" + 
			"  a[x-apple-data-detectors] {" + 
			"    font-family: inherit !important;" + 
			"    font-size: inherit !important;" + 
			"    font-weight: inherit !important;" + 
			"    line-height: inherit !important;" + 
			"    color: inherit !important;" + 
			"    text-decoration: none !important;" + 
			"  }" + 
			"" + 
			"  /**" + 
			"   * Fix centering issues in Android 4.4." + 
			"   */" + 
			"  div[style*=\"margin: 16px 0;\"] {" + 
			"    margin: 0 !important;" + 
			"  }" + 
			"" + 
			"  body {" + 
			"    width: 100% !important;" + 
			"    height: 100% !important;" + 
			"    padding: 0 !important;" + 
			"    margin: 0 !important;" + 
			"  }" + 
			"" + 
			"  /**" + 
			"   * Collapse table borders to avoid space between cells." + 
			"   */" + 
			"  table {" + 
			"    border-collapse: collapse !important;" + 
			"  }" + 
			"" + 
			"  a {" + 
			"    color: #1a82e2;" + 
			"  }" + 
			"" + 
			"  img {" + 
			"    height: auto;" + 
			"    line-height: 100%;" + 
			"    text-decoration: none;" + 
			"    border: 0;" + 
			"    outline: none;" + 
			"  }" + 
			"  </style>" + 
			"" + 
			"</head>" + 
			"<body style=\"background-color: #e9ecef;\">" + 
			"" + 
			"  <!-- start preheader -->" + 
			"  <div class=\"preheader\" style=\"display: none; max-width: 0; max-height: 0; overflow: hidden; font-size: 1px; line-height: 1px; color: #fff; opacity: 0;\">" + 
			"    A preheader is the short summary text that follows the subject line when an email is viewed in the inbox." + 
			"  </div>" + 
			"  <!-- end preheader -->" + 
			"" + 
			"  <!-- start body -->" + 
			"  <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\">" + 
			"" + 
			"  " + 
			"" + 
			"    <!-- start hero -->" + 
			"    <tr>" + 
			"      <td align=\"center\" bgcolor=\"#e9ecef\">" + 
			"        <!--[if (gte mso 9)|(IE)]>" + 
			"        <table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"600\">" + 
			"        <tr>" + 
			"        <td align=\"center\" valign=\"top\" width=\"600\">" + 
			"        <![endif]-->" + 
			"        <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"max-width: 600px;\">" + 
			"          <tr>" + 
			"            <td align=\"left\" bgcolor=\"#ffffff\" style=\"padding: 36px 24px 0; font-family: 'Source Sans Pro', Helvetica, Arial, sans-serif; border-top: 3px solid #d4dadf;\">" + 
			"              <h1 style=\"margin: 0; font-size: 32px; font-weight: 700; letter-spacing: -1px; line-height: 48px;\">Confirm Your Email Address</h1>" + 
			"            </td>" + 
			"          </tr>" + 
			"        </table>" + 
			"        <!--[if (gte mso 9)|(IE)]>" + 
			"        </td>" + 
			"        </tr>" + 
			"        </table>" + 
			"        <![endif]-->" + 
			"      </td>" + 
			"    </tr>" + 
			"    <!-- end hero -->" + 
			"" + 
			"    <!-- start copy block -->" + 
			"    <tr>" + 
			"      <td align=\"center\" bgcolor=\"#e9ecef\">" + 
			"        <!--[if (gte mso 9)|(IE)]>" + 
			"        <table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"600\">" + 
			"        <tr>" + 
			"        <td align=\"center\" valign=\"top\" width=\"600\">" + 
			"        <![endif]-->" + 
			"        <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"max-width: 600px;\">" + 
			"" + 
			"          <!-- start copy -->" + 
			"          <tr>" + 
			"            <td align=\"left\" bgcolor=\"#ffffff\" style=\"padding: 24px; font-family: 'Source Sans Pro', Helvetica, Arial, sans-serif; font-size: 16px; line-height: 24px;\">" + 
			"              <p style=\"margin: 0;\">Tap the button below to confirm your email address. If you didn't create an account with <b>Hitech-Teste Crud Luiz</b>, you can safely delete this email.</p>" + 
			"            </td>" + 
			"          </tr>" + 
			"          <!-- end copy -->" + 
			"" + 
			"          <!-- start button -->" + 
			"          <tr>" + 
			"            <td align=\"left\" bgcolor=\"#ffffff\">" + 
			"              <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\">" + 
			"                <tr>" + 
			"                  <td align=\"center\" bgcolor=\"#ffffff\" style=\"padding: 12px;\">" + 
			"                    <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\">" + 
			"                      <tr>" + 
			"                        <td align=\"center\" bgcolor=\"#1a82e2\" style=\"border-radius: 6px;\">" + 
			"                          <a href=\""+linkConfirmation+"\" target=\"_blank\" style=\"display: inline-block; padding: 16px 36px; font-family: 'Source Sans Pro', Helvetica, Arial, sans-serif; font-size: 16px; color: #ffffff; text-decoration: none; border-radius: 6px;\">Confirm Email</a>" + 
			"                        </td>" + 
			"                      </tr>" + 
			"                    </table>" + 
			"                  </td>" + 
			"                </tr>" + 
			"              </table>" + 
			"            </td>" + 
			"          </tr>" + 
			"          <!-- end button -->" + 
			"" + 
			"          <!-- start copy -->" + 
			"          <tr>" + 
			"            <td align=\"left\" bgcolor=\"#ffffff\" style=\"padding: 24px; font-family: 'Source Sans Pro', Helvetica, Arial, sans-serif; font-size: 16px; line-height: 24px;\">" + 
			"              <p style=\"margin: 0;\">If that doesn't work, copy and paste the following link in your browser:</p>" + 
			"              <p style=\"margin: 0;\"><a href=\""+linkConfirmation+"\" target=\"_blank\">"+linkConfirmation+"</a></p>" + 
			"            </td>" + 
			"          </tr>" + 
			"          <!-- end copy -->" + 
			"" + 
			"          <!-- start copy -->" + 
			"          <tr>" + 
			"            <td align=\"left\" bgcolor=\"#ffffff\" style=\"padding: 24px; font-family: 'Source Sans Pro', Helvetica, Arial, sans-serif; font-size: 16px; line-height: 24px; border-bottom: 3px solid #d4dadf\">" + 
			"              <p style=\"margin: 0;\">Cheers,<br> Hitech-TesteCrud Luiz</p>" + 
			"            </td>" + 
			"          </tr>" + 
			"          <!-- end copy -->" + 
			"" + 
			"        </table>" + 
			"        <!--[if (gte mso 9)|(IE)]>" + 
			"        </td>" + 
			"        </tr>" + 
			"        </table>" + 
			"        <![endif]-->" + 
			"      </td>" + 
			"    </tr>" + 
			"    <!-- end copy block -->" + 
			"" + 
			"    <!-- start footer -->" + 
			"    <tr>" + 
			"      <td align=\"center\" bgcolor=\"#e9ecef\" style=\"padding: 24px;\">" + 
			"        <!--[if (gte mso 9)|(IE)]>" + 
			"        <table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"600\">" + 
			"        <tr>" + 
			"        <td align=\"center\" valign=\"top\" width=\"600\">" + 
			"        <![endif]-->" + 
			"        <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"max-width: 600px;\">" + 
			"" + 
			"          <!-- start permission -->" + 
			"          <tr>" + 
			"            <td align=\"center\" bgcolor=\"#e9ecef\" style=\"padding: 12px 24px; font-family: 'Source Sans Pro', Helvetica, Arial, sans-serif; font-size: 14px; line-height: 20px; color: #666;\">" + 
			"              <p style=\"margin: 0;\">You received this email because we received a request for register for your account. If you didn't request register you can safely delete this email.</p>" + 
			"            </td>" + 
			"          </tr>" + 
			"          <!-- end permission -->" + 
			"" + 
			"  " + 
			"" + 
			"        </table>" + 
			"        <!--[if (gte mso 9)|(IE)]>" + 
			"        </td>" + 
			"        </tr>" + 
			"        </table>" + 
			"        <![endif]-->" + 
			"      </td>" + 
			"    </tr>" + 
			"    <!-- end footer -->" + 
			"" + 
			"  </table>" + 
			"  <!-- end body -->" + 
			"" + 
			"</body>" + 
			"</html>";
	}

}
package fr.eni.demo.helper;

import javax.servlet.http.Cookie;

public class CookieHelper {

	public static Cookie getCookieByName(String Name, Cookie[] cookies) {
		// Pour chaque cookie
		for (Cookie cookie : cookies) {
			// Je récupère le cookie compteur
			if (cookie.getName().equals(Name)) {
				return cookie;
			}
		}
		
		return null;
	}
}

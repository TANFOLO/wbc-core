package main.java.com.wbc.core.utils;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.codec.digest.DigestUtils;


public class StringUtils extends org.apache.commons.lang.StringUtils {
	
	public static String trim(String chaine) {
		if (chaine != null) {
			chaine = chaine.trim();
		}
		return chaine;
	}
	
	public static String troncateIfMoreLongThan(String chaine, int size) {
		chaine = chaine.substring(0, Math.min(chaine.length(), size));
		return chaine;
	}
	
	public static String md5Array(byte[] array) {
		return DigestUtils.md5Hex(array);
	}
	 
	/**
	 * Enlève tous le contenu des parenthèses et des crochets + les parenthèses et les crochets
	 * Ex : "Stream #0.1[0x1e0]: Video: mpeg1video, yuv420p, 640x480 [PAR 1:1 DAR 4:3], 104857 kb/s, 25 fps, 25 tbr, 90k tbn, 25 tbc"
	 * devient : "Stream #0.1 : Video: mpeg1video, yuv420p, 640x480 , 104857 kb/s, 25 fps, 25 tbr, 90k tbn, 25 tbc"
	 * @param input_string
	 * @param parenthesis_symbol
	 * @return
	 */
	public static String remove_parenthesis(String input_string, String parenthesis_symbol){
	    if(parenthesis_symbol.contains("[]")){
	        return input_string.replaceAll("\\s*\\[[^\\]]*\\]\\s*", " ");
	    }else if(parenthesis_symbol.contains("{}")){
	        return input_string.replaceAll("\\s*\\{[^\\}]*\\}\\s*", " ");
	    }else{
	        return input_string.replaceAll("\\s*\\([^\\)]*\\)\\s*", " ");
	    }
	}
	
	/**
	 * Est ce que le paramètre passé en entrée contient de l'HTML ?
	 * @param s
	 * @return
	 */
    public static boolean isStringContentHTML(String s) {
    	
        // adapted from post by Phil Haack and modified to match better
        final String tagStart="\\<\\w+((\\s+\\w+(\\s*\\=\\s*(?:\".*?\"|'.*?'|[^'\"\\>\\s]+))?)+\\s*|\\s*)\\>";
        final String tagEnd="\\</\\w+\\>";
        final String tagSelfClosing="\\<\\w+((\\s+\\w+(\\s*\\=\\s*(?:\".*?\"|'.*?'|[^'\"\\>\\s]+))?)+\\s*|\\s*)/\\>";
        final String htmlEntity="&[a-zA-Z][a-zA-Z0-9]+;";
        final Pattern htmlPattern=Pattern.compile("("+tagStart+".*"+tagEnd+")|("+tagSelfClosing+")|("+htmlEntity+")",Pattern.DOTALL);
    	
        boolean ret=false;
        if (s != null) {
            ret=htmlPattern.matcher(s).find();
        }
        return ret;
    }
	
	 /**
     * Reads the contents of the given URL and returns it as a string.
     * @param url
     * @return
     */
    public static String urlToString(URL url) throws IOException {
        StringBuffer sb = new StringBuffer("");
        InputStream is = url.openStream();
        int n = 0;
        do {
            n = is.read();
            if (n >= 0) {
                sb.append((char) n);
            }
        } while (n >= 0);
        is.close();
        return sb.toString();
    }

    /**
	 * Limite l'espacement max à deux sauts de ligne
	 * @param text
	 * @return
	 */
	public static String limitSubline(String text) {
		if (text == null) {
			return null;
			
		} else {
			
			while (text.contains("<br /><br /><br />")) {
				text = text.replaceAll("<br /><br /><br />", "<br /><br />");
			}
			return text;
		}
	}
	

	/**
	 * Remplace les sauts de ligne par des <br /> (correspond à nl2br de PHP pour les textarea)
	 * @param text
	 * @return
	 */
	public static String nl2br(String text) {
		if (text == null) {
			return null;
		} else {
			return text.replaceAll("\n","<br />");
		}
	}
	
	
	/**
	 * Convertit la chaine de caractère passée en paramètre en UTF8
	 * @param isoString la chaine iso à convertir
	 * @return la chaine en UTF8
	 */
	public static String toUTF8(String isoString) {
		String utf8String = null;
		if (null != isoString && !isoString.equals("")) {
			try {
				byte[] stringBytesISO = isoString.getBytes("ISO-8859-1");
				utf8String = new String(stringBytesISO, "UTF-8");
			} catch(UnsupportedEncodingException e) {
				//logger.error("erreur durant la convertion de la chaine de caractère '" + isoString + "' en UTF8", e);
				utf8String = isoString;
			}
		} else {
			utf8String = isoString;
		}
		return utf8String;
	} 

	/**
	 * Convertit la chaine de caractère passée en paramètre en ISO
	 * @param isoString la chaine à convertir
	 * @return la chaine en ISO
	 */
	public static String toISO(String isoString) {
		String utf8String = null;
		if (null != isoString && !isoString.equals("")) {
			try {
				byte[] stringBytesISO = isoString.getBytes("UTF-8");
				utf8String = new String(stringBytesISO, "ISO-8859-1");
			} catch(UnsupportedEncodingException e) {
			//	logger.error("erreur durant la convertion de la chaine de caractère '" + isoString + "' en ISO", e);
				utf8String = isoString;
			}
		} else {
			utf8String = isoString;
		}
		return utf8String;
	} 

	/**
	 * Supprime tous les caractères qui ne matchent pas avec l'expression régulière
	 * @param chaine
	 * @param regexp l'expression régulière. Ex : a-zA-Z0-9
	 * @return
	 */
	public static String removeAllCharactersExeptsRegExp(String chaine, String regexp) {
		if (chaine != null) {
			chaine = chaine.replaceAll("[^" + regexp + "]", "");
		}
		return chaine;
	}
	
	
	/**
	 * Remplace tous les caractères de replaced par replacing
	 * @param s la chaine contenant les caractères à remplacer
	 * @param replaced la liste des caractères à remplacer
	 * @param replacing la liste des caractères de substitution
	 * @return la chaine s avec les caractères remplacés
	 */
	public static String replace(String s, String replaced, String replacing) {
		StringBuffer tmp = new StringBuffer(s);
		int i = 0, debut, fin;
		char c = replaced.charAt(0);
		while (i < tmp.length()) {
			while ((i < tmp.length()) && (tmp.charAt(i) != c))
				i++;
			debut = i;
			i++;
			fin = 1;
			while ((i < tmp.length()) && (fin < replaced.length()) && (tmp.charAt(i) == replaced.charAt(fin))) {
				fin++;
				i++;
			}
			if ((i <= tmp.length()) && (fin == replaced.length())) {
				tmp.replace(debut, debut+fin, replacing);
				i = debut + replacing.length();
			}
		}
		return new String(tmp);
	}


	public static String replaceA(String originalText,String subStringToFind, String subStringToReplaceWith) {
		int s = 0;
		int e = 0;

		StringBuffer newText = new StringBuffer();

		while ((e = originalText.indexOf(subStringToFind, s)) >= 0) {

			newText.append(originalText.substring(s, e));
			newText.append(subStringToReplaceWith);
			s = e + subStringToFind.length();

		}

		newText.append(originalText.substring(s));
		return newText.toString();

	} // end replace(String, String, String)


	/**
	 * Retounre une chaine de caractère compatible pour afficher dans un lien 
	 * (sans accents, sans espaces, sans parenthèses, ...
	 * @param chaine
	 * @return
	 */
	public static String SupprimerCaracteresSpeciauxPourLiens(String chaine) {
		String ret = chaine.replaceAll(" ","-").replaceAll("ù","u").replaceAll("î","i").replaceAll("é","e").replaceAll("è","e")
		.replaceAll("ê","e").replaceAll("â","a").replaceAll("à","a").replaceAll("%", "pourcent").replaceAll("ô","o").replaceAll("'","-")
		.replaceAll("À","A").replaceAll("Ä","A").replaceAll("Å","A").replaceAll("Ç","C").replaceAll("ç","c").replaceAll("É","E")
		.replaceAll("È","E").replaceAll("Ê","E").replaceAll("Ë","E").replaceAll("Ï","I").replaceAll("Ô","O").replaceAll("Ö","O")
		.replaceAll("Ù","U").replaceAll("Û","U").replaceAll("Ü","u").replaceAll("Ï","I").replaceAll("Ô","O").replaceAll("Ö","O")
		.replaceAll("[\r\n\t]+", "-").replaceAll(System.getProperty("line.separator" ),"" );
		;
		return ret;
	}


	/**
	 * Supprimer les caractères spéciaux
	 * @param chaine
	 * @return
	 */
	public static String SupprimerCaracteresSpeciauxInconnus(String chaine) {

		Map<String, String> replacementsPunct = new HashMap<String, String>();


		replacementsPunct.put("àÂ\\?", "é");
		replacementsPunct.put("â€™", "'");	
		replacementsPunct.put("àÂ ", "à");		
		replacementsPunct.put("àÂ´", "ô");		
		replacementsPunct.put("àÂ©", "é");
		replacementsPunct.put("àÂ§", "ç");
		replacementsPunct.put("Ã§", "ç");
		replacementsPunct.put("ä§", "ç");
		replacementsPunct.put("Ã©", "é");
		replacementsPunct.put("à©", "é");
		replacementsPunct.put("ä©", "é");
		replacementsPunct.put("Â©", "é");
		replacementsPunct.put("à¨", "è");
		replacementsPunct.put("Â°", "è");
		replacementsPunct.put("Ã¨", "è");
		replacementsPunct.put("à¨", "è");
		replacementsPunct.put("ä¨", "è");
		replacementsPunct.put("àª", "ê");
		replacementsPunct.put("Ãª", "ê");
		replacementsPunct.put("äª", "ê");
		replacementsPunct.put("Ã«", "ë");
		replacementsPunct.put("ä«", "ë");
		replacementsPunct.put("ÃŠ", "Ê");
		replacementsPunct.put("äŠ", "Ê");
		replacementsPunct.put("Ã‹", "Ë");
		replacementsPunct.put("ä‹", "Ë");
		replacementsPunct.put("Ã®", "î");
		replacementsPunct.put("à®", "î");
		replacementsPunct.put("ä®", "î");
		replacementsPunct.put("Ã¯", "ï");
		replacementsPunct.put("ä¯", "ï");		
		replacementsPunct.put("Ã¬", "ì");
		replacementsPunct.put("ÃŽ", "Î");
		replacementsPunct.put("äŽ", "Î");
		replacementsPunct.put("Ã²", "ò");
		replacementsPunct.put("ä²", "ò");
		replacementsPunct.put("à´", "ô");
		replacementsPunct.put("à´", "ô");
		replacementsPunct.put("Ã´", "ô");
		replacementsPunct.put("ä´", "ô");
		replacementsPunct.put("Ã¶", "ö");
		replacementsPunct.put("ä¶", "ö");
		replacementsPunct.put("Ãµ", "õ");
		replacementsPunct.put("Ã³", "ó");
		replacementsPunct.put("Ã¸", "ø");
		replacementsPunct.put("äµ", "õ");
		replacementsPunct.put("ä³", "ó");		
		replacementsPunct.put("ä¸", "ø");
		replacementsPunct.put("Ã”", "Ô");
		replacementsPunct.put("ä”", "Ô");
		replacementsPunct.put("Ã–", "Ö");
		replacementsPunct.put("ä–", "Ö");
		replacementsPunct.put("aÂ", "à");
		replacementsPunct.put("Ã¢", "â");
		replacementsPunct.put("ä¢", "â");
		replacementsPunct.put("Ã¤", "ä");
		replacementsPunct.put("ä¤", "ä");
		replacementsPunct.put("Ã¥", "å");
		replacementsPunct.put("ä¥", "å");
		replacementsPunct.put("Ã‚", "Â");
		replacementsPunct.put("ä‚", "Â");
		replacementsPunct.put("Ã„", "Ä");
		replacementsPunct.put("a§", "ç");
		replacementsPunct.put("à§", "ç");
		replacementsPunct.put("ä„", "Ä");
		replacementsPunct.put("Ã¹", "u");
		replacementsPunct.put("Ã»", "û");
		replacementsPunct.put("Ã¼", "ü");
		replacementsPunct.put("ä¼", "ü");
		replacementsPunct.put("Ã›", "Û");
		replacementsPunct.put("Ãœ", "Ü");
		replacementsPunct.put("ä¹", "u");
		replacementsPunct.put("ä»", "û");
		replacementsPunct.put("ä¼", "ü");
		replacementsPunct.put("ä¼", "ü");
		replacementsPunct.put("ä›", "Û");
		replacementsPunct.put("äœ", "Ü");
		replacementsPunct.put("Ã²", "ñ");
		replacementsPunct.put("Ã±", "ñ");	
		replacementsPunct.put("Ã\\?", "à");
		replacementsPunct.put("ä", "à");
		replacementsPunct.put("Ã", "à");

		//logger.debug("SupprimerCaracteresSpeciauxInconnus avant : " + chaine);

		if (chaine != null && !chaine.equals("")) {
			for (String ponctuation : replacementsPunct.keySet()) {
			//	logger.debug("dedans SupprimerCaracteresSpeciauxInconnus avant " + ponctuation + " : " + chaine);
				chaine = chaine.replaceAll(ponctuation, replacementsPunct.get(ponctuation));
			//	logger.debug("dedans SupprimerCaracteresSpeciauxInconnus apres " + ponctuation + " : " + chaine);
			}
		}

		//logger.debug("SupprimerCaracteresSpeciauxInconnus après : " + chaine);
		return chaine;


	}


	public String codeHTMLToUtf8(String chaine) {

		String ret = "";
		if (chaine != null) {
			ret = chaine.replaceAll(">", "-").replaceAll("<", "-").replaceAll("&oelig;", "oe").replaceAll("&icirc;", "-").replaceAll("&hellip;", "-").replaceAll("&bull;", "-").replaceAll("&ordm;", "°").replaceAll("&ecirc;", "ê").replaceAll("&nbsp;", " ").replaceAll("&ucirc;", "û").replaceAll("&acirc;", "â").replaceAll("&agrave;", "à").replaceAll("&eacute;", "é").replaceAll("&ocirc;", "ô").replaceAll("&euro;", "€").replaceAll("&dollar;", "$").replaceAll("&ccedil;", "ç").replaceAll("&egrave;", "è").replaceAll("&rsquo;", "'").replaceAll("&", "et");

		}
		return ret;

	}

	/**
	 * retourne vrai si une chaine de caratcère est null ou vide
	 * @param chaine
	 * @return
	 */
	public boolean NullOrEmpty(String chaine) {
		return (chaine == null || chaine.trim().equals(""));
	}


	/**
	 * retourne vrai si une chaine de caratcère est null ou vide
	 * @param chaine
	 * @return
	 */
	public static boolean NotNullNeitherEmpty(String chaine) {
		return (!(chaine == null || chaine.trim().equals("")));
	}


	/**
	 * tronque la chaine de caractère et ajoute trois points à la fin
	 * @param val la chaine à tronquer
	 * @param lenght la longueur de la chaine (sans les ...)
	 * @return la chaine tronquée
	 */
	public static String troncateStringWithThreePoints(String val, Integer lenght) {

		if (val != null && val.length() > lenght) {
			val = val.substring(0, lenght).concat("...");
		} 

		return val;

	}

	/**
	 * transforme tous les caratc_ères spéciaux de la chaine passé en paramètre ne leur code HTML
	 * @param s est la chaine contenant les caractères spéciaux
	 * @return la chaine contenant les codes HTML à la place des caractères spéciaux
	 */
	public static final String escapeHTML(String s){
		StringBuffer sb = new StringBuffer();
		int n = s.length();
		for (int i = 0; i < n; i++) {
			char c = s.charAt(i);
			switch (c) {
			//		         case '<': sb.append("&lt;"); break;
			//		         case '>': sb.append("&gt;"); break;
			//		         case '&': sb.append("&amp;"); break;
			//		         case '"': sb.append("&quot;"); break;
			case 'à': sb.append("&agrave;");break;
			case 'À': sb.append("&Agrave;");break;
			case 'â': sb.append("&acirc;");break;
			case 'Â': sb.append("&Acirc;");break;
			case 'ä': sb.append("&auml;");break;
			case 'Ä': sb.append("&Auml;");break;
			case 'å': sb.append("&aring;");break;
			case 'Å': sb.append("&Aring;");break;
			case 'æ': sb.append("&aelig;");break;
			case 'Æ': sb.append("&AElig;");break;
			case 'ç': sb.append("&ccedil;");break;
			case 'Ç': sb.append("&Ccedil;");break;
			case 'é': sb.append("&eacute;");break;
			case 'É': sb.append("&Eacute;");break;
			case 'è': sb.append("&egrave;");break;
			case 'È': sb.append("&Egrave;");break;
			case 'ê': sb.append("&ecirc;");break;
			case 'Ê': sb.append("&Ecirc;");break;
			case 'ë': sb.append("&euml;");break;
			case 'Ë': sb.append("&Euml;");break;
			case 'ï': sb.append("&iuml;");break;
			case 'î': sb.append("&icirc;");break;			
			case 'Ï': sb.append("&Iuml;");break;
			case 'ô': sb.append("&ocirc;");break;
			case 'Ô': sb.append("&Ocirc;");break;
			case 'ö': sb.append("&ouml;");break;
			case 'Ö': sb.append("&Ouml;");break;
			case 'ø': sb.append("&oslash;");break;
			case 'Ø': sb.append("&Oslash;");break;
			case 'ß': sb.append("&szlig;");break;
			case 'ù': sb.append("&ugrave;");break;
			case 'Ù': sb.append("&Ugrave;");break;         
			case 'û': sb.append("&ucirc;");break;         
			case 'Û': sb.append("&Ucirc;");break;
			case 'ü': sb.append("&uuml;");break;
			case 'Ü': sb.append("&Uuml;");break;
			case '®': sb.append("&reg;");break;         
			case '©': sb.append("&copy;");break;   
			case '€': sb.append("&euro;"); break; 
			//case '$': sb.append("&dollar;"); break;
			// be carefull with this one (non-breaking whitee space)
			// case ' ': sb.append("&nbsp;");break;         

			default:  sb.append(c); break;
			}
		}
		return sb.toString();
	}


	/**
	 * Génère une chaine alphanumérique de la taille passée en paramètre
	 * @param size la taille de la chaine générée
	 * @return la chaine générée
	 */
	public static String generateRandomAlphaNumericString(int size) {

		final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		Random rnd = new Random();
		StringBuilder sb = new StringBuilder(size);
		for( int i = 0; i < size; i++ ) 
			sb.append( AB.charAt( rnd.nextInt(AB.length()) ) );
		return sb.toString();

	}

	/**
	 * Génère une chaine numérique de la taille passée en paramètre
	 * @param size la taille de la chaine générée
	 * @return la chaine générée
	 */
	public static String generateRandomNumeric(int size) {

		final String AB = "0123456789";
		Random rnd = new Random();
		StringBuilder sb = new StringBuilder(size);
		for( int i = 0; i < size; i++ ) 
			sb.append( AB.charAt( rnd.nextInt(AB.length()) ) );
		return sb.toString();

	}

	/**
	 * Retourne une chaine de caractère constitué des éléments de la liste
	 * passé en paramètre, séparé par le séparateur
	 * @param list la liste des éléments à concaténer
	 * @param separator le séparateur
	 * @return elem1,elem2,elem3
	 */
	public static String separeItemOfListBySeparator(Collection<String> list, String separator) {
		String ret = "";
		boolean isFirst = true; 
		for (String i : list) { 
			if (i != null) {
				if (isFirst) { 
					ret = ret.concat(i);
					isFirst = false; 
				} else { 
					ret = ret.concat(separator).concat(i);
				} 
			}
		}
		return ret;
	} 
	
	/**
	 * Retourne une chaine de caractère constitué des éléments de la liste
	 * passé en paramètre, séparé par le séparateur
	 * @param list la liste des éléments à concaténer
	 * @param separator le séparateur
	 * @return elem1,elem2,elem3
	 */
	public static String separeItemOfListBySeparator2(Collection<String> list, String separator) {
		String ret = "";
		boolean isFirst = true; 
		for (String i : list) { 
			if (i != null) {
				if (isFirst) { 
					ret = ret.concat(i);
					isFirst = false; 
				} else { 
					ret = ret.concat(separator).concat(i);
				} 
			}
		}
		return ret;
	} 


	/**
	 * Retounrne l'extension d'un nom de fichier passé en paramètre
	 * @param fileName
	 * @return
	 */
	public static String getExtension(String fileName) {
		
		int mid= fileName.lastIndexOf(".");
		String ext=fileName.substring(mid+1,fileName.length()); 
		return ext;

	}
	

	/**
	 * Valide une couleur hexadecimale avec 3 ou 6 caractères
	 * http://stackoverflow.com/questions/23155767/how-to-check-string-is-valid-hex-color-code-in-android
	 * @param hexColorCode le code hexadécimal à vérifier
	 * @return true si le code héxa est bon, false sinon
	 */
	public static boolean validateHexacodeColor(final String hexColorCode) {
		Pattern pattern = Pattern.compile("^([A-Fa-f0-9]{6}|[A-Fa-f0-9]{3})$");
		Matcher matcher = pattern.matcher(hexColorCode);
	    return matcher.matches();
	}
	
	/**
	 * Tronque la chaine de caractè_resaux x premiers caractères, uniquement si nécessaire
	 * @param chaine
	 * @param limit
	 * @return
	 */
	public static String troncateIfNecessary(String chaine, int limit) {
		
		if (chaine != null && chaine.length() > limit) {
			return chaine.substring(0, limit);
		}
		return chaine;
	}

	
}

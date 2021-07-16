package main.java.com.wbc.core.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FilenameUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FileUtils {

	/**
	 * Logger de la classe
	 */
	private static Logger logger = LogManager.getLogger(FileUtils.class);  

	/**
	 * Retourne le MD5 d'un fichier
	 * @param file
	 * @return
	 */
	public static String md5File(File file) {

		FileInputStream fis;
		try {
			fis = new FileInputStream(file);
			String md5 = org.apache.commons.codec.digest.DigestUtils.md5Hex(fis);
			fis.close();
			return md5;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	

	public static String removeExtension(String fileName) {
		if (fileName.indexOf(".") > 0) {
			return fileName.substring(0, fileName.lastIndexOf("."));
		} else {
			return fileName;
		}
	}

	/**
	 * Créé un répertoire si il n'existe pas, et rééssaye une fois après x milliseconde
	 * @param folder
	 * @param milliseconds
	 * @return
	 */
	public static boolean createFolderIfNotExistWithRetry(File folder, Integer milliseconds) {

		if (!folder.exists()) {
			boolean createdFolder = folder.mkdirs();
			if (!folder.exists() && !createdFolder) {
				// on reessaye après 100ms (arrive quand plusieurs appels arrivent en même temps et que plusieurs création du même dossiers arrivent en même temps)
				try { 
					TimeUnit.MILLISECONDS.sleep(milliseconds);
					createdFolder = folder.mkdirs();
					if (!folder.exists() && !createdFolder) {
						logger.error("Impossible de créer le répertoire " + folder.getAbsolutePath());
						return false;
					}
				} catch (InterruptedException e) {
					logger.error("Thread interrupted");
				}

			}
		}

		return true;


	}


	public static boolean isFilenameValid(String file) {
		File f = new File(file);
		try {
			f.getCanonicalPath();
			return true;
		}
		catch (IOException e) {
			return false;
		}
	}

	/**
	 * Retourne le nom du fichier à partir de son absolute path (avec extension)
	 * @param url_path
	 * @return
	 */
	public static String getFilename(String url_path) {

		File f = new File(url_path);
		return f.getName();

	}

	/**
	 * Retourne l'extension sans le point
	 * @param absolute_path
	 * @return
	 */
	public static String getExtension(String absolute_path) {
		return FilenameUtils.getExtension(absolute_path);
	}


}

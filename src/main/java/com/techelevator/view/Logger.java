package com.techelevator.view;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Logger {
	private List<String> itemsConsumed = new ArrayList<>();
	private String fileName = "log.txt";
	private boolean deleteFile = new File(fileName).delete();
	private File logFile = new File(fileName);

	public Logger() {
		createNewFile();
	}

	private void createNewFile() {
		try {
			logFile.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void addSoundToList(String itemSound) {
		itemsConsumed.add(itemSound);
	}

	public List<String> returnListOfSounds() {
		List<String> returnList = itemsConsumed;
		itemsConsumed = new ArrayList<>();
		return returnList;

	}

	public String getCurrentTime() {
		String date = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss a").format(new Date());
		return date;
	}

	public String logEvent(String event, String balanceBeforeTransaction, String afterTransaction) {
		String logString = String.format("%-24s %-22s %-14s %-14s", getCurrentTime(), event, balanceBeforeTransaction,
				afterTransaction);

		try (Writer fileWriter = new FileWriter(logFile, true);
				BufferedWriter buffered = new BufferedWriter(fileWriter)) {
			buffered.write(logString + "\n");
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return logString;

	}

}

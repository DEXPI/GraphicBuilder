package org.dexpi.pid.imaging;

import java.util.logging.LogRecord;
import java.util.logging.SimpleFormatter;

public class TinyFormatter extends SimpleFormatter {
	@Override
	public synchronized String format(LogRecord record) {

		record.setSourceClassName("");
		return record.getMessage() + "\n";

	}

	/*
	 * @Override public String format(LogRecord record) { return
	 * record.getMessage(); }
	 */
}

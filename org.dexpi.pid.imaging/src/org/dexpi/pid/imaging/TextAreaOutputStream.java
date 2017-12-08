package org.dexpi.pid.imaging;

import java.io.IOException;
import java.io.OutputStream;

import javax.swing.JTextArea;
import javax.swing.text.BadLocationException;

import org.dexpi.pid.test.old.StandAloneTester;

public class TextAreaOutputStream extends OutputStream {

	private JTextArea textArea;

	public TextAreaOutputStream(JTextArea textArea) {
		this.textArea = textArea;
	}

	@Override
	public void write(int b) throws IOException {
		// redirects data to the text area
		textArea.append(String.valueOf((char) b));
		// scrolls the text area to the end of data
		textArea.setCaretPosition(textArea.getDocument().getLength());
		// keeps the textArea up to date
		textArea.update(textArea.getGraphics());
		
		trunkTextArea(textArea);
	}

	// ScrollBuffer
	final int SCROLL_BUFFER_SIZE = 10;

	private void trunkTextArea(JTextArea txtWin) {
		int numLinesToTrunk = txtWin.getLineCount() - SCROLL_BUFFER_SIZE;
		if (numLinesToTrunk > 0) {
			try {
//				StandAloneTester.infoBox(""+txtWin.getLineCount(), "lineCount");
				
				// TODO make this an alert
				int posOfLastLineToTrunk = txtWin.getLineEndOffset(numLinesToTrunk - 1);
				txtWin.replaceRange("", 0, posOfLastLineToTrunk);
			} catch (BadLocationException ex) {
				ex.printStackTrace();
			}
		}
	}
}
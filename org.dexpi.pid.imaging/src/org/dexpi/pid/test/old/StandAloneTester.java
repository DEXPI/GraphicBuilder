package org.dexpi.pid.test.old;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This class is the one that has to be exported as a standalone graphicbuilder-jar!
 * @MaHe08
 */

import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintStream;
import java.util.Iterator;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
import java.util.logging.Logger;
import java.util.logging.StreamHandler;

import javax.imageio.ImageIO;
import javax.imageio.ImageWriter;
import javax.imageio.stream.ImageOutputStream;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.apache.commons.io.FilenameUtils;
import org.dexpi.pid.imaging.GraphicBuilder;
import org.dexpi.pid.imaging.GraphicBuilderImageWriteListener;
import org.dexpi.pid.imaging.GraphicFactory;
import org.dexpi.pid.imaging.ImageFactory_SVG;
import org.dexpi.pid.imaging.InputRepository;
import org.dexpi.pid.imaging.JaxbErrorLogRepository;
import org.dexpi.pid.imaging.JaxbInputRepository;
import org.dexpi.pid.imaging.TextAreaOutputStream;
import org.dexpi.pid.imaging.TinyFormatter;

import net.miginfocom.layout.AC;
import net.miginfocom.layout.LC;
import net.miginfocom.swing.MigLayout;

public class StandAloneTester {

	/**
	 * Enhanced the CommandLineTester with an input-dialog in the case no xml-file
	 * is supplied. Still the command-line-functionality works!
	 * 
	 */
	private static String inputFileName = null;

	public static String INPUT_FOLDER_NAME = null;

	// private static Logger logger = LogManager.getLogger(Tester.class.getName());
	private static Logger logger = Logger.getLogger(GraphicBuilder.class.getName());

	private static JTextArea textArea;

	private static PrintStream printStreamHandle = null;

	private static JCheckBox handleForImageMapBox = null;

	public static void main(String[] args) throws Exception {

		if (args.length == 0) {
			// 1. Create the frame.
			JFrame.setDefaultLookAndFeelDecorated(false);
			JFrame frame = new JFrame("GraphicBuilder");

			// 2. Optional: What happens when the frame closes?
			JPanel buttonPanel = new JPanel();
			// buttonPanel.setLayout(new GridLayout(1, 2));
			buttonPanel.setLayout(new MigLayout(new LC().fillX(), new AC().align("left").gap("rel").grow().fill(),
					new AC().gap("10")));

			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			// frame.getContentPane().setLayout(new GridLayout(2, 1));
			frame.getContentPane().setLayout(new MigLayout());

			// JLabel emptyLabel = new JLabel("test");
			JButton buttonFolder = new JButton("Select folder");
			JButton buttonFile = new JButton("Select file");

			JCheckBox checkboxWriteImageMap = new JCheckBox("Write ImageMap? ", false);

			handleForImageMapBox = checkboxWriteImageMap;

			buttonFolder.addActionListener(createFolderListener());
			buttonFile.addActionListener(createFileListener());

			// 3. Create components and put them in the frame.
			buttonPanel.add(buttonFile, "Cell 0 0");
			buttonPanel.add(buttonFolder, "Cell 0 1");
			buttonPanel.add(checkboxWriteImageMap, "Cell 0 2");

			frame.getContentPane().add(buttonPanel, "Cell 0 0");
			textArea = new JTextArea(10, 80);

			JScrollPane scrollPane = new JScrollPane(textArea);

			PrintStream printStream = new PrintStream(new TextAreaOutputStream(textArea));
			printStreamHandle = printStream;

			TinyFormatter fmt = new TinyFormatter();
			StreamHandler sh = new StreamHandler(printStreamHandle, fmt);
			logger.addHandler(sh);

			System.setOut(printStream);
			System.setErr(printStream);

			frame.getContentPane().add(scrollPane, "Cell 0 1");

			// 4. Size the frame.
			frame.pack();
			frame.setLocationRelativeTo(null);

			// 5. Show it.
			frame.setVisible(true);

		} else {
			logger.info("DEXPI GraphicBuilder");

			boolean folderMode = false;
			for (String str : args) {
				logger.info(str);
				if (str.toLowerCase().equals("foldermode") || str.toLowerCase().equals("-f")
						|| str.toLowerCase().equals("-d"))
					folderMode = true;
			}

			if (folderMode) {
				folderMode();
			} else {
				inputFileName = args[0];
				if (INPUT_FOLDER_NAME != null) {
					getFileNamesFromFolder();
				} else {
					(new StandAloneTester()).startTesting();
				}
			}
		}

		// OLD
		// fileMode();
	}

	private static ActionListener createFolderListener() {
		return new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					textArea.setText("");
					folderMode();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		};
	}

	private static ActionListener createFileListener() {
		return new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					textArea.setText("");
					fileMode();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		};
	}

	private static void folderMode() throws Exception {
		JFileChooser folderChooser = new JFileChooser();
		folderChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

		File directory = null;

		try {
			folderChooser.showOpenDialog(null);
			directory = folderChooser.getSelectedFile();

			inputFileName = directory.getAbsolutePath();
		} catch (Exception e) {
			logger.info("Please select a folder!");
		}

		if (directory == null)
			return;

		infoBox("GraphicBuilder is working, this may take a few seconds.", "GB Working");
		crawlFolder(directory);
		infoBox("GraphicBuilder has finished!", "GB Finished");

		logger.info(inputFileName);

	}

	private static void crawlFolder(File directory) {
		File[] listOfFiles = directory.listFiles();

		for (File file : listOfFiles) {
			if (file.isDirectory()) {
				logger.info(file.getAbsolutePath());
				logger.info("Opening now");
				crawlFolder(file);
			} else if (file.isFile() && FilenameUtils.getExtension(file.getName()).toLowerCase().equals("xml")
					&& !file.getName().toLowerCase().contains("graphic_errors")) {
				try {
					fileModeForDirectory(file.getAbsolutePath());
				} catch (Exception e) {
					logger.info("Catched an exception for file:" + file.getName());
				}
			}
		}
	}

	private static void fileModeForDirectory(String input) throws Exception {
		inputFileName = input;
		try {
			(new StandAloneTester()).startTesting();

		} catch (Exception e) {
			// infoBox("GraphicBuilder caught an Exception - please contact the developer!"
			// + "\n" + e.getMessage(),
			// "GB Finished");
			throw e;
		}
	}

	private static void fileMode() throws Exception {

		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setFileFilter(new FileNameExtensionFilter("Proteus File", "xml"));

		fileChooser.showOpenDialog(null);

		try {
			File f = fileChooser.getSelectedFile();

			inputFileName = f.getAbsolutePath();
			try {
				infoBox("GraphicBuilder is working, this may take a few seconds.", "GB Working");
				(new StandAloneTester()).startTesting();
				infoBox("GraphicBuilder has finished!", "GB Finished");
			} catch (Exception e) {
				infoBox("GraphicBuilder caught an Exception - please contact the developer!" + "\n" + e.getMessage(),
						"GB Finished");
			}

		} catch (Exception e) {
			logger.info("DEXPI GraphicBuilder");
			infoBox("Please give a ProteusXML-file as argument.", "GB Error");
			logger.info("Please give a ProteusXML-file as argument.");
			// throw new Exception("Please give a ProteusXML-file as argument.");
		}
	}

	/**
	 * Simple class, that displays an information
	 * 
	 * @param infoMessage
	 * @param titleBar
	 */
	public static void infoBox(String infoMessage, String titleBar) {
		JOptionPane.showMessageDialog(null, infoMessage, "InfoBox: " + titleBar, JOptionPane.INFORMATION_MESSAGE);
	}

	/**
	 * gets all xml File Names from the given Folder
	 * 
	 * @throws Exception
	 *             exception thrown
	 */
	public static void getFileNamesFromFolder() throws Exception {
		File dir = new File(INPUT_FOLDER_NAME);
		File[] directoryListing = dir.listFiles();
		if (directoryListing != null) {
			for (File child : directoryListing) {
				inputFileName = child.getPath();
				if (inputFileName.endsWith(".xml")) {
					(new StandAloneTester()).startTesting();
				}
			}
		}
	}

	@SuppressWarnings("static-method")
	public void startTesting() throws Exception {

		File xmlFile = new File(inputFileName);
		logger.info("Starting Tester for Graphic Builder.");
		logger.info("Input file: " + inputFileName);

		// Building image from xmlFile:

		int resolutionX = 6000;

		String outputFileName = inputFileName.replaceAll(".xml", ".png");

		JaxbErrorLogRepository errorRep = new JaxbErrorLogRepository(xmlFile);
		InputRepository inputRep = new JaxbInputRepository(xmlFile);
		GraphicFactory gFac = new ImageFactory_SVG();
		// GraphicFactory gFac = new ImageFactory_PNG();
		GraphicBuilder gBuilder = new GraphicBuilder(inputRep, gFac, errorRep);
		if (printStreamHandle != null) {
			gBuilder.setOutStreamHandle(printStreamHandle);
		}
		BufferedImage image = gBuilder.buildImage(resolutionX, outputFileName);

		// Writing image now:

		// Get all possible Image Writers that are actually available for the
		// type PNG
		Iterator<ImageWriter> imageWriters = ImageIO.getImageWritersBySuffix("PNG");

		// select the first found Writer
		ImageWriter imageWriter = (ImageWriter) imageWriters.next();

		// Ok, we need the output file of course
		logger.info("Output file: " + outputFileName);
		File file = new File(outputFileName);

		// Now we define the output stream
		try (ImageOutputStream ios = ImageIO.createImageOutputStream(file)) {
			imageWriter.setOutput(ios);

			// Here we add the Listener which reports to the logger, so we can
			// see
			// the progress
			imageWriter.addIIOWriteProgressListener(new GraphicBuilderImageWriteListener());

			// Now start writing the image
			imageWriter.write(image);
		}

		if (handleForImageMapBox.isSelected()) {
			try (FileWriter writer = new FileWriter(inputFileName.replaceAll(".xml", ".imageMap.html"));) {
				try (BufferedWriter bufferedWriter = new BufferedWriter(writer)) {
					bufferedWriter.write(gBuilder.generateHTMLimageMap("TestImageMap"));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		// logger.info(builder.generateHTMLimageMap("TestImageMap"));

		logger.info("Tester finished.");

	}

	public static PrintStream getPrintStreamHandle() {
		return printStreamHandle;
	}
}

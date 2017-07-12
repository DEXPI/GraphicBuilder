package org.dexpi.pid.imaging;

import java.io.File;
import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.dexpi.pid.errorLog.xml.Error;
import org.dexpi.pid.errorLog.xml.ErrorLog;
import org.dexpi.pid.imaging.pidElements.ErrorElement;

/**
 * Generates a xml error log file. To do so, a filename and a list of
 * &lt;ErrorElement&gt; is needed.
 * 
 * @author El Pulpo
 *
 */
public class JaxbErrorLogRepository {

	private static final String ERROR_LOG_EXTENSION = ".graphic_errors.xml";
	File errorLogFile;
	ArrayList<Error> errorList = new ArrayList<Error>();

	/**
	 * creates the errorLog file
	 * 
	 * @param xmlFile
	 *            the file whose errors should be logged
	 */
	public JaxbErrorLogRepository(File xmlFile) {
		this.errorLogFile = new File(xmlFile.getAbsolutePath().replaceAll(
				".xml", ERROR_LOG_EXTENSION));
	}

	/**
	 * transforms the list of errors to a xml document
	 * 
	 * @param listOfErrors
	 *            the list of errors
	 */
	public void generateXmlErrorLog(ArrayList<ErrorElement> listOfErrors) {

		ErrorLog errorLog = new ErrorLog(this.errorLogFile.getName().replaceAll(
				"_errors.xml", ""));

		for (ErrorElement eE : listOfErrors) {

			Error error = new Error(eE.getID(), eE.getComponentName(),
					eE.getComponentClass(), "", eE.getDescription());
			if (eE.getLineNumber() != null) {
				error.setLineNumber(eE.getLineNumber());
			}
			ArrayList<Error> subErrors = new ArrayList<Error>();

			for (String subDesc : eE.getSubDescriptions()) {
				subErrors.add(new Error(subDesc));
			}
			if (subErrors.isEmpty() == false) {
				error.setListOfDescriptions(subErrors);
			}
			this.errorList.add(error);

		}
		errorLog.setListOfErrors(this.errorList);
		try {

			// create JAXB context and initializing Marshaller
			JAXBContext jaxbContext = JAXBContext.newInstance(ErrorLog.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

			// for getting nice formatted output
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,
					Boolean.TRUE);

			// Writing to XML file
			jaxbMarshaller.marshal(errorLog, this.errorLogFile);
			// Writing to console
			// jaxbMarshaller.marshal(errorLog, System.out);

		} catch (JAXBException e) {
			e.printStackTrace();
		}

	}
}
